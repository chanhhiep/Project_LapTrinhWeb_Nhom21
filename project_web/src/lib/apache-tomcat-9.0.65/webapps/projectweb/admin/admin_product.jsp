
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/7/2022
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/admin.css"/>
<%@ include file="./header_main.jsp"%>
<div class="admin_container">
    <div class="container_left">
        <div class="admin_status">
            <img src="./images/auto-admin-logo-7-1.png" alt="admin_logo">
            <h3 class="admin_name">chanhhiep</h3>
            <p>administater</p>
        </div>
        <h3 class="admind_section"><a href="#"> DashBoard</a></h3>
        <h3 class="admind_section"><a href="./ProductAdminController">Product Manager</a></h3>
        <h3 class="admind_section"><a href="./PaymentAdminController">Payment Method Manager</a></h3>
        <h3 class="admind_section"><a href="#">Customer Manager</a></h3>
        <h3 class="admind_section"><a href="#">Image Manager</a></h3>
        <h3 class="admind_section"><a href="#">Category Manager</a></h3>
        <h3 class="admind_section"><a href="#">Color Manager</a></h3>
        <h3 class="admind_section"><a href="#">Review Manager</a></h3>
        <h3 class="admind_section"><a href="#">Sale Manager</a></h3>
        <h3 class="admind_section"><a href="#">User Manager</a></h3>
        <h3 class="admind_section"><a href="#">Size Manager</a></h3>
    </div>
    <div class="container_right">
        <h2>Product Manager</h2>
        <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Saepe placeat ex sapiente nisi? Asperiores,
            ipsa ducimus aliquam deleniti velit at earum similique odit nesciunt incidunt,
            consequatur ea quam corrupti dignissimos.
        </p>
        <h2>Product List Manager: </h2>
        <div class="product_dashlist">
       <jsp:useBean id="products_admin" scope="request" type="java.util.List"/>
       <c:forEach var="p" items="${products_admin}">
            <div class="product_detail">
                <div class="detail_area">
                    <p>Product ID: ${p.product_id}</p>
                    <p>Product Nane: ${p.product_name}</p>
                    <p>CategoryID: ${p.category_id}</p>
                    <p>Price: ${p.price}</p>
                    <p>Rate Discount:${p.rateDiscount} </p>
                    <p>PromotionId:${p.promotion_id} </p>
                    <p>Brand: ${p.brand}</p>
                    <p>Inventory Quantity:${p.inventory_quantity} </p>
                    <p>Description: ${p.description}</p>
                    <p>Active: ${p.active}</p>
                </div>

                <div class="btn_editpro" >
                    <i class="fa-solid fa-pen-to-square"></i>
                    <div class="product_hidden" id="product_hidden">
                        <form action="./UpdateProductController">
                            <p>Product ID: </p>
                            <input type="text" name="product_id_update" value="${p.product_id}">
                            <p>Product Nane:</p>
                            <input type="text" name="product_name_update" value="${p.product_name}">
                            <p>CategoryID:</p>
                            <input type="text" name="category_id_update" value="${p.category_id}">
                            <p>Price:</p>
                            <input type="number" name="product_price_update" value="${p.price}">
                            <p>PromotionId:</p>
                            <input type="text" name="promotion_id_update" value="${p.promotion_id}">
                            <p>Brand:</p>
                            <input type="text" name="brand_update" value="${p.brand}">
                            <p>Inventory Quantity:</p>
                            <input type="number" name="i_quantity_update" value="${p.inventory_quantity}">
                            <p>Description</p>
                            <input type="text" name="description_update" value="${p.description}">
                            <p>Active: </p>
                            <input type="number" name="active" value="${p.active}">
                            <input class="submit_btn" type="submit" value="Edit">
                        </form>

                    </div>
                </div>
                    <form action="./DeleteProductController">
                        <input name="product_id_delete" value="${p.product_id}" type="hidden">
                        <button type="submit" class="btn_deletepro"><i class="fa-solid fa-trash"></i></button>
                    </form>


            </div>
    </c:forEach>
        </div>
        <div class="product_save">
            <h3>Add Product</h3>
            <form action="./SaveProductController">
                <p>Product ID: </p>
                <input type="text" name="product_id" >
                <p>Product Nane:</p>
                <input type="text" name="product_name" >
                <p>CategoryID:</p>
                <input type="text" name="category_id" >
                <p>Price:</p>
                <input type="number" name="product_price" >
                <p>PromotionId:</p>
                <input type="text" name="promotion_id" >
                <p>Brand:</p>
                <input type="text" name="brand" >
                <p>Inventory Quantity:</p>
                <input type="number" name="i_quantity" >
                <p>Description</p>
                <input type="text" name="description" >
                <input class="submit_addbtn" type="submit" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
