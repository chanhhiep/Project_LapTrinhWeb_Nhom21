<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>

<footer>
    <div id="footer_company">
        <img src="./images/main/Logo_GiaDung_livingON-80227.jpg" class="logo-footer" alt="logo">
        <div id="footer_company-title">
            <h4 class="footer_title">TỔNG CÔNG TY LivingOn Viet Nam</h4>
            <p>livingOnlivingOn là doanh nghiệp hàng đầu cung cấp dịch vụ thương mại điện tử trong và ngoài nướcnước tại
                Việt Nam.</p>
        </div>
        <div id="footer_company-info">
            <p class="footer_title">THÔNG TIN LIÊN HỆ</p>
            <i class="fa fa-location-arrow"> Giấy chứng nhận Đăng ký Kinh doanh số: 0104093672 do Phòng ĐKKD Thành phố Hà Nội Cấp ngày:
                12/07/2019</i>
            <i class="fa fa-location-arrow"> VP giao dịch:
                Toà nhà N2, Km số 2, Đại lộ Thăng Long, Phường Mễ Trì, Quận Nam Từ Liêm, Hà Nội.</i>
            <i class="fa fa-envelope"><a href="#">cskhlivingon@gmail.com</a></i>
            <i class="fa fa-phone"><a href="#">344660857</a></i>
        </div>
    </div>
    <div id="footer_about">
        <h4 class="footer_title">GIỚI THIỆU</h4>
        <ul>
            <li>Giới thiệu LivingOn</li>
            <li>Tin tức</li>
            <li>Mạng lưới giao hang</li>
            <li>Câu hỏi thường gặp</li>
            <li>Tuyển dụng</li>
        </ul>
    </div>
    <div id="footer_suport">
        <h4 class="footer_title">HỖ TRỢ KHÁCH HÀNG</h4>
        <ul>
            <li>Điều khoản sử dụng</li>
            <li>Chính sách bảo mật thông tin</li>
            <li>Chính sách vận chuyển</li>
            <li>Hướng dẫn sử dụng dịch vụ</li>
            <li>Câu hỏi thường gặp</li>
            <li>Góp ý sản phẩm dịch vụ</li>
            <li>Quy chế hoạt động TMĐT</li>
            <li>Truy cập nhanh</li>
        </ul>
    </div>
    <div id="footer-care">
        <h4 class="footer_title">HỖ TRỢ</h4>
        <div id="relate">
            <img src="./images/icon/contact.png" class="headset-img" alt="headset">
            <div>
                <p>Liên hệ Hotline: 7:00 – 20:00</p>
                <p>19008095</p>
            </div>
        </div>
        <h4>Kết Nối</h4>
        <div id="connect">
            <i class="fa fa-facebook"></i>
            <i class="fa fa-youtube"></i>
            <i class="fa fa-instagram"></i>
            <i class="fa fa-envelope"></i>
        </div>
        <div id="goverment">
            <img src="./images/main/3789dc38345df7794b78d37ead0a8529-200x75.png" class="goverment-img">
        </div>
    </div>
</footer>
<%
    String message = (String) session.getAttribute("message");
%>
<!--<script src="./script_template.js"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>



</body>
</html>