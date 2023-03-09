package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.AccountKey;
import model.BalanceRequest;
import model.BalanceResponse;
import model.LoanAccount;
import model.PaymentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.LoanAccountRepository;
import util.EMICalculator;

class PaymentServiceTest {

    private PaymentService paymentService;
    private EMICalculator emiCalculator;
    private LoanAccountRepository loanAccountRepository;

    @BeforeEach
    void setUp() {
        emiCalculator = new EMICalculator();
        loanAccountRepository = new LoanAccountRepository();
        paymentService = new PaymentService(loanAccountRepository, emiCalculator);
        LoanAccount loan = new LoanAccount("bankName", "borrowerName", 5000.0, 6, 1);
        loanAccountRepository.insert(new AccountKey("bankName", "borrowerName"), loan);
    }

    @Test
    void expectToMakePaymentIfLoanAccountPresent() {
        PaymentRequest paymentRequest = new PaymentRequest("bankName", "borrowerName", 1000.0, 5);

        paymentService.makePayment(paymentRequest);
        LoanAccount loanAccount = loanAccountRepository
            .getLoanAccount(new AccountKey("bankName", "borrowerName"));

        assertEquals(loanAccount.getLumpSum(), 1000.0);
    }

    @Test
    void expectToReturnBalance() {
        BalanceRequest balanceRequest = new BalanceRequest("bankName", "borrowerName", 5);

        BalanceResponse balance = paymentService.getBalance(balanceRequest);

        assertEquals(2210, balance.getAmountPaid());
        assertEquals(7, balance.getRemainingEmis());
    }

    @Test
    void expectToReturnErrorMessageIfNoLoanAccountPresent() {
        BalanceRequest balanceRequest = new BalanceRequest("random", "borrowerName", 5);

        BalanceResponse balance = paymentService.getBalance(balanceRequest);

        assertEquals("Invalid User", balance.getErrorMessage());
    }
}