package oops;

class Librarian extends User{
    String employeeNumber;

    @Override
    public void displayDashboard() {
        System.out.println( getName() + " Dashboard");
        System.out.println("Employee Number" + employeeNumber);
        // throw new UnsupportedOperationException("Unimplemented method 'displayDashboard'");
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }
    
    public Librarian(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Librarian(String userId, String name, String employeeNumber) {
        super(userId, name);
        this.employeeNumber = employeeNumber;
    }

    public Librarian(User other, String employeeNumber) {
        super(other);
        this.employeeNumber = employeeNumber;
    }

    void addNewBook(Book book){

    }
    void removeBook(Book book){

    }

}