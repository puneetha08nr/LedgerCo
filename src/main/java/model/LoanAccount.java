package model;

public class LoanAccount {
    private String bankName, borrowerName;
    private double principle, rateOfInterest;
    private int loanDuration;

    private int emiNumber;
    private double lumpSum;

    public LoanAccount(String bankName, String borrowerName, double principle, double rateOfInterest, int loanDuration) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principle = principle;
        this.rateOfInterest = rateOfInterest;
        this.loanDuration = loanDuration;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public double getPrinciple() {
        return principle;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public int getLoanDuration() { return loanDuration; }

    public int getEmiNumber() { return emiNumber; }

    public double getLumpSum() { return lumpSum; }

    public void setEmiNumber(int emiNumber) {
        this.emiNumber = emiNumber;
    }

    public void setLumpSum(double lumpSum) {
        this.lumpSum = lumpSum;
    }
}
