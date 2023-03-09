package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.BalanceRequest;
import model.LoanAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.BalanceResponse;

class EMICalculatorTest {

    private EMICalculator emiCalculator;

    @BeforeEach
    void setUp() {
        emiCalculator = new EMICalculator();
    }

    @Test
    void processBalanceRequest() {
        BalanceRequest balanceRequest = new BalanceRequest("bankName", "borrowerName", 3);
        LoanAccount loanAccount = new LoanAccount("bankName", "borrowerName", 5000.0, 1, 6);

        BalanceResponse balanceResponse = emiCalculator
            .processBalanceRequest(loanAccount, balanceRequest);

        assertEquals(222.0, balanceResponse.getAmountPaid());
        assertEquals(69, balanceResponse.getRemainingEmis());
    }
}