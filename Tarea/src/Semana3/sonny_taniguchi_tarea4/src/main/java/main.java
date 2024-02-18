public class main {
    public static void main(String[] args) {
        Bank myBank = new Bank();


        SavingsAccount savingsAccount = new SavingsAccount();
        CurrentAccount currentAccount = new CurrentAccount();

        savingsAccount.deposit(2000);
        savingsAccount.deposit(1300);
        savingsAccount.withdraw(300);

        currentAccount.deposit(1000);
        currentAccount.deposit(500);
        currentAccount.withdraw(600);
        currentAccount.withdraw(2200);


        myBank.addAccount(savingsAccount);
        myBank.addAccount(currentAccount);

        myBank.performBankOperations();

        
        System.out.println("Saldo final de la cuenta de ahorros: $" + savingsAccount.calculateInterest());
        System.out.println("Saldo final de la cuenta corriente: $" + currentAccount.calculateInterest());


    }
}
