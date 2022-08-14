package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Review {
    private String review_id;
    private String product_id;
    private String username;
    private int star_number;
    private String content;
    private Timestamp create_date;
    private Timestamp update_date;

    public Review(String review_id, String product_id, String username, int star_number, String content, Timestamp create_date, Timestamp update_date) {
        this.review_id = review_id;
        this.product_id = product_id;
        this.username = username;
        this.star_number = star_number;
        this.content = content;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getReview_id() {
        return review_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getUsername() {
        return username;
    }

    public int getStar_number() {
        return star_number;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStar_number(int star_number) {
        this.star_number = star_number;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
}
