package repository;

import java.util.HashMap;
import java.util.Map;
import model.AccountKey;
import model.LoanAccount;

public class LoanAccountRepository {

    private Map<AccountKey, LoanAccount> loanAccounts = new HashMap<>();

    public void insert(AccountKey accountKey, LoanAccount loanAccount) {
        loanAccounts.put(accountKey, loanAccount);
    }

    public void updatePaymentData(AccountKey accountKey, double lumpSum, int emiNumber) {
        if (loanAccounts.containsKey(accountKey)) {
            loanAccounts.get(accountKey).setLumpSum(lumpSum);
            loanAccounts.get(accountKey).setEmiNumber(emiNumber);
        }
    }

    public LoanAccount getLoanAccount(AccountKey accountKey) {
        return loanAccounts.get(accountKey);
    }
}
