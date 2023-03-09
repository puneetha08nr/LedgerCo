package service;

import model.AccountKey;
import model.BalanceRequest;
import model.BalanceResponse;
import model.LoanAccount;
import model.PaymentRequest;
import repository.LoanAccountRepository;
import util.EMICalculator;

public class PaymentService {

    private LoanAccountRepository loanAccountRepository;
    private EMICalculator emiCalculator;

    public PaymentService(LoanAccountRepository loanAccountRepository, EMICalculator emiCalculator) {
        this.loanAccountRepository = loanAccountRepository;
        this.emiCalculator = emiCalculator;
    }

    public void makePayment(PaymentRequest payment) {
        AccountKey accountKey = new AccountKey(payment.getBankName(), payment.getBorrowerName());
        loanAccountRepository.updatePaymentData(accountKey, payment.getLumpSum(), payment.getEmiNumber());
    }

    public BalanceResponse getBalance(BalanceRequest balanceRequest) {
        AccountKey accountKey = new AccountKey(balanceRequest.getBankName(),
            balanceRequest.getBorrowerName());
        LoanAccount loanAccount = loanAccountRepository.getLoanAccount(accountKey);
        if (loanAccount == null) {
            return new BalanceResponse("Invalid User");
        }
        return emiCalculator.processBalanceRequest(loanAccount, balanceRequest);
    }
}
