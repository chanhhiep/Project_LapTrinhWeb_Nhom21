<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/product.css">
<c:set var="auth" value="${sessionScope.auth}"/>
<c:if test="${auth==null}">
    <%@ include file="header.jsp"%>
</c:if>
<c:if test="${auth!=null}">
    <c:if test="${auth.role.equals('customer')}">
        <%@ include file="pheader.jsp"%>
    </c:if>
</c:if>
<div class="section_product">
    <div class="product_select">
        <div class="product_select">
            <select name="select_detail" id="select_detail" disabled="disabled">
                <option value="newest">Newest</option>
                <option value="ascending">Ascending</option>
                <option value="descending">Descending</option>
            </select>
        </div>
        <div class="product_price_range">
            <form action="./ProductByPriceRange">
            <p>price range:</p>
            <div class="price_range">
                <input type="number" name="min_price" id="price_from" placeholder="price from">
                <p>-</p>
                <input type="number" name="max_price" id="price_to" placeholder="price to">
            </div>
            <input type="submit" value="apply" id="apply_range">
            </form>
        </div>
        <div class="product_size">
            <p>Size:</p>
            <div class="button_size">
                <jsp:useBean id="sizes" scope="request" type="java.util.List"/>
                <c:forEach var="s" items="${sizes}">
                    <form action="./ProductBySize">
                        <input type="hidden" name="size_id" value="${s.size_id}">
                        <button type="submit" class="btn_size">${s.size_name}</button>
                    </form>
                </c:forEach>
            </div>
        </div>
        <div class="product_color">
            <p>Color:</p>
            <div class="button_color">
                <jsp:useBean id="colors" scope="request" type="java.util.List"/>
                <c:forEach var="c" items="${colors}">
                    <form action="./ProductByColor">
                        <input type="hidden" name="color_id" value="${c.color_id}">
                        <button class="btn_color" style="background-color: ${c.color_name};"></button>
                    </form>
                </c:forEach>
            </div>

        </div>
    </div>
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
</div>
<%@ include file="./footer.jsp"%>
