public class CheckingAccount extends Account {

    private static int SEQUENCE = 1;

    public CheckingAccount(Client client) {
        super(Account.DEFAULT_AGENCY, SEQUENCE++, client);
    }

    @Override
    public void deposit(double amount) {
        this.movements.add("Deposito: R$" + amount);
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (this.balance < amount) {
            System.out.println("Saldo insuficiente para saque. Seu saldo é: R$" + this.balance);
            return;
        }
        this.movements.add("Saque: R$" + amount);
        this.balance -= amount;
    }

    @Override
    public void makeTransfer(double amount, Account destination) {
        if (this.balance < amount) {
            System.out.println("Saldo insuficiente para transferecia. Seu saldo é: R$" + this.balance);
            return;
        }

        this.movements.add("Transferencia enviada para " + destination.client.getName() + ": R$ " + amount);
        this.balance -= amount;
        destination.receivetransfer(amount, this.client.getName());

    }

    @Override
    public void receivetransfer(double amount, String senderName) {
        this.movements.add("Transferencia recebida por " + senderName + ": R$ " + amount);
        this.balance += amount;
    }

    @Override
    public void printMovements() {
        this.printInfos("corrente");

    }

}
