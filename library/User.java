public abstract class User{
    private static int generateUniqueId=0;
    private String userId;
    private String name;
    private String contactInfo;
    private static int totalUsers;

    public abstract void displayDashboard();
    public abstract boolean canBorrowBooks();
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public User() {
        totalUsers++;
        int id=generateUniqueId();
        this.userId="user" + id ;
        name="user" + id ;
        contactInfo=String.valueOf(id);

    }
    private final int generateUniqueId(){
        generateUniqueId++;
        return generateUniqueId;
    }
    public User(String userId, String name) {
        totalUsers++;
        int id=generateUniqueId();
        this.userId="user" + id ;
        this.userId = userId;
        this.name = name;
        contactInfo=String.valueOf(id);
    }
    public User(User other){
        totalUsers++;
        int id=generateUniqueId();
        this.userId="user" + id;
        this.userId = other.userId;
        this.name = other.name;
        this.contactInfo=other.contactInfo;
    }
    public static int getGenerateUniqueId() {
        return generateUniqueId++;
    }
    public static int getTotalUsers() {
        return totalUsers;
    }

}

