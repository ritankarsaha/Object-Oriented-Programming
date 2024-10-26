package Library1;
import java.util.*;
abstract class User {
	protected String name;
	protected int maxBooksAllowed;
	protected List<Book> borrowedBooks = new ArrayList<>();
	
	public User(String name, int maxAllowedBooks) {
		this.name = name;
		this.maxBooksAllowed=maxAllowedBooks;
	}
	public String getName() {
		return name;
	}
	public abstract void borrowBook(Library library, String booktitle);
	
	public void returnBook(Library library, String booktitle) {
		for(Book book:borrowedBooks) {
			if(book.getTitle().equals(booktitle)) {
				borrowedBooks.remove(book);
				library.returnBook(book);
				System.out.println(name + " has successfully returned '" + booktitle + "'.");
                return;
			}
		}
	}
	  public void checkBorrowedBooks(){
	        try {
	            if(borrowedBooks.isEmpty()){
	                throw new RuntimeException("No books borrowed.");
	            }
	            else{
	                for(Book book : borrowedBooks){
	                    System.out.println(book.getTitle());
	                }
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("No books borrowed.");
	        }
	    }
	
	

}
