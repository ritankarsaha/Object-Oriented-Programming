package LibraryManage;
import java.util.*;
public class LibraryManagement {
    public static void main(String[] args) {
        // Sample books
        List<Book> books = Arrays.asList(
                new Book("Java Programming"),
                new Book("Data Structures"),
                new Book("Operating Systems"),
                new Book("Compiler Design"),
                new Book("Algorithms")
        );
        Library library = new Library(books);
        Student john = new Student("John");
        Teacher drSmith = new Teacher("Dr. Smith");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Check Borrowed Books");
            System.out.println("5. Exit");
            System.out.print("Option: ");
            int option = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (option) {
                    case 1:
                        library.displayAvailableBooks();
                        break;
                    case 2:
                        System.out.print("Enter user (John/Dr. Smith): ");
                        String user = sc.nextLine();
                        System.out.print("Enter book name to borrow: ");
                        String bookTitle = sc.nextLine();
                        if (user.equals("John")) {
                            john.borrowBook(library, bookTitle);
                        } else if (user.equals("Dr. Smith")) {
                            drSmith.borrowBook(library, bookTitle);
                        }
                        break;
                    case 3:
                        System.out.print("Enter user (John/Dr. Smith): ");
                        user = sc.nextLine();
                        System.out.print("Enter book name to return: ");
                        bookTitle = sc.nextLine();
                        if (user.equals("John")) {
                            john.returnBook(library, bookTitle);
                        } else if (user.equals("Dr. Smith")) {
                            drSmith.returnBook(library, bookTitle);
                        }
                        break;
                    case 4:
                        System.out.print("Enter user (John/Dr. Smith): ");
                        user = sc.nextLine();
                        if (user.equals("John")) {
                            john.checkBorrowedBooks();
                        } else if (user.equals("Dr. Smith")) {
                            drSmith.checkBorrowedBooks();
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the Library Management System...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}