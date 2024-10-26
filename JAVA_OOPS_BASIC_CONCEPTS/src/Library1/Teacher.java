package Library1;

class Teacher extends User {
	public static final int MAX1=5;
	public Teacher(String name) {
		super(name,MAX1);
	}
	@Override
	public void borrowBook(Library library, String booktitle) {
		if(borrowedBooks.size()>3) {
			System.out.println("No more books can be borrrowed!! ");
			
		}
        Book book = library.borrowBook(booktitle);
        borrowedBooks.add(book);
        System.out.println(name + " has successfully borrowed '" + booktitle + "'.");
			
	}
	

}
