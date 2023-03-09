package model;

public class PaymentRequest {
    private String bankName, borrowerName;
    private double lumpSum;
    private int emiNumber;

    public PaymentRequest(String bankName, String borrowerName, double lumpSum, int emiNumber) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.lumpSum = lumpSum;
        this.emiNumber = emiNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public double getLumpSum() {
        return lumpSum;
    }

    public int getEmiNumber() {
        return emiNumber;
    }
}
