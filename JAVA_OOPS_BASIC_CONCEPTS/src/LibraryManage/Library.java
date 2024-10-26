package LibraryManage;
import java.util.*;
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

    public Book borrowBook(String title)  {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return book;
                } 
            }
        }
       return null;
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
    }
}
