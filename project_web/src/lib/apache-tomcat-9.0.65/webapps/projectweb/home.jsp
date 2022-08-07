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
<div class="container">
<jsp:useBean id="products" scope="request" type="java.util.List"/>
<c:forEach var="p" items="${products}">
    <div class="container-box">
        <img src="${p.imageMain}" class="box-img" alt="domestic">
        <p><a href="./product.html" class="product-name">${p.product_name} </a></p>
        <p>brand : ${p.brand}</p>
        <p class="sell-price">giá : ${p.price}  <span class="price">${p.price}</span></p>
        <div class="btn-submit">
            <form action="./ProductDetailController">
                <input type="hidden" name="product_id" value="${p.product_id}">
                <button type="submit" class="sell-button">Detail Product</button>
            </form>
            <form action="./AddToCartServlet">
                <input type="hidden" name="product_id" value="${p.product_id}">
                <button type="submit" class="sell-button" style="background-color: orangered;">Add To Card</button>
            </form>
        </div>
    </div>
</c:forEach>
</div>

<%@ include file="./footer.jsp"%>