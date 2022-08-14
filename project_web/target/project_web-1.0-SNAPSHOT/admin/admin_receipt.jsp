<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/7/2022
  Time: 12:00 AM
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
        <h3 class="admind_section">
            <a href="./DashboardAdminController">DashBoard</a>
        </h3>
        <h3 class="admind_section">
            <a href="./ProductAdminController">Product Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./PaymentAdminController">Payment Method Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./CustomerAdminController">Customer Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./ImageAdminController">Image Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./CategoryAdminController">Catagory Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./ColorAdminController">Color Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./ReviewAdminController">Review Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./SaleAdminController">Sale Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./UserAdminController">User Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./SizeAdminController">Size Manager</a>
        </h3>
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
            <jsp:useBean id="receipts_admin" scope="request" type="java.util.List"/>
            <c:forEach var="r" items="${receipts_admin}">
                <div class="product_detail">
                    <div class="detail_area">
                        <p>Receipt ID: ${r.receipt_id}</p>
                        <p>Customer ID: ${r.customer_id}</p>
                        <p>Customer Name: ${r.customer_name}</p>
                        <p>Discount Code: ${r.discountcode_id}</p>
                        <p>Rate:${r.rate} </p>
                        <p>Payment ID:${r.payment_id} </p>
                        <p>Total Money:${r.value} </p>
                        <p>state: ${r.state}</p>
                        <p>Create Date: ${r.create_date}</p>
                        <p>Update Date: ${r.update_date}</p>
                    </div>

                    <div class="btn_editpro" >
                        <i class="fa-solid fa-pen-to-square"></i>
                        <div class="product_hidden" id="product_hidden">
                            <form action="./UpdateReceiptController">
                                <p>Receipt ID: </p>
                                <input type="text" name="receipt_id_update" value="${r.receipt_id}">
                                <p>Customer Name:</p>
                                <input type="text" name="customer_id_update" value="${r.customer_id}">
                                <p>Discount Code ID:</p>
                                <input type="text" name="discountcode_id_update" value="${r.discountcode_id}">
                                <p>Payment Method ID:</p>
                                <input type="text" name="payment_id_update" value="${r.payment_id}">
                                <p>Total Money:</p>
                                <input type="number" name="value_update" value="${r.value}">
                                <p>State:</p>
                                <input type="number" name="state_update" value="${r.state}">

                                <input class="submit_btn" type="submit" value="Edit">
                            </form>

                        </div>
                    </div>
                    <form action="./DeleteReceiptController">
                        <input name="receipt_id_delete" value="${r.receipt_id}" type="hidden">
                        <button type="submit" class="btn_deletepro"><i class="fa-solid fa-trash"></i></button>
                    </form>


                </div>
            </c:forEach>
        </div>
        <div class="product_save">
            <h3>Add Product</h3>
            <form action="./SaveReceiptController">
                <p>Receipt ID: </p>
                <input type="text" name="receipt_id" value="${r.receipt_id}">
                <p>Customer ID:</p>
                <input type="text" name="customer_id" value="${r.customer_id}">
                <p>Discount Code ID:</p>
                <input type="text" name="discountcode_id" value="${r.discountcode_id}">
                <p>Payment Method ID:</p>
                <input type="text" name="payment_id" value="${r.payment_id}">
                <p>Total Money:</p>
                <input type="number" name="value" value="${r.value}">
                <input class="submit_addbtn" type="submit" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
