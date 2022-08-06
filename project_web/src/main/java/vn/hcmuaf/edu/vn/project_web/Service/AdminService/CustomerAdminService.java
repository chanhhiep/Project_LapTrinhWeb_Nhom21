package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.CustomerDao;
import vn.hcmuaf.edu.vn.project_web.beans.Customer;

import java.util.List;

public class CustomerAdminService {
    private static CustomerAdminService instance;

    public static CustomerAdminService getInstance(){
        if(instance==null){
            instance=new CustomerAdminService();
        }
        return instance;
    }
    private CustomerAdminService(){

    }
    public List<Customer> getAllCustomer(){

        for(Customer p: CustomerDao.getInstance().getAllCustomer()){
            System.out.println(p.toString());
        }
        return CustomerDao.getInstance().getAllCustomer();
    }

    public boolean SaveCustomer(String Customer_id,String Customer_name,String email,String phone,String address ){
        return CustomerDao.getInstance().SaveCustomer(Customer_id,Customer_name,email,phone,address);
    }
    public boolean UpdateCustomerById(String Customer_id,String Customer_name,String email,String phone,String address){
        return CustomerDao.getInstance().UpdateCustomerById(Customer_id,Customer_name,email,phone,address);
    }
    public boolean DeleteCustomerById(String Customer_id){
        return CustomerDao.getInstance().DeleteCustomerById(Customer_id);
    }
}
