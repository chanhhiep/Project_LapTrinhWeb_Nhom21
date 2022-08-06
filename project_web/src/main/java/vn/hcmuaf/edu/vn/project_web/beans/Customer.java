package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Customer {
    private String customer_id;
    private String customer_name;
    private String email;
    private String phone;
    private String address;
    private Timestamp create_date;
    private Timestamp update_date;

    public Customer(String customer_id, String customer_name, String email, String phone, String address, Timestamp create_date, Timestamp update_date) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id='" + customer_id + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
