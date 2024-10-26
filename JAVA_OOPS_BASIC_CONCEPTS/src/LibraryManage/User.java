package LibraryManage;
import java.util.*;
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

    public abstract void borrowBook(Library library, String bookTitle);

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
