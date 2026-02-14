public abstract class Book implements Lendable{
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private BookType bookType;
    private User owner=null;

    public BookType getBookType() {
        return bookType;
    }

    @Override
    public boolean lend(User user) {
        if(!user.canBorrowBooks()){
            System.out.println("You can't borrow this book, your limit is exceeded");
        }
        else if(isAvailable && user.canBorrowBooks() && owner == null){
            System.out.println(title + " " + author + " " + isbn + " is given to " + user.getName());
            isAvailable =false;
            owner = user;
            return true;
        } else if (!isAvailable && owner==user) {
            System.out.println(title + " " + author + " " + isbn + " , you already have this book. " + user.getName());
        } else if (isAvailable) {
            System.out.println("Book is already borrowed by someone else.");
        }
        return false;
    }
    abstract void displayBookDetails();
    @Override
    public void returnBook(User user) {
        if(!isAvailable && owner == user){
            isAvailable=true;
            owner = null;
            System.out.println("You have successfully returned " + title + " " + author + " " + isbn + " " + user.getName());
        }
        else if(isAvailable){
            System.out.println("Book is already available , not returning possible");
        }
        else {
            System.out.println("Book is not given to this User " + user.getName());
        }

    }

    public Book(String isbn, String title, String author, String bookType) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        try {
            this.bookType = BookType.valueOf(bookType.toUpperCase());
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid book type. Try again.");
        }
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }
    public Book(Book other){
        this.isbn=other.isbn;
        this.title=other.title;
        this.isAvailable=true;
        this.author=other.author;
        this.bookType=other.bookType;
    }
//    public Book() {
//        this.isAvailable=true;
//    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
}
