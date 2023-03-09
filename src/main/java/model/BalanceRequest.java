package model;

public class BalanceRequest {
    private String borrowerName;
    private String bankName;
    private int emiNumber;

    public BalanceRequest(String bankName, String borrowerName, int emiNumber) {
        this.borrowerName = borrowerName;
        this.bankName = bankName;
        this.emiNumber = emiNumber;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBankName() {
        return bankName;
    }

    public int getEmiNumber() {
        return emiNumber;
    }
}
