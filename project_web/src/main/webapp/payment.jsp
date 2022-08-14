<%@ page import="vn.hcmuaf.edu.vn.project_web.beans.CartItem" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String coupon_notify = (String) request.getAttribute("coupon_notify");
%>
<%
    String payment_notify = (String) request.getAttribute("payment_notify");
%>
<link rel="stylesheet" href="./css/payment.css">
<c:set var="auth" value="${sessionScope.auth}"/>
<c:if test="${auth==null}">
    <%@ include file="header.jsp"%>
</c:if>
<c:if test="${auth!=null}">
    <c:if test="${auth.role.equals('customer')}">
        <%@ include file="pheader.jsp"%>
    </c:if>
</c:if>
<form action="./SaveReceipt">
<div class="payment-container">

    <div class="payment-left">
        <div class="payment-address">
            <c:set var="cus" value="${requestScope.customer}"/>
            <p class="payment-address-title">shipping address <a class="edit" href="#">edit</a> </p>
            <p>Name :</p>
            <input type="text" name="customer_name" class="payment-name payment_shipping" value="${cus.customer_name}" placeholder="type your name">
            <p>phone : </p>
            <input type="phone" name="customer_phone" class="payment-phone payment_shipping" value="${cus.phone}" placeholder="type your phone">
            <p>email:</p>
            <input type="email" name="customer_email" class="payment-email payment_shipping" value="${cus.email}" placeholder="type your email">
            <p>address:</p>
            <input type="text" name="customer_address" class="address_payment payment_shipping" value="${cus.address}" placeholder="type your address">
        </div>
        <div class="payment-delivery">
            <p class="payment-address-title">Packge 1 of 1</p>
            <div class="delivery-option">
                <p>choose your option:</p>
                <div class="option">
                    <p class="delivery-price"> 2$ </p>
                    <p class="delicery-standard">Standard Delivery</p>
                    <p>est.Arrivarl:<span class="delivery-time">28 Dec-1 Jan</span></p>
                </div>
            </div>
            <jsp:useBean id="carts" scope="request" type="java.util.List"/>
            <c:forEach var="cart" items="${carts}">
            <div class="delivery-product">
                <img class="product-img" src="${cart.cart_product.imageMain}">
                <p class="product-name">${cart.cart_product.product_name}</p>
                <div class="product-price">
                    <p class="sell-price">${cart.cart_product.price}</p>
                    <p class="price">850000</p>
                </div>
                <p>Qty:<span class="product-quantity">${cart.cart_product.quantitySold}</span></p>
            </div>
            </c:forEach>
        </div>
    </div>
    <div class="payment-right">
        <div class="payment-method">
            <h3>Select Payment Method</h3>
            <div class="payment_method_select">
                <% int temp = 0; %>
            <jsp:useBean id="payments_method" scope="request" type="java.util.List"/>
                <c:forEach var="p" items="${payments_method}">
                    <% if (temp==0){%>
                    <label for="${p.payment_id}">
                        <input type="radio" id="payment_method_code" name="paymentMt" value="${p.payment_id}" checked="checked"> ${p.payment_name}
                    </label>
                    <%} else {%>
                    <label for="${p.payment_id}">
                        <input type="radio" id="payment_method_code" name="paymentMt" value="${p.payment_id}"> ${p.payment_name}
                    </label>
                    <%} temp++;%>

                </c:forEach>
            </div>
        </div>
        <div class="payment-voucher">
            <h3>Do you have coupon ?</h3>
            <input type="text" name="voucher" id="voucher" placeholder="Enter Voucher Code">
            <%
                if(coupon_notify != null){
            %>
            <div class="alert" role="alert">
                <p>
                    <%= coupon_notify %>
                </p>
            </div>
            <%
                }
            %>
            <input type="button" onclick="location.href='./CheckCoupon?voucher=' + $('#voucher').val()" id="apply" value="Apply">
        </div>
        <%
            double rate=0;
            double total_money=0;
            double final_money=0;
            double shipping_fee=2;
            if(session.getAttribute("coupon_rate")==null){
                session.setAttribute("coupon_rate",1.0);
            }
            else {
                rate = (double) session.getAttribute("coupon_rate");
            }
            List<CartItem> listCarts = (List<CartItem>) request.getSession().getAttribute("cart");
            for(CartItem item:listCarts){
                total_money += item.getTotalMoney();
            }
            final_money= total_money*(1-rate);

        %>
        <div class="payment-order">
            <h3>Order Summary</h3>
            <p>subtotal: <span class="total-money"><%=final_money%> $</span></p>
            <p>Shipping Free:<span class="shipping-fee"><%=shipping_fee%> $ </span></p>
            <p>Total Money: <span class="total-money"><%=final_money+shipping_fee%> $</span></p>
            <input type="hidden" name="total_money" value="<%=final_money+shipping_fee%>">
            <%
                if(payment_notify != null){
            %>
            <div class="alert" role="alert">
                <p>
                    <%= payment_notify %>
                </p>
            </div>
            <%
                }
            %>
            <input type="submit" class="submit" value="Process To Payment">
        </div>
    </div>

</div>
</form>
<%@ include file="./footer.jsp"%>
