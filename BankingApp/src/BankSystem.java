import java.util.ArrayList;

public class BankSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount(String number, String holder, int pin) {
        // prevent duplicate account numbers
        boolean exists = false;
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(number)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("❌ Account number already exists!");
        } else {
            accounts.add(new BankAccount(number, holder, 0, pin));
            System.out.println("✅ Account created for " + holder);
        }
    }

    public BankAccount findAccount(String number) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(number)) {
                return acc;
            }
        }
        return null;
    }

    public void deleteAccount(String number) {
        int indexToRemove = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(number)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            accounts.remove(indexToRemove);
            System.out.println("🗑️ Account deleted successfully.");
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    public void showAllAccounts() {
        if (accounts.size() == 0) {
            System.out.println("No accounts exist yet.");
        } else {
            System.out.println("\n🏦 All Bank Accounts:");
            for (BankAccount acc : accounts) {
                acc.displayDetails();
            }
        }
    }
}