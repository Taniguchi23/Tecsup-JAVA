public class SavingsAccount implements Account{

    private double balance;
    private double interestRate;
    public SavingsAccount() {
        this.interestRate = 0.05;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depósito de $" + amount + " en la cuenta de ahorros. Saldo actual: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Retiro de $" + amount + " de la cuenta de ahorros. Saldo actual: $" + balance);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro de $" + amount);
        }
    }

    @Override
    public double calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interés acumulado en la cuenta de ahorros: $" + interest);
        return balance + interest;
    }
}
