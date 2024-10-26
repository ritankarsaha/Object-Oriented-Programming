package LibraryManage;

class Teacher extends User {
    public static final int MAX_BOOKS = 5;

    public Teacher(String name) {
        super(name, MAX_BOOKS);
    }

    @Override
    public void borrowBook(Library library, String bookTitle)  {
        if (borrowedBooks.size() >= MAX_BOOKS) {
            System.out.println("Not Possible");
        }
        Book book = library.borrowBook(bookTitle);
        borrowedBooks.add(book);
        System.out.println(name + " has successfully borrowed '" + bookTitle + "'.");
    }
}