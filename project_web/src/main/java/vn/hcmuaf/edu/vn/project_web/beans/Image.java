package vn.hcmuaf.edu.vn.project_web.beans;

import java.sql.Timestamp;

public class Image {
    private String image_id;
    private String image_link;
    private Timestamp create_date;
    private int update_date;

    public Image(String image_id, String image_link, Timestamp create_date, int update_date) {
        this.image_id = image_id;
        this.image_link = image_link;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public String getImage_id() {
        return image_id;
    }

    public String getImage_link() {
        return image_link;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public int getUpdate_date() {
        return update_date;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(int update_date) {
        this.update_date = update_date;
    }
}
