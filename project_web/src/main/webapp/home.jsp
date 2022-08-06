<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/home.css">
<c:set var="auth" value="${sessionScope.auth}"/>
<c:if test="${auth==null}">
    <%@ include file="header.jsp"%>
</c:if>
<c:if test="${auth!=null}">
    <c:if test="${auth.role.equals('customer')}">
        <%@ include file="pheader.jsp"%>
    </c:if>
</c:if>
<div class="banner">
    <img src="./images/main/Brandmall_Luminarc_BSP_1-(7).jpg" alt="" class="banner_img">
    <i class="arrow fa fa-arrow-left" id="arrow-left"></i>
    <i class="arrow fa fa-arrow-right" id="arrow-right"></i>
</div>
<div class="container">
    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">three snife </a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>

    <div class="container-box">
        <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
        <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
        <div class="btn-submit">
            <button class="sell-button">Buy Now</button>
            <button class="sell-button" style="background-color: orangered;">Add To Card</button>
        </div>
    </div>
</div>
<%@ include file="./footer.jsp"%>