package oops;

import java.util.ArrayList;
import java.util.List;


public class LibraryManagementSystem {
    List<Book> bookInventory = new ArrayList<>();
    List <User> registeredUsers = new ArrayList<>();

    public void addBook(Book e){
        bookInventory.add(e);

    }
    public void registerUser(User u){
        registeredUsers.add(u);
    }
    public void displayAllBooks (){
        for(Book e:bookInventory){
//            System.out.println(e);
            System.out.println(e.getAuthor() + " " + e.getTitle() + " " + e.getIsbn() + " " + e.isAvailable());
        }
    }
    public void displayRegisteredUsers (){
        for(User u:registeredUsers){
//            System.out.println(u);
            u.displayDashboard();
        }
    }
    public void searchBooks(String criteria){
        List<Book> allBooks = new ArrayList<>();
        for(Book e:bookInventory){
            String b1=e.getAuthor().toLowerCase();
            String b2=e.getTitle().toLowerCase();
            if(b1.contains(criteria) || b2.contains(criteria)){
                allBooks.add(e);
            }
        }
        for(Book e:allBooks){
            System.out.println(e.getAuthor() + " " + e.getTitle() + " " + e.getIsbn() + " " + e.isAvailable());
        }
    }
    public void searchBooks(String criteria, String type){
        try {
            BookType bookCorrect = BookType.valueOf(type.toUpperCase());
            List<Book> allBooks = new ArrayList<>();
            for(Book e:bookInventory){
                String b1=e.getAuthor().toLowerCase();
                String b2=e.getTitle().toLowerCase();
                BookType bookType=e.getBookType();
                if(bookCorrect==bookType && (b1.contains(criteria) || b2.contains(criteria))){
                    allBooks.add(e);
                }
            }
            for(Book e:allBooks){
                System.out.println(e.getAuthor() + " " + e.getTitle() + " " + e.getIsbn() + " " + e.isAvailable() + " " + e.getBookType());
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid book type. Try again.");
        }

    }

    
}
