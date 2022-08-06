package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class PaymentMethod {
    public String payment_id;
    public String payment_name;
    public Timestamp create_date;
    public Timestamp update_date;

    public PaymentMethod(String payment_id, String payment_name, Timestamp create_date, Timestamp update_date) {
        this.payment_id = payment_id;
        this.payment_name = payment_name;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public void setPayment_name(String payment_name) {
        payment_name = payment_name;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "payment_id='" + payment_id + '\'' +
                ", Payment_name='" + payment_name + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
