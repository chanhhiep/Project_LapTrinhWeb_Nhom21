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
        <h3 class="admind_section">DashBoard</h3>
        <h3 class="admind_section">Product Manager</h3>
        <h3 class="admind_section">Payment Method Manager</h3>
        <h3 class="admind_section">Customer Manager</h3>
        <h3 class="admind_section">Image Manager</h3>
        <h3 class="admind_section">Catagory Manager</h3>
        <h3 class="admind_section">Color Manager</h3>
        <h3 class="admind_section">Review Manager</h3>
        <h3 class="admind_section">Sale Manager</h3>
        <h3 class="admind_section">User Manager</h3>
        <h3 class="admind_section">Size Manager</h3>
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
            <jsp:useBean id="colors_admin" scope="request" type="java.util.List"/>
            <c:forEach var="c" items="${colors_admin}">
                <div class="product_detail">
                    <div class="detail_area">
                        <p>Color ID: ${c.color_id}</p>
                        <p>Color Name:${c.color_name}</p>
                        <p>Create Date: ${c.create_date}</p>
                        <p>Update Date: ${c.update_date}</p>
                    </div>

                    <div class="btn_editpro" >
                        <i class="fa-solid fa-pen-to-square"></i>
                        <div class="product_hidden" id="product_hidden">
                            <form action="./UpdateColorController">
                                <p>Color ID: </p>
                                <input type="text" name="color_id_update" value="${c.color_id}">
                                <p>Color Nane:</p>
                                <input type="text" name="color_name_update" value="${c.color_name}">
                                <input class="submit_btn" type="submit" value="Edit">
                            </form>

                        </div>
                    </div>
                    <form action="./DeleteColorController">
                        <input name="color_id_delete" value="${c.color_id}" type="hidden">
                        <button type="submit" class="btn_deletepro"><i class="fa-solid fa-trash"></i></button>
                    </form>


                </div>
            </c:forEach>
        </div>
        <div class="product_save">
            <h3>Add Color</h3>
            <form action="./SaveColorController">
                <p>Color ID: </p>
                <input type="text" name="color_id" >
                <p>Color Name:</p>
                <input type="text" name="color_name" >
                <input class="submit_addbtn" type="submit" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
