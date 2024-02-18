public class CurrentAccount implements Account{
    private double balance;
    private double overdraftLimit;

    public CurrentAccount() {
        this.overdraftLimit = 1000;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depósito de $" + amount + " en la cuenta corriente. Saldo actual: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Retiro de $" + amount + " de la cuenta corriente. Saldo actual: $" + balance);
        } else {
            System.out.println("No se puede realizar el retiro. Límite de sobregiro alcanzado.");
        }
    }

    @Override
    public double calculateInterest() {
        System.out.println("No se generan intereses en la cuenta corriente.");
        return balance;
    }
}
