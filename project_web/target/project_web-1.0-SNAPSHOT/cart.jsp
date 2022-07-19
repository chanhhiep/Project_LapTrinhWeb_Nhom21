<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/cart.css">
<%@ include file="./header.jsp"%>
<div class="cart">
    <div class="cart-row">
        <span class="cart-item cart-header cart-column">Sản Phẩm</span>
        <span class="cart-price cart-header cart-column">Giá</span>
        <span class="cart-quantity cart-header cart-column">Số Lượng</span>
    </div>
    <div class="cart-row">
        <div class="cart-item cart-column">
            <img class="cart-item-image" src="images/main/Brandmall_Luminarc_BSP_1-(7).jpg" >
            <span class="cart-item-title">Bộ Nồi Thuỷ Tinh</span>
        </div>
        <span class="cart-price cart-column">300.000đ</span>
        <div class="cart-quantity cart-column">
            <input class="cart-quantity-input" type="number" value="1">
            <button class="btn btn-danger" type="button">Xóa</button>
        </div>
    </div>
    <div class="cart-row">
        <div class="cart-item cart-column">
            <img class="cart-item-image" src="images/main/Brandmall_Luminarc_BSP_2-(7).jpg" >
            <span class="cart-item-title">Bộ Bàn Ăn Thuỷ Tinh</span>
        </div>
        <span class="cart-price cart-column">300.000</span>
        <div class="cart-quantity cart-column">
            <input class="cart-quantity-input" type="number" value="1">
            <button class="btn btn-danger" type="button">Xóa</button>
        </div>
    </div>
    <div class="cart-row">
        <div class="cart-item cart-column">
            <img class="cart-item-image" src="images/main/Brandmall_Luminarc_BSP_3-(7).jpg" >
            <span class="cart-item-title">Bộ Bình Ly Thuỷ Tinh</span>
        </div>
        <span class="cart-price cart-column">300.000</span>
        <div class="cart-quantity cart-column">
            <input class="cart-quantity-input" type="number" value="1">
            <button class="btn btn-danger" type="button">Xóa</button>
        </div>
    </div>
    <div class="cart-total">
        <strong class="cart-total-title">Tổng Cộng:</strong>
        <span class="cart-total-price">500.000đ</span>
    </div>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn btn-primary me-md-2" type="button"><a href="./payment.html">Thanh Toán </a> </button>
    </div>
</div>
<!-- SP HNAY -->
<div class="brand">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="title">
                    <h2>SẢN PHẨM<strong class="black"> LIÊN QUAN</strong></h2>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="brand-bg">
        <div class="row">
            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margin">
                <div class="brand-box">
                    <i><img src="images/main/Brandmall_Luminarc_BSP_1-(7).jpg"/></i>
                    <h3>BỘ NỒI THUỶ TINH</h3>
                    <span>360.000đ</span>
                </div>
            </div>
            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margin">
                <div class="brand-box">
                    <i><img src="images/main/Brandmall_Luminarc_BSP_2-(7).jpg"/></i>
                    <h3>BỘ BÀN ĂN THUỶ TINH</h3>
                    <span>400.000đ</span>
                </div>
            </div>
            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                <div class="brand-box">
                    <i><img src="images/main/Brandmall_Luminarc_BSP_4-(7).jpg"/></i>
                    <h3>BỘ BÌNH LY THUỶ TINH</h3>
                    <span>250.000đ</span>
                </div>
            </div>

        </div>
    </div>
</div>
<%@ include file="./footer.jsp"%>