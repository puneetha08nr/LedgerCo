package service;

import model.AccountKey;
import model.LoanAccount;
import model.LoanRequest;
import repository.LoanAccountRepository;

public class LoanAccountService {

    private LoanAccountRepository loanAccountRepository;

    public LoanAccountService(LoanAccountRepository loanAccountRepository) {
        this.loanAccountRepository = loanAccountRepository;
    }

    public void createAccount(LoanRequest loanRequest) {
        AccountKey accountKey = new AccountKey(loanRequest.getBankName(),
            loanRequest.getBorrowerName());
        LoanAccount loanAccount = new LoanAccount(loanRequest.getBankName(),
            loanRequest.getBorrowerName(), loanRequest.getPrinciple(),
            loanRequest.getRateOfInterest(), loanRequest.getLoanDuration());
        loanAccountRepository.insert(accountKey, loanAccount);
    }
}
