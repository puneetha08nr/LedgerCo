package model;

import java.util.Objects;

public class AccountKey {
    String bankName;
    String borrowerName;

    public AccountKey(String bankName, String borrowerName) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
    }
    public String getBankName() {
        return bankName;
    }
    public String getBorrowerName() {
        return borrowerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountKey that = (AccountKey) o;
        return Objects.equals(getBankName(), that.getBankName()) && Objects.equals(getBorrowerName(), that.getBorrowerName());
    }

    @Override
    public int hashCode() {
        int result = getBankName() != null ? getBankName().hashCode() : 0;
        result = 31 * result + (getBorrowerName() != null ? getBorrowerName().hashCode() : 0);
        return result;
    }
}
