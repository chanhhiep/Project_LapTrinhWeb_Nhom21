package vn.hcmuaf.edu.vn.project_web.Service.MainService;

import javax.mail.*;
import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.UserDao;
import vn.hcmuaf.edu.vn.project_web.beans.Customer;
import vn.hcmuaf.edu.vn.project_web.beans.User;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UserService {
    private static UserService instance = null;
    private UserService(){

    }
    public static UserService getInstance() {
        if(instance==null){
            instance= new UserService();
        }
        return instance;
    }
    public static User CheckLogin(String username, String password){
        return UserDao.getInstance().CheckLogin(username,password);
    }

    public boolean Register(String username, String password,String customer_name, String confirm, String email, String phone, String address) {
        if(password.equals(confirm)){
            return UserDao.getInstance().Register(username,password,customer_name,email,phone,address);
        }
        return true;
    }
    public Boolean updateUserPassword(String user_id, String password,String confirm){
        if(password.equals(confirm)){
            return UserDao.getInstance().updateUserPassword(user_id,password);
        }
        return true;

    }
    public String getToken(String email){
        String result = "";
        String rs = UserDao.getInstance().getToken(email);
        if (rs == null)
        {
            result = "sorry your email already have in we system";
        }
        else
        {
            result = "bạn đã đăng ký thành công vui lòng click vào link sau để active tài khoản :" + " http://localhost:3434/projectweb/ActiveUser?token=" + rs;
        }
        return result;
    }
    public void sendMail(String mail){
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");



        //Your gmail address
        String myAccountEmail = "chanhhiep2907@gmail.com";
        //Your gmail password
        String password = "semgywvzzdcqekto";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        try {

            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(myAccountEmail)); //sender email address here
            email.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail)); //Receiver email address here
            email.setSubject("LivingOnShop: Active User Account"); //Email Subject and message
            email.setText(getToken(mail));
            Transport.send(email);
            System.out.println("Your email has successfully been sent!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
    public Customer getCustomerById(String customer_id){
        return UserDao.getInstance().getCustomerById(customer_id);
    }
    public boolean updateCustomer(String customer_id, String customer_name,String email,String phone, String address){
        return UserDao.getInstance().UpdateCustomer(customer_id, customer_name, email, phone, address);
    }
    public boolean CheckOldPassword(String password,String dbPassword){
        return UserDao.getInstance().checkOldPassword(password,dbPassword);
    }
}
