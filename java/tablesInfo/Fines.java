package tablesInfo;

public class Fines {

    public String fineId;
    public double fineAmount;
    public String paymentDate;
    public String borrowId;
    public String clerkId;
    public String status;

    // Constructor
    public Fines(String fineId, double fineAmount, String paymentDate, String borrowId, String clerkId, String status) {
        this.fineId = fineId;
        this.fineAmount = fineAmount;
        this.paymentDate = paymentDate;
        this.borrowId = borrowId;
        this.clerkId = clerkId;
        this.status = status;
    }
}
