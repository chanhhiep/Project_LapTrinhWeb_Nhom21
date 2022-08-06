package vn.hcmuaf.edu.vn.project_web.beans;

public class User {
    public String user_id;
    public String username ;
    public String password ;
    public String role ;
    public String email ;
    public String customer_id;
    public int active ;
    public String token ;

    public User(String user_id, String username, String password, String role, String email, String customer_id, int active, String token) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.customer_id = customer_id;
        this.active = active;
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public int getActive() {
        return active;
    }

    public String getToken() {
        return token;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
