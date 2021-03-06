<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LivingOn</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="stylesheet" href="./home.css">
</head>
<body>
    <div class="contain">
    <header>
        <img src="./images/main/Logo_GiaDung_livingON-80227.jpg" alt="logo" id="logo">
        <input type="text" name="search" id="search" placeholder="  Tìm Kiếm Sản Phẩm">
        <p><a href="#">Sản Phẩm</a></p>
        <p><a href="#">Khuyến Mãi</a></p>
        <p><a href="#">Thương Hiệu</a></p>
        <a href="#"><img src="./images/icon/cart.png" alt="cart" class="head-img"></a>
        <a href="#"><img src="./images/icon/acount.png" alt="acount" class="head-img"></a>      
    </header>
    <ul>
        <li>
            <img src="./images/icon/dress.png" alt="fashion">
            <p>Thời Trang</p>
        </li>
        <li>
            <img src="./images/icon/comestics.png" alt="comestics">
            <p>Mỹ Phẩm</p>
        </li>
        <li>
            <img src="./images/icon/kitchen.png" alt="kitchen">
            <p>Đồ Gia Dụng</p>
        </li>
        <li>
            <img src="./images/icon/wood.png" alt="wood">
            <p>Đồ Gỗ</p>
        </li>
        <li>
            <img src="./images/icon/electric.png" alt="electric">
            <p>Đồ Điện Máy</p>
        </li>
        <li class="cskh">Tin Tức 24h</li>
        <li class="cskh">Hỏi Đáp</li>
    </ul>
    </div>
    <div class="container">
        <jsp:useBean id="products" scope="request" type="java.util.List"/>
        <c:forEach var="p" items="${products}">
        <div class="container-box">
            <img src="${p.img}" class="box-img" alt="domestic">
            <p><a href="#">${p.name}</a></p>
            <p>giá từ: ${p.sellPrice} <span>${p.price}</span></p>
            <div class="rate">
                <img src="./images/icon/stars.original.png" alt="star">
                <p>${p.quantity} luot mua</p>
            </div>
        </div>
        </c:forEach>

    </div>
    <footer>
        <div id="footer_company">
            <img src="./images/main/Logo_GiaDung_livingON-80227.jpg" alt="logo">
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
              <img src="./images/main/3789dc38345df7794b78d37ead0a8529-200x75.png">
            </div>
          </div>
    </footer>
</body>
</html>