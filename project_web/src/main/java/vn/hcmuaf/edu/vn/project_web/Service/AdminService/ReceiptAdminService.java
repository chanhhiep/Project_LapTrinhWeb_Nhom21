package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.ProductDao;
import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.ReceiptDao;
import vn.hcmuaf.edu.vn.project_web.beans.Product;
import vn.hcmuaf.edu.vn.project_web.beans.Receipt;

import java.util.List;

public class ReceiptAdminService {
    private static ReceiptAdminService instance;

    public static ReceiptAdminService getInstance(){
        if(instance==null){
            instance=new ReceiptAdminService();
        }
        return instance;
    }
    private ReceiptAdminService(){

    }
    public List<Receipt> getAllReceipt(){
        for(Receipt p: ReceiptDao.getInstance().getAllReceipt()){
            System.out.println(p.toString());
        }
        return ReceiptDao.getInstance().getAllReceipt();
    }


    public boolean SaveReceipt(String receipt_id,String customer_id,String discountcode_id,String payment_id,double value){
        return ReceiptDao.getInstance().SaveReceipt(receipt_id, customer_id, discountcode_id, payment_id, value);
    }
    public boolean UpdateReceiptById(String receipt_id,String customer_id,String discountcode_id,String payment_id,double value,int state){
        return ReceiptDao.getInstance().UpdateReceiptById(receipt_id, customer_id, discountcode_id, payment_id, value, state);
    }
    public boolean DeleteReceiptById(String receipt_id){
        return ReceiptDao.getInstance().DeleteReceiptById(receipt_id);
    }
}
