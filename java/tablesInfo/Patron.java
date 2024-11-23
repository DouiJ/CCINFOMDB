package tablesInfo;

public class Patron {
    public String patron_id;
    public String last_name;
    public String first_name;
    public String age;
    public String gender;
    public String phone_no;
    public String email;

    public Patron(String patron_id, String last_name, String first_name, String age, String gender, String phone_no, String email) {
        this.patron_id = patron_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.age = age;
        this.gender = gender;
        this.phone_no = phone_no;
        this.email = email;
    }
}