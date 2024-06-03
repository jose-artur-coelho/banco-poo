public class App {
    public static void main(String[] args) throws Exception {
        Client client = new Client("Artur");
        Client client2 = new Client("Cadu");
        Account account = new SavingsAccount(client);
        Account account2 = new CheckingAccount(client2);
        account.deposit(1000);
        account.withdraw(500);
        account.makeTransfer(500, account2);
        account.printMovements();
        account2.printMovements();

    }
}
