package tablesInfo;

public class Employee {
    public String lastName;
    public String firstName;
    public String jobId;
    public String jobName;
    public int age;
    public String phoneNo;
    public String email;
    public java.sql.Date hireDate;
    public String fullAddress;
    public String branchId;

    public Employee(String lastName, String firstName, String jobId, int age, String phoneNo, String email, java.sql.Date hireDate, String fullAddress, String branchId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobId = jobId;
        this.age = age;
        this.phoneNo = phoneNo;
        this.email = email;
        this.hireDate = hireDate;
        this.fullAddress = fullAddress;
        this.branchId = branchId;

        switch (jobId) {
            case "M":
                this.jobName = "Manager";
                break;
            case "A":
                this.jobName = "Archivist";
                break;
            case "C":
                this.jobName = "Clerk";
                break;
            default:
                this.jobName = "Unknown";
                break;
        }
    }
}