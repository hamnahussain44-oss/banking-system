import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankSystem system = new BankSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n══════════ Banking System ══════════");
            System.out.println("1️⃣  Create Account");
            System.out.println("2️⃣  Deposit Money");
            System.out.println("3️⃣  Withdraw Money");
            System.out.println("4️⃣  View Account Details");
            System.out.println("5️⃣  Delete Account");
            System.out.println("6️⃣  Show All Accounts");
            System.out.println("7️⃣  Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            if (choice == 1) {
                System.out.print("Enter Account Number: ");
                String number = sc.nextLine();
                System.out.print("Enter Account Holder Name: ");
                String holder = sc.nextLine();
                System.out.print("Set a 4-digit PIN: ");
                int pin = sc.nextInt();
                sc.nextLine();
                system.createAccount(number, holder, pin);

            } else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                String number = sc.nextLine();
                BankAccount acc = system.findAccount(number);
                if (acc != null && verifyPin(acc, sc)) {
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    acc.deposit(amount);
                } else if (acc == null) {
                    System.out.println("❌ Account not found.");
                }

            } else if (choice == 3) {
                System.out.print("Enter Account Number: ");
                String number = sc.nextLine();
                BankAccount acc = system.findAccount(number);
                if (acc != null && verifyPin(acc, sc)) {
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    acc.withdraw(amount);
                } else if (acc == null) {
                    System.out.println("❌ Account not found.");
                }

            } else if (choice == 4) {
                System.out.print("Enter Account Number: ");
                String number = sc.nextLine();
                BankAccount acc = system.findAccount(number);
                if (acc != null && verifyPin(acc, sc)) {
                    acc.displayDetails();
                    acc.showTransactions();
                } else if (acc == null) {
                    System.out.println("❌ Account not found.");
                }

            } else if (choice == 5) {
                System.out.print("Enter Account Number to Delete: ");
                String number = sc.nextLine();
                system.deleteAccount(number);

            } else if (choice == 6) {
                system.showAllAccounts();

            } else if (choice == 7) {
                System.out.println("👋 Exiting Banking System. Goodbye!");
                break;

            } else {
                System.out.println("❌ Invalid option, try again!");
            }
        }
    }

    private static boolean verifyPin(BankAccount acc, Scanner sc) {
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        sc.nextLine();
        if (acc.checkPin(pin)) {
            return true;
        } else {
            System.out.println("❌ Incorrect PIN.");
            return false;
        }
    }
}