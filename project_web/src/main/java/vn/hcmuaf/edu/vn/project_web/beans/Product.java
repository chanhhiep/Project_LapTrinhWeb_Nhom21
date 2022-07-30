package vn.hcmuaf.edu.vn.project_web.beans;

import java.util.List;

public class Product {
    public String product_id ;
    public String product_name ;
    public String product_category ;
    public double price ;
    public double rateDiscount ;
    public String promotion_id ;
    public String color_id ;
    public String size_id ;
    public String brand ;
    public String category ;
    public int Inventory_quantity ;
    public String description ;
    public int active ;
    public int quantitySold  = 1;
    public String imageMain ;
    public List<String> images ;

    public Product(String product_id, String product_name, String product_category, double price, double rateDiscount, String promotion_id, String color_id, String size_id, String brand, String category, int inventory_quantity, String description, int active) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_category = product_category;
        this.price = price;
        this.rateDiscount = rateDiscount;
        this.promotion_id = promotion_id;
        this.color_id = color_id;
        this.size_id = size_id;
        this.brand = brand;
        this.category = category;
        Inventory_quantity = inventory_quantity;
        this.description = description;
        this.active = active;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_category() {
        return product_category;
    }

    public double getPrice() {
        return price;
    }

    public double getRateDiscount() {
        return rateDiscount;
    }

    public String getPromotion_id() {
        return promotion_id;
    }

    public String getColor_id() {
        return color_id;
    }

    public String getSize_id() {
        return size_id;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getInventory_quantity() {
        return Inventory_quantity;
    }

    public String getDescription() {
        return description;
    }

    public int getActive() {
        return active;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRateDiscount(double rateDiscount) {
        this.rateDiscount = rateDiscount;
    }

    public void setPromotion_id(String promotion_id) {
        this.promotion_id = promotion_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public void setSize_id(String size_id) {
        this.size_id = size_id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInventory_quantity(int inventory_quantity) {
        Inventory_quantity = inventory_quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
