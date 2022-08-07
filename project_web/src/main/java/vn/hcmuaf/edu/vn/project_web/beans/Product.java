package vn.hcmuaf.edu.vn.project_web.beans;

import java.util.List;

public class Product {
    public String product_id ;
    public String product_name ;
    public String category_id ;
    public double price ;
    public double rateDiscount ;
    public String promotion_id ;
    public String color_id ;
    public String size_id ;
    public String brand ;
    public String category_name ;
    public int Inventory_quantity ;
    public String description ;
    public int active ;
    public int quantitySold  = 1;
    public String imageMain ;
    public List<String> images ;



    public Product(String product_id, String product_name, String category_id, double price, double rateDiscount, String promotion_id, String brand, String category_name, int inventory_quantity, String description, int active) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category_id = category_id;
        this.price = price;
        this.rateDiscount = rateDiscount;
        this.promotion_id = promotion_id;
        this.brand = brand;
        this.category_name = category_name;
        Inventory_quantity = inventory_quantity;
        this.description = description;
        this.active = active;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getCategory_id() {
        return category_id;
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

    public String getCategory_name() {
        return category_name;
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

    public int getQuantitySold() {
        return quantitySold;
    }

    public String getImageMain() {
        return imageMain;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
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

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
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

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", category_id='" + category_id + '\'' +
                ", price=" + price +
                ", rateDiscount=" + rateDiscount +
                ", promotion_id='" + promotion_id + '\'' +
                ", color_id='" + color_id + '\'' +
                ", size_id='" + size_id + '\'' +
                ", brand='" + brand + '\'' +
                ", category_name='" + category_name + '\'' +
                ", Inventory_quantity=" + Inventory_quantity +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", quantitySold=" + quantitySold +
                ", imageMain='" + imageMain + '\'' +
                ", images=" + images +
                '}';
    }
    public double productSellPrice(){
        double result=0;
        result=price*rateDiscount/100;
        return result;
    }
}
