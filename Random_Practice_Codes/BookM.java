import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

class BookUnavailableException extends Exception {
    public BookUnavailableException(String message) {
        super(message);
    }
}

class BorrowLimitExceededException extends Exception {
    public BorrowLimitExceededException(String message) {
        super(message);
    }
}


class Book {
    private final String title;
    private boolean isAvailable;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true; 
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
 
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}


abstract class User {
    protected String name;
    protected int maxBooksAllowed;
    protected List<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int maxBooksAllowed) {
        this.name = name;
        this.maxBooksAllowed = maxBooksAllowed;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public abstract void borrowBook(Library library, String bookTitle) throws BookUnavailableException, BorrowLimitExceededException;

    public void returnBook(Library library, String bookTitle) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(bookTitle)) {
                borrowedBooks.remove(book);
                library.returnBook(book);
                System.out.println(name + " has successfully returned '" + bookTitle + "'.");
                return;
            }
        }
        System.out.println("Error: " + name + " has not borrowed '" + bookTitle + "'.");
    }

    public void checkBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no borrowed books.");
        } else {
            System.out.println("Books borrowed by " + name + ":");
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println((i + 1) + ". " + borrowedBooks.get(i).getTitle());
            }
        }
    }
}

class Student extends User {
    public static final int MAX_BOOKS = 3;

    public Student(String name) {
        super(name, MAX_BOOKS);
    }

    @Override
    public void borrowBook(Library library, String bookTitle) throws BookUnavailableException, BorrowLimitExceededException {
        if (borrowedBooks.size() >= MAX_BOOKS) {
            throw new BorrowLimitExceededException(name + " has reached the maximum borrowing limit of " + MAX_BOOKS + " books.");
        }
        Book book = library.borrowBook(bookTitle);
        borrowedBooks.add(book);
        System.out.println(name + " has successfully borrowed '" + bookTitle + "'.");
    }
}


class Teacher extends User {
    public static final int MAX_BOOKS = 5;

    public Teacher(String name) {
        super(name, MAX_BOOKS);
    }

    @Override
    public void borrowBook(Library library, String bookTitle) throws BookUnavailableException, BorrowLimitExceededException {
        if (borrowedBooks.size() >= MAX_BOOKS) {
            throw new BorrowLimitExceededException(name + " has reached the maximum borrowing limit of " + MAX_BOOKS + " books.");
        }
        Book book = library.borrowBook(bookTitle);
        borrowedBooks.add(book);
        System.out.println(name + " has successfully borrowed '" + bookTitle + "'.");
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    public Library(List<Book> books) {
        this.books.addAll(books);
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            String status = book.isAvailable() ? "Available" : "Unavailable";
            System.out.println(book.getTitle() + " (" + status + ")");
        }
    }

    public Book borrowBook(String title) throws BookUnavailableException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return book;
                } else {
                    throw new BookUnavailableException("'" + title + "' is already borrowed.");
                }
            }
        }
        throw new BookUnavailableException("'" + title + "' does not exist in the library.");
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
    }
}


public class BookM {
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