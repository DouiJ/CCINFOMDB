package tablesInfo;

public class Inventory {
    public String inventoryId;
    public String isbn;
    public String branchId;
    public String acquisitionId;

    public Inventory(String inventoryId, String isbn, String branchId, String acquisitionId) {
        this.inventoryId = inventoryId;
        this.isbn = isbn;
        this.branchId = branchId;
        this.acquisitionId = acquisitionId;
    }
}