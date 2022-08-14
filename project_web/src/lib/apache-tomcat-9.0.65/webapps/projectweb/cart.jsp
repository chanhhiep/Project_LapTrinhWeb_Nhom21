<%@ page import="java.util.List" %>
<%@ page import="vn.hcmuaf.edu.vn.project_web.beans.CartItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/cart.css">
<c:set var="auth" value="${sessionScope.auth}"/>
<c:if test="${auth==null}">
    <%@ include file="header.jsp"%>
</c:if>
<c:if test="${auth!=null}">
    <c:if test="${auth.role.equals('customer')}">
        <%@ include file="pheader.jsp"%>
    </c:if>
</c:if>
<div class="cart">
    <div class="cart-row">
        <span class="cart-item cart-header cart-column">Sản Phẩm</span>
        <span class="cart-price cart-header cart-column">Giá</span>
        <span class="cart-quantity cart-header cart-column">Số Lượng</span>
    </div>
     <jsp:useBean id="carts" scope="request" type="java.util.List"/>
     <c:forEach var="cart" items="${carts}">
    <div class="cart-row">
        <div class="cart-item cart-column">
            <img class="cart-item-image" src="${cart.cart_product.imageMain}" >
            <span class="cart-item-title">${cart.cart_product.product_name}</span>
        </div>
        <span class="cart-price cart-column">${cart.cart_product.price}</span>
        <div class="cart-quantity cart-column">
            <input class="cart-quantity-input" type="number" value="${cart.cart_product.quantitySold}">
            <form action="./DeleteCartController">
                <input type="hidden" name="product_id" value="${cart.cart_product.product_id}">
                <button class="btn btn-danger" type="submit">Xóa</button>
            </form>

        </div>
    </div>
     </c:forEach>
    <div class="cart-total">
        <%
            double total_money=0;
            List<CartItem> listCarts = (List<CartItem>) request.getSession().getAttribute("cart");
            for(CartItem item:listCarts){
                total_money += item.getTotalMoney();
            }
        %>
        <strong class="cart-total-title">Tổng Cộng:</strong>
        <span class="cart-total-price"><%=total_money%></span>
    </div>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn btn-primary me-md-2" type="button"><a href="./CheckoutPage">Thanh Toán </a> </button>
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