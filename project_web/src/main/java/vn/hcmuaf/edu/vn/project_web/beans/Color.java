package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Color {
    private String color_id;
    private String color_name;
    private Timestamp create_date;
    private Timestamp update_date;

    public Color(String color_id, String color_name, Timestamp create_date, Timestamp update_date) {
        this.color_id = color_id;
        this.color_name = color_name;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getColor_id() {
        return color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
}
