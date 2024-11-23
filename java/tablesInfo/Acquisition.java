package tablesInfo;

import java.sql.Date;

public class Acquisition {
    public String acquisitionId;
    public Date acquisitionDate;
    public String supplierName;
    public double acquisitionPrice;
    public int copiesAcquired;
    public String archivistId;
    public String isbn;
    public String branchDelivered;
    public String status;

    public Acquisition(String acquisitionId, Date acquisitionDate, String supplierName, double acquisitionPrice,
                       int copiesAcquired, String archivistId, String isbn, String branchDelivered, String status) {
        this.acquisitionId = acquisitionId;
        this.acquisitionDate = acquisitionDate;
        this.supplierName = supplierName;
        this.acquisitionPrice = acquisitionPrice;
        this.copiesAcquired = copiesAcquired;
        this.archivistId = archivistId;
        this.isbn = isbn;
        this.branchDelivered = branchDelivered;
        this.status = status;
    }
}
