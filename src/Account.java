import java.util.ArrayList;

public abstract class Account {

    protected static final int DEFAULT_AGENCY = 1;

    protected double balance;
    protected int agency;
    protected int number;
    protected ArrayList<String> movements;
    protected Client client;

    public Account(int agency, int number, Client client) {
        this.client = client;
        this.agency = agency;
        this.number = number;
        this.balance = 0;
        this.movements = new ArrayList<>();

    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void makeTransfer(double amount, Account destination);

    public abstract void receivetransfer(double amount, String senderName);

    public abstract void printMovements();

    protected void printInfos(String type) {
        System.out.println("\n" + this.client.getName() + ". Extrato: ");
        System.out.println("Conta " + type + ": " + this.agency + " / " + this.number + "\n");
        this.movements.forEach(System.out::println);
        System.out.println("\nSeu saldo: R$" + this.balance + "\n");
    }

    public double getBalance() {
        return balance;
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

}
