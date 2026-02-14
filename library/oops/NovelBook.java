package oops;

public class NovelBook extends Book{
    private String genre;
    @Override
    void displayBookDetails() {
        System.out.println(getIsbn() + " " + getTitle() + " " + getAuthor() + " " + this.genre);

    }
    public NovelBook(String isbn, String title, String author, String genre,String bookType) {
        super(isbn, title, author, bookType);
        this.genre = genre;
    }
//    public oops.NovelBook(oops.Book other, String genre) {
//        super(other);
//        this.genre = genre;
//    }
//    public oops.NovelBook(String genre) {
//        this.genre = genre;
//    }
    
    
}
