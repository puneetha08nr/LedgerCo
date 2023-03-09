import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import model.BalanceRequest;
import model.BalanceResponse;
import model.LoanRequest;
import model.PaymentRequest;
import repository.LoanAccountRepository;
import service.LoanAccountService;
import service.PaymentService;
import util.EMICalculator;

enum Action {
    LOAN, PAYMENT, BALANCE
}

public class LedgerApplicationMain {

    public static void main(String[] args) throws FileNotFoundException {
        EMICalculator emiCalculator = new EMICalculator();
        LoanAccountRepository loanAccountRepository = new LoanAccountRepository();
        LoanAccountService loanAccountService = new LoanAccountService(loanAccountRepository);
        PaymentService paymentService = new PaymentService(loanAccountRepository, emiCalculator);
        Processor processor = new Processor(loanAccountService, paymentService);

        String inputFile = args[0];
        File file = new File(inputFile);
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);

        while (scanner.hasNextLine()) {
            String firstWord = scanner.next();
            if (Action.LOAN.name().equalsIgnoreCase(firstWord)) {
                LoanRequest loanRequest = new LoanRequest(scanner.next().toUpperCase(),
                    scanner.next().toUpperCase(), scanner.nextDouble(), scanner.nextInt(),
                    scanner.nextDouble());
                processor.createAccount(loanRequest);
            }
            if (Action.PAYMENT.name().equalsIgnoreCase(firstWord)) {
                PaymentRequest paymentRequest = new PaymentRequest(scanner.next().toUpperCase(),
                    scanner.next().toUpperCase(), scanner.nextDouble(), scanner.nextInt());
                processor.makePayment(paymentRequest);
            }
            if (Action.BALANCE.name().equalsIgnoreCase(firstWord)) {
                BalanceRequest balanceRequest = new BalanceRequest(scanner.next().toUpperCase(),
                    scanner.next().toUpperCase(), scanner.nextInt());
                BalanceResponse balanceResponse = processor.getBalance(balanceRequest);
                System.out.println(balanceResponse.toString());
            }
        }
        scanner.close();
    }
}
