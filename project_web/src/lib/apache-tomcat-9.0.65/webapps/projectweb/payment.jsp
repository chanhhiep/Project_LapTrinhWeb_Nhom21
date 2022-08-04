<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/payment.css">
<%@ include file="./header.jsp"%>
<div class="payment-container">
    <div class="payment-left">
        <div class="payment-address">
            <p class="payment-address-title">shipping address <a class="edit" href="#">edit</a> </p>
            <p>Name :</p>
            <input type="text" class="payment-name payment_shipping" placeholder="type your name">
            <p>phone : </p>
            <input type="phone" class="payment-phone payment_shipping" placeholder="type your phone">
            <p>email:</p>
            <input type="email" class="payment-email payment_shipping" placeholder="type your email">
            <p>address:</p>
            <input type="text" class="address_payment payment_shipping" placeholder="type your address">
        </div>
        <div class="payment-delivery">
            <p class="payment-address-title">Packge 1 of 1</p>
            <div class="delivery-option">
                <p>choose your option:</p>
                <div class="option">
                    <p class="delivery-price"> 12000 d</p>
                    <p class="delicery-standard">Standard Delivery</p>
                    <p>est.Arrivarl:<span class="delivery-time">28 Dec-1 Jan</span></p>
                </div>
            </div>
            <div class="delivery-product">
                <img class="product-img" src="https://vn-live.slatic.net/p/6d066c0a0011c5d4f61972d70b4cda7f.jpg">
                <p class="product-name">Ổ cứng SSD Gigabyte M.2 2280 NVMe Gen3 x4 - Bảo hành 36 tháng</p>
                <div class="product-price">
                    <p class="sell-price">650000</p>
                    <p class="price">850000</p>
                </div>
                <p>Qty:<span class="product-quantity">1</span></p>
            </div>
        </div>
    </div>
    <div class="payment-right">
        <div class="payment-method">
            <h3>Select Payment Method</h3>
            <div class="payment_method_select">
                <label >
                    <input type="radio" id="payment_method_code1" name="pttt" value="momo" checked="checked"> MOMO
                </label>
                <label >
                    <input type="radio" id="payment_method_code2" name="pttt" value="momo" checked="checked"> PayPal
                </label>
            </div>

        </div>
        <div class="payment-voucher">
            <h3>Do you have coupon ?</h3>
            <input type="text" name="voucher" id="voucher" placeholder="Enter Voucher Code">
            <input type="button" id="apply" value="Apply">
        </div>
        <div class="payment-order">
            <h3>Order Summary</h3>
            <p>subtotal: <span class="total-money">650000</span></p>
            <p>Shipping Free:<span class="shipping-fee">12000</span></p>
            <input type="submit" class="submit" value="Process To Payment">
        </div>
    </div>
</div>
<%@ include file="./footer.jsp"%>