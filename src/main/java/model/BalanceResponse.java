package model;

import java.text.DecimalFormat;

public class BalanceResponse {
    private String bankName;
    private String borrowerName;
    private double amountPaid;
    private int remainingEmis;
    private String errorMessage;

    public BalanceResponse(String bankName, String borrowerName, double amountPaid, int remainingEmis) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.amountPaid = amountPaid;
        this.remainingEmis = remainingEmis;
    }

    public BalanceResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        DecimalFormat formatOutput =new DecimalFormat("####");
        return  bankName + " " +
                borrowerName + " " +
                formatOutput.format(amountPaid) + " " +
                formatOutput.format(remainingEmis);
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public int getRemainingEmis() {
        return remainingEmis;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
