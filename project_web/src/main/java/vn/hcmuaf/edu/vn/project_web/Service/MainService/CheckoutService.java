package vn.hcmuaf.edu.vn.project_web.Service.MainService;

import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.CheckoutDao;
import vn.hcmuaf.edu.vn.project_web.beans.CartItem;
import vn.hcmuaf.edu.vn.project_web.beans.PaymentMethod;

import java.util.List;

public class CheckoutService {
    private static CheckoutService instance = null;
    private CheckoutService(){

    }
    public static CheckoutService getInstance() {
        if(instance==null){
            instance= new CheckoutService();
        }
        return instance;
    }
    public boolean SaveReceiptNotLogin(String coupon_id, String payment_id, double value, String customer_name, String address, String phone, String email, List<CartItem> listBuy) {
        return CheckoutDao.getInstance().SaveReceiptNotLogin(coupon_id, payment_id, value, customer_name, address, phone, email, listBuy);
    }
    public boolean SaveReceiptLogin(String coupon_id, String payment_id, double value, String customer_id, List<CartItem> listBuy){
        return CheckoutDao.getInstance().SaveReceiptLogin(coupon_id, payment_id, value, customer_id, listBuy);
    }
    public String getCoupon(String coupon_id){
        return CheckoutDao.getInstance().getCoupon(coupon_id);
    }
    public List<PaymentMethod> GetPaymentMethods()
    {
        return CheckoutDao.getInstance().getPaymentMethod();
    }
}
