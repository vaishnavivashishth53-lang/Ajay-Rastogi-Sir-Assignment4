import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    private HashMap<Integer, Integer> inventoryMap = new HashMap<>();

    public void addProduct(int id, int stock) {
        inventoryMap.put(id, stock);
        System.out.println("Product " + id + " added with stock " + stock);
    }

    public void updateStock(int id, int newStock) {
        if (inventoryMap.containsKey(id)) {
            inventoryMap.put(id, newStock);
            System.out.println("Stock updated for Product " + id + ": " + newStock);
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void displayInventory() {
        System.out.println("\n--- Current Inventory ---");
        Iterator<Map.Entry<Integer, Integer>> iterator = inventoryMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("Product ID: " + entry.getKey() + " | Stock: " + entry.getValue());
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Stock: ");
                    int stock = scanner.nextInt();
                    inventory.addProduct(id, stock);
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Stock: ");
                    int newStock = scanner.nextInt();
                    inventory.updateStock(updateId, newStock);
                    break;
                case 3:
                    inventory.displayInventory();
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