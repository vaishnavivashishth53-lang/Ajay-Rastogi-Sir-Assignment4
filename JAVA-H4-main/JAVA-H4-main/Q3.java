import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankDirectory {
    private HashMap<Integer, String> directory = new HashMap<>();

    public void addAccount(int accNo, String customerName) {
        directory.put(accNo, customerName);
        System.out.println("Account added successfully.");
        System.out.println("Account No: " + accNo + " → " + customerName);
    }

    public void getCustomer(int accNo) {
        if (directory.containsKey(accNo)) {
            System.out.println("Account No: " + accNo + " → " + directory.get(accNo));
        } else {
            System.out.println("Account number not found.");
        }
    }

    public void displayAll() {
        System.out.println("\n--- Bank Directory ---");
        if (directory.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Map.Entry<Integer, String> entry : directory.entrySet()) {
                System.out.println("Account No: " + entry.getKey() + " → " + entry.getValue());
            }
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        BankDirectory bank = new BankDirectory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    bank.addAccount(accNo, name);
                    break;
                case 2:
                    System.out.print("Enter Account No: ");
                    int searchAcc = scanner.nextInt();
                    bank.getCustomer(searchAcc);
                    break;
                case 3:
                    bank.displayAll();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}