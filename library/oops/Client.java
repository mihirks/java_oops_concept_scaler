package oops;

public class Client {
    public static void main(String[] args) {
        Member m1= new Member("raj","rajesh");
        Member m2= new Member("rk","rk");
//        m1.displayDashboard();
//        m2.displayDashboard();
        Librarian l1= new Librarian("344");
//        l1.displayDashboard();

        NovelBook novelBook = new NovelBook("e32","Life is great","Shiva","Life","NOVELBOOK");
        NovelBook novelBook1 = new NovelBook("m21","Games","Unity","COC","TEXTBOOK");
//        novelBook1.displayBookDetails();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.addBook(novelBook);
        libraryManagementSystem.addBook(novelBook1);
        libraryManagementSystem.registerUser(m1);
        libraryManagementSystem.registerUser(m2);
        if(novelBook1.lend(m1)) {
            m1.setBorrowedBooksCount(m1.getBorrowedBooksCount()+1);
            System.out.println(m1.getBorrowedBooksCount() + " borrowed books are borrowed");
        }
        if(novelBook.lend(m1)){
            m1.setBorrowedBooksCount(m1.getBorrowedBooksCount()+1);
            System.out.println("Possible");
        }
        novelBook1.returnBook(m1);
        novelBook1.lend(l1);


        libraryManagementSystem.searchBooks("shiva");
        libraryManagementSystem.searchBooks("games","TEXTBOOK");


    }
}
