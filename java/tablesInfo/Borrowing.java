package tablesInfo;

import java.util.Date;

public class Borrowing {
    public String borrowId;
    public Date dateBorrowed;
    public Date dateDue;
    public Date dateReturned;
    public String borrowStatus;       // ENUM('B','O','R','L')
    public String bookId;
    public String patronId;
    public String clerkId;
    public String transactionStatus;

    public Borrowing(String borrowId, Date dateBorrowed, Date dateDue, Date dateReturned,
                     String borrowStatus, String bookId, String patronId, String clerkId,
                     String transactionStatus) {
        this.borrowId = borrowId;
        this.dateBorrowed = dateBorrowed;
        this.dateDue = dateDue;
        this.dateReturned = dateReturned;
        this.borrowStatus = borrowStatus;
        this.bookId = bookId;
        this.patronId = patronId;
        this.clerkId = clerkId;
        this.transactionStatus = transactionStatus;
    }
}
