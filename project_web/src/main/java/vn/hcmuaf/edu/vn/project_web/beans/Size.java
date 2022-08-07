package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Size {
    private String size_id;
    private String size_name;
    private Timestamp create_date;
    private Timestamp update_date;

    public Size(String size_id, String size_name, Timestamp create_date, Timestamp update_date) {
        this.size_id = size_id;
        this.size_name = size_name;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getSize_id() {
        return size_id;
    }

    public String getSize_name() {
        return size_name;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setSize_id(String size_id) {
        this.size_id = size_id;
    }

    public void setSize_name(String size_name) {
        this.size_name = size_name;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Size{" +
                "size_id='" + size_id + '\'' +
                ", size_name='" + size_name + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
