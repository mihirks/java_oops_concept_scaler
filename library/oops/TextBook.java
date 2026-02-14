package oops;

public class TextBook extends Book{
    private String subject;
    private int edition;
    
    @Override
    void displayBookDetails() {
        System.out.println(subject + edition);
    }

    public TextBook(String isbn, String title, String author, String subject, int edition,String bookType) {
        super(isbn, title, author, bookType);
        this.subject = subject;
        this.edition = edition;
    }

    public TextBook(Book other, String subject, int edition) {
        super(other);
        this.subject = subject;
        this.edition = edition;
    }

//    public oops.TextBook(String subject, int edition) {
//        this.subject = subject;
//        this.edition = edition;
//    }
    
}
