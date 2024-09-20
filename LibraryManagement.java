import java.util.*;
public class LibraryManagement {
    
}

class Book{
    private String title;
    private boolean isAvailable;
    public Book(String title){
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle(){
        return title;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void setAvailable(boolean available){
        isAvailable = available;
    }
}

class Library{
    private final List<Book>books = new ArrayList<>();

    public Library(List<Book> books){
        this.books.addAll(books);
    }

    public void displayAvailableBooks(){
        System.out.println("All the available books are:- ");
        for(Book book:books){
            String status = book.isAvailable()?"Available":"Not Available";
            System.out.println(book.getTitle()+ "(" + status + ")");
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

    public void returnBook(Book book){
        book.setAvailable(true);
    }
}

abstract class User{
    protected String name;
    protected int maxBooksAllowed;
    protected List<Book>borrowedBooks = new ArrayList<>();
    public User(String name, int maxBooksAllowed){
        this.name = name;
        this.maxBooksAllowed = maxBooksAllowed;
    }

    public String getName(){
        return name;
    }

    public List<Book> borrowedBooks(){
        return borrowedBooks;
    }

    public abstract void borrowBook(Library library, String bookTitle);

    public void returnBook(Library library, String bookTitle){
        for(Book book:borrowedBooks){
            if(book.getTitle().equals(bookTitle)){
                borrowedBooks.remove(book);
                library.returnBook(book);
                System.out.println(name + " has successfully returned '" + bookTitle + "'.");
                return;
            }


        }
        System.out.println("Error: " + name + " has not borrowed '" + bookTitle + "'.");
    }

    public void checkBorrowedBooks(){
        if(borrowedBooks.isEmpty()){
            System.err.println("No books has been borrowed till now. ");
        }
        else{
            for(Book book : borrowedBooks){
                System.out.println(book.getTitle());
            }
        }
    }

}


class Student extends User{
    public static final int MAX_BOOKS = 3;

    public Student(String name) {
        super(name, MAX_BOOKS);
    }

    @Override
    public void borrowBook(Library library, String bookTitle){
        if(borrowedBooks.size() > MAX_BOOKS)
        {
            System.out.println("Nope");
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
    public void borrowBook(Library library, String bookTitle)  {
        if (borrowedBooks.size() >= MAX_BOOKS) {
            System.err.println("Nope");
        }
        Book book = library.borrowBook(bookTitle);
        borrowedBooks.add(book);
        System.out.println(name + " has successfully borrowed '" + bookTitle + "'.");
    }
}