package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Coupon {
    private String coupon_id;
    private String content;
    private double rate;
    private Timestamp create_date;
    private Timestamp update_date;

    public Coupon(String coupon_id, String content, double rate, Timestamp create_date, Timestamp update_date) {
        this.coupon_id = coupon_id;
        this.content = content;
        this.rate = rate;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public String getContent() {
        return content;
    }

    public double getRate() {
        return rate;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
}
