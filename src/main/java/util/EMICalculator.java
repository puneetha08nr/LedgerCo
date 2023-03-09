package util;

import model.BalanceRequest;
import model.LoanAccount;
import model.BalanceResponse;

public class EMICalculator {

    public static final int NUMBER_OF_MONTHS = 12;
    private double lumpSum;
    private int emiNumber;
    double amountPaid;
    double amountRemaining;
    int numberOfRemainingEMI;

    public EMICalculator() {
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public int getNumberOfRemainingEMI() {
        return numberOfRemainingEMI;
    }

    public BalanceResponse processBalanceRequest(LoanAccount values,
        BalanceRequest balanceRequest) {
        int numberOfMonths = values.getLoanDuration() * NUMBER_OF_MONTHS;
        double totalAmount = getTotalAmount(values.getPrinciple(), values.getLoanDuration(),
            values.getRateOfInterest());
        double monthlyEMI = getMonthlyEMI(totalAmount, numberOfMonths);
        displayBalanceDetails(totalAmount, monthlyEMI, numberOfMonths, values, balanceRequest);
        return new BalanceResponse(balanceRequest.getBankName(),
            balanceRequest.getBorrowerName(),
            getAmountPaid(), getNumberOfRemainingEMI());
    }

    private void displayBalanceDetails(double totalAmount, double monthlyEMI, int numberOfMonths,
        LoanAccount values,
        BalanceRequest balanceRequest) {
        double amountRemainingAfterPayment = 0;
        boolean isPaymentMade = (values.getLumpSum() > 0 && values.getEmiNumber() <= balanceRequest
            .getEmiNumber());
        amountPaid = calculateAmountPaid(monthlyEMI, balanceRequest.getEmiNumber());
        amountRemaining = calculateRemainingAmount(totalAmount, amountPaid);
        numberOfRemainingEMI = (int) Math.ceil(amountRemaining / monthlyEMI);

        if (isPaymentMade) {
            if (amountRemaining < values.getLumpSum()) {
                values.setLumpSum(amountRemaining);
            }
            Math.ceil(amountPaid += values.getLumpSum());
            amountRemaining = calculateRemainingAmount(totalAmount, amountPaid);
            numberOfRemainingEMI = (int) Math.ceil(amountRemaining / monthlyEMI);
        }
    }

    private double getTotalAmount(double principle, int years, double interestRate) {
        double simpleInterestAmount = Math.ceil((principle * years * interestRate) / 100);
        return (simpleInterestAmount + principle);
    }

    private double getMonthlyEMI(double totalAmount, int numberOfMonths) {
        return Math.ceil(totalAmount / numberOfMonths);
    }

    private double calculateAmountPaid(double monthlyEMI, int emiNumber) {
        return Math.ceil(monthlyEMI * emiNumber);
    }

    private double calculateRemainingAmount(double totalAmount, double amountPaid) {
        return Math.ceil(totalAmount - amountPaid);
    }
}
