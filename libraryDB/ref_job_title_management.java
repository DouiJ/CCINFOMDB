package libraryDB;

import java.sql.*;

public class ref_job_title_management {

//    Reference Tables
//   - Managed by System Management
//   - Create a new Reference
//   - Deactivate a Reference
//   - Update a Reference
//   - Delete a Reference
//   - List Reference Records


    public int job_id;          // VARCHAR(1) numbers 1 - 4
    public String job_title;    // VARCHAR(20) based on id - 1 - Manager, 2 - Archivist, 3 - Clerk, 4 - Tech Support
    public float salary;        // DECIMAL(6,2)

    public ref_job_title_management(){
        this.job_id = 0;
        this.job_title = "";
        this.salary = 0.0;
    }


}
