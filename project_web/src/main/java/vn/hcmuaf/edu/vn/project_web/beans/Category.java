package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Category {
    private String category_id;
    private String category_name;
    private Timestamp create_date;
    private Timestamp update_date;

    public Category(String category_id, String category_name, Timestamp create_date, Timestamp update_date) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
}
