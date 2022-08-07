package vn.hcmuaf.edu.vn.project_web.beans;

public class CartItem {
    public String cart_id;
    public Product cart_product;

    public CartItem(String cart_id, Product cart_product) {
        this.cart_id = cart_id;
        this.cart_product = cart_product;
    }

    public String getCart_id() {
        return cart_id;
    }

    public Product getCart_product() {
        return cart_product;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public void setCart_product(Product cart_product) {
        this.cart_product = cart_product;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cart_id='" + cart_id + '\'' +
                ", cart_product=" + cart_product +
                '}';
    }
    public double getTotalMoney(){
        return cart_product.price * cart_product.getQuantitySold();
    }
}
