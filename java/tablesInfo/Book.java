package tablesInfo;

public class Book {
    public String isbn;
    public String title;
    public String price;
    public String authorLastName;
    public String authorFirstName;

    public Book(String isbn, String title, String price, String authorLastName, String authorFirstName) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
    }
}