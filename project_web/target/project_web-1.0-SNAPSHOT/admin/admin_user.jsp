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
  Time: 12:03 AM
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
        <h2>User Manager</h2>
        <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Saepe placeat ex sapiente nisi? Asperiores,
            ipsa ducimus aliquam deleniti velit at earum similique odit nesciunt incidunt,
            consequatur ea quam corrupti dignissimos.
        </p>
        <h2>User List Manager: </h2>
        <div class="product_dashlist">
            <jsp:useBean id="users_admin" scope="request" type="java.util.List"/>
            <c:forEach var="c" items="${users_admin}">
                <div class="product_detail">
                    <div class="detail_area">
                        <p style="width: 100px">User ID: ${c.user_id}</p>
                        <p>User Name:${c.username}</p>
                        <p style="width: 100px">User Password: ${c.password}</p>
                        <p>User Role:${c.role}</p>
                        <p>User Email:${c.email}</p>
                        <p>Customer ID: ${c.customer_id}</p>
                        <p>Active: ${c.active}</p>
                    </div>

                    <div class="btn_editpro" >
                        <i class="fa-solid fa-pen-to-square"></i>
                        <div class="product_hidden" id="product_hidden">
                            <form action="./UpdateUserController">
                                <p>User ID: </p>
                                <input type="text" name="user_id_update" value="${c.user_id}">
                                <p>User Name:</p>
                                <input type="text" name="user_name_update" value="${c.username}">
                                <p>User Password: </p>
                                <input type="text" name="user_password_update" value="${c.password}">
                                <p>User Role:</p>
                                <input type="text" name="user_role_update" value="${c.role}">
                                <p>User Email: </p>
                                <input type="text" name="user_email_update" value="${c.email}">
                                <p>Customer ID:</p>
                                <input type="text" name="user_customer_update" value="${c.customer_id}">
                                <p>User active: </p>
                                <input type="text" name="user_active_update" value="${c.active}">
                                <input class="submit_btn" type="submit" value="Edit">
                            </form>

                        </div>
                    </div>
                    <form action="./DeleteUserController">
                        <input name="user_id_delete" value="${c.user_id}" type="hidden">
                        <button type="submit" class="btn_deletepro"><i class="fa-solid fa-trash"></i></button>
                    </form>


                </div>
            </c:forEach>
        </div>
        <div class="product_save">
            <h3>Add User</h3>
            <form action="./SaveUserController">
                <p>User Name:</p>
                <input type="text" name="user_name" >
                <p>User Password: </p>
                <input type="text" name="user_password">
                <p>User Email:</p>
                <input type="text" name="user_email">
                <p>Customer ID: </p>
                <input type="text" name="user_customer">
                <input class="submit_addbtn" type="submit" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
