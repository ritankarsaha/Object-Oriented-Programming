package Library1;
import java.util.*;
public class Library {
	
	private final List<Book> books = new ArrayList<>();
	
	public Library(List<Book> books) {
		this.books.addAll(books);
	}
	
	public void displayAllBooks() {
		System.out.println("The borrowed books in the librarty are:- ");
		for(Book book:books) {
			String status = book.isAvailable()?"Available":"Not Available";
			System.out.println(book.getTitle()+" "+status);
		}
	}
	public Book borrowBook(String title) {
		for(Book book:books) {
			if(book.getTitle().equals(title)) {
				book.setAvailable(false);
				return book;
			}
		}
		return null;
	}
	
	public void returnBook(Book book) {
		book.setAvailable(true);
		
	}
	

}
