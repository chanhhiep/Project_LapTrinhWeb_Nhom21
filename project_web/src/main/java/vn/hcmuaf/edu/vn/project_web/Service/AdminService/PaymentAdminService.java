package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.PaymentDao;
import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.ProductDao;
import vn.hcmuaf.edu.vn.project_web.beans.PaymentMethod;
import vn.hcmuaf.edu.vn.project_web.beans.Product;

import java.util.List;

public class PaymentAdminService {
    private static PaymentAdminService instance;

    public static PaymentAdminService getInstance(){
        if(instance==null){
            instance=new PaymentAdminService();
        }
        return instance;
    }
    private PaymentAdminService(){

    }
    public List<PaymentMethod> getAllPayment(){

        for(PaymentMethod p: PaymentDao.getInstance().getAllPayment()){
            System.out.println(p.toString());
        }
        return PaymentDao.getInstance().getAllPayment();
    }

    public boolean SaveProduct(String payment_id,String payment_name){
        return PaymentDao.getInstance().SavePayment(payment_id,payment_name);
    }
    public boolean UpdatePaymentById(String payment_id,String payment_name){
        return PaymentDao.getInstance().UpdatePaymentById(payment_id,payment_name);
    }
    public boolean DeletePaymentById(String payment_id){
        return PaymentDao.getInstance().DeletePaymentById(payment_id);
    }
}
