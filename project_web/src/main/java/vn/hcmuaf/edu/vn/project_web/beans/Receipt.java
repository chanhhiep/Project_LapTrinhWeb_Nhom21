package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Receipt {
    private String receipt_id;
    private String customer_id;
    private String customer_name;
    private String discountcode_id;
    private double rate;
    private String payment_id;
    private String payment_name;
    private double value;
    private int state;
    private Timestamp create_date;
    private Timestamp update_date;

    public Receipt(String receipt_id, String customer_id, String customer_name, String discountcode_id, double rate, String payment_id, double value, int state, Timestamp create_date, Timestamp update_date) {
        this.receipt_id = receipt_id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.discountcode_id = discountcode_id;
        this.rate = rate;
        this.payment_id = payment_id;
        this.value = value;
        this.state = state;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getReceipt_id() {
        return receipt_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getDiscountcode_id() {
        return discountcode_id;
    }

    public double getRate() {
        return rate;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public double getValue() {
        return value;
    }

    public int getState() {
        return state;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setDiscountcode_id(String discountcode_id) {
        this.discountcode_id = discountcode_id;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receipt_id='" + receipt_id + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", discountcode_id='" + discountcode_id + '\'' +
                ", rate=" + rate +
                ", payment_id='" + payment_id + '\'' +
                ", payment_name='" + payment_name + '\'' +
                ", value=" + value +
                ", state=" + state +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
