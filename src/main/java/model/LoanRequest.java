package model;

public class LoanRequest {
    private String bankName, borrowerName;
    private double principle, rateOfInterest;
    private int loanDuration;

    public LoanRequest(String bankName, String borrowerName, double principle, int loanDuration, double rateOfInterest) {
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

    public int getLoanDuration() {
        return loanDuration;
    }
}
