package vn.hcmuaf.edu.vn.project_web.beans;

public class User {
    public String username ;
    public String password ;
    public String role ;
    public String email ;
    public int customer_id;
    public int active ;
    public String token ;

    public User(String username, String password, String role, String email, int customer_id, int active, String token) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.customer_id = customer_id;
        this.active = active;
        this.token = token;
    }
}
