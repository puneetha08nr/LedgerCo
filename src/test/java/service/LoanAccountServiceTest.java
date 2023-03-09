package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.AccountKey;
import model.LoanAccount;
import model.LoanRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.LoanAccountRepository;

class LoanAccountServiceTest {

    private LoanAccountService loanAccountService;

    private LoanAccountRepository loanAccountRepository;

    @BeforeEach
    void setUp() {
        loanAccountRepository = new LoanAccountRepository();
        loanAccountService = new LoanAccountService(loanAccountRepository);
    }

    @Test
    void expectToInsertNewLoanAccount() {
        LoanRequest loanRequest = new LoanRequest("bankName", "borrowerName", 5000.0, 1, 6);

        loanAccountService.createAccount(loanRequest);
        LoanAccount loanAccount = loanAccountRepository
            .getLoanAccount(new AccountKey("bankName", "borrowerName"));

        assertEquals(loanAccount.getPrinciple(), 5000.0);
    }
}