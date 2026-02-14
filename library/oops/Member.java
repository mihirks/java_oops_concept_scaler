package oops;

public class Member extends User{
    private int borrowedBooksCount;

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    static final int MAX_BORROW_LIMIT = 1;

    @Override
    public void displayDashboard() {
        System.out.println( super.getName() + " Dashboard");
        System.out.println("Books borrowed" + borrowedBooksCount);
    }

    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }

    @Override
    public boolean canBorrowBooks() {
        if(this.borrowedBooksCount < MAX_BORROW_LIMIT){
            return true;
        }
        return false;
    }

    public Member(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }

    public Member() {
        borrowedBooksCount=0;
    }

    public Member(String userId, String name) {
        super(userId, name);
        borrowedBooksCount=0;
    }
    
    
}
