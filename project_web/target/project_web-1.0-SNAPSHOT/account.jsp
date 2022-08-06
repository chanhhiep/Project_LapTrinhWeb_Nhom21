<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/8/2022
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>

<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="./css/account.css">
<c:set var="auth" value="${sessionScope.auth}"/>
<c:if test="${auth==null}">
    <%@ include file="header.jsp"%>
</c:if>
<c:if test="${auth!=null}">
    <c:if test="${auth.role.equals('customer')}">
        <%@ include file="pheader.jsp"%>
    </c:if>
</c:if>
<c:set var="cus" value="${sessionScope.cus}"/>
<div class="account_container">
    <h3>Account User</h3>
<div class="product_detail">
    <div class="detail_area">
        <p style="width: 100px">User ID: ${sessionScope.UserId}</p>
        <p>User Name:${sessionScope.UserName}</p>
        <p style="width: 100px">User Password: *******</p>
        <p>User Email:${sessionScope.email}</p>
    </div>

    <div class="btn_editpro" >
        <i class="fa-solid fa-pen-to-square">edit</i>
        <div class="product_hidden">
            <form action="./UpdatePassword">
                <p>User ID: </p>
                <input type="text" disabled="true" name="user_id_update" value="${sessionScope.UserId}">
                <p>Password:</p>
                <input type="password" name="user_password_update" placeholder="type your password here">
                <p>New Password:</p>
                <input type="password" name="user_newpassword_update" placeholder="type your new password here">
                <p>Confirm New Password:</p>
                <input type="password" name="user_confirmpassword_update" placeholder="confirm your new password here">
                <input class="submit_btn" type="submit" value="Edit">
            </form>
        </div>
    </div>
</div>
    <h3>Customer Information</h3>
<div class="product_detail">
    <div class="detail_area">
        <p style="width: 100px">Customer ID: ${cus.customer_id}</p>
        <p>Customer Name:${cus.customer_name}</p>
        <p style="width: 100px">Customer phone: ${cus.phone}</p>
        <p>Customer Email:${cus.email}</p>
        <p>Customer Address:${cus.address}</p>
    </div>

    <div class="btn_editpro" >
        <i class="fa-solid fa-pen-to-square">edit</i>
        <div class="product_hidden" >
            <form action="./UpdateCustomer">
                <p>Customer ID: </p>
                <input type="text" disabled="true" name="customer_id_update" value="${cus.customer_id}">
                <p>Customer Name:</p>
                <input type="text" name="customer_name_update" value="${cus.customer_name}">
                <p>Customer phone: </p>
                <input type="text" name="customer_phone_update" value="${cus.phone}">
                <p>Customer email:</p>
                <input type="text" name="customer_email_update" value="${cus.email}">
                <p>Customer address:</p>
                <input type="text" name="customer_address_update" value="${cus.address}">
                <input class="submit_btn" type="submit" value="Edit">
            </form>
        </div>
    </div>
</div>
</div>
<%@ include file="./footer.jsp"%>
