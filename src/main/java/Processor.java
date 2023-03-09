import model.BalanceRequest;
import model.BalanceResponse;
import model.LoanRequest;
import model.PaymentRequest;
import service.LoanAccountService;
import service.PaymentService;

public class Processor {

    private LoanAccountService loanAccountService;
    private PaymentService paymentService;

    public Processor(LoanAccountService loanAccountService, PaymentService paymentService) {
        this.loanAccountService = loanAccountService;
        this.paymentService = paymentService;
    }

    public void createAccount(LoanRequest loanRequest) {
        loanAccountService.createAccount(loanRequest);
    }

    public void makePayment(PaymentRequest paymentRequest) {
        paymentService.makePayment(paymentRequest);
    }

    public BalanceResponse getBalance(BalanceRequest balanceRequest) {
        return paymentService.getBalance(balanceRequest);
    }
}
