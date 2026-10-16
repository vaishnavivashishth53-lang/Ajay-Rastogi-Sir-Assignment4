import java.util.ArrayList;
import java.util.Scanner;

class Library {
    private ArrayList<String> books = new ArrayList<>();

    public void addBook(String title) {
        books.add(title);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks() {
        System.out.println("Current Books:");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (String book : books) {
                System.out.println(book);
            }
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String titleToAdd = scanner.nextLine();
                    library.addBook(titleToAdd);
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeBook(titleToRemove);
                    library.displayBooks();
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}