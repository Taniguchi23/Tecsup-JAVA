import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void performBankOperations() {
        for (Account account : accounts) {
            System.out.println("Saldo actual: " + account.calculateInterest());
            System.out.println("----");
        }
    }
}
