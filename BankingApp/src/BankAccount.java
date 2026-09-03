import java.util.ArrayList;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<Transaction> transactions;
    private int pin;

    public boolean checkPin(int inputPin) {
        return this.pin == inputPin;
    }

    public BankAccount(String accountNumber, String accountHolder, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("✅ Deposited £" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient funds!");
        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
            System.out.println("💸 Withdrawn £" + amount);
        }
    }

    public void displayDetails() {
        System.out.println("--------------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance: £" + balance);
        System.out.println("--------------------------------------");
    }

    public void showTransactions() {
        if (transactions.size() == 0) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History for " + accountHolder + ":");
            for (Transaction t : transactions) {
                System.out.println(" - " + t);
            }
        }
    }
}