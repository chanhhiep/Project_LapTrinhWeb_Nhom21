package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Promotion {
    private String promotion_id;
    private String promotion_name;
    private double promotion_rate;
    private String promotion_content;
    private int active;
    private Timestamp create_date;
    private Timestamp update_date;

    public Promotion(String promotion_id, String promotion_name, double promotion_rate, String promotion_content, int active, Timestamp create_date, Timestamp update_date) {
        this.promotion_id = promotion_id;
        this.promotion_name = promotion_name;
        this.promotion_rate = promotion_rate;
        this.promotion_content = promotion_content;
        this.active = active;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getPromotion_id() {
        return promotion_id;
    }

    public String getPromotion_name() {
        return promotion_name;
    }

    public double getPromotion_rate() {
        return promotion_rate;
    }

    public String getPromotion_content() {
        return promotion_content;
    }

    public int getActive() {
        return active;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setPromotion_id(String promotion_id) {
        this.promotion_id = promotion_id;
    }

    public void setPromotion_name(String promotion_name) {
        this.promotion_name = promotion_name;
    }

    public void setPromotion_rate(double promotion_rate) {
        this.promotion_rate = promotion_rate;
    }

    public void setPromotion_content(String promotion_content) {
        this.promotion_content = promotion_content;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotion_id='" + promotion_id + '\'' +
                ", promotion_name='" + promotion_name + '\'' +
                ", promotion_rate=" + promotion_rate +
                ", promotion_content='" + promotion_content + '\'' +
                ", active=" + active +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
