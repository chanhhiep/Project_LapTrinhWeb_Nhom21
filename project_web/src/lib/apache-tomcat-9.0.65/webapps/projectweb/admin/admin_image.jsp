<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/7/2022
  Time: 12:01 AM
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
            <a href="./ColorAdminController">Color Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./CategoryAdminController">Catagory Manager</a>
        </h3>
        <h3 class="admind_section">
            <a href="./ImageAdminController">Image Manager</a>
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
            <jsp:useBean id="images_admin" scope="request" type="java.util.List"/>
            <c:forEach var="c" items="${images_admin}">
                <div class="product_detail">
                    <div class="detail_area">
                        <p>Image ID: ${c.image_id}</p>
                        <p>Image Link:${c.image_link}</p>
                        <p>Create Date: ${c.create_date}</p>
                        <p>Update Date: ${c.update_date}</p>
                    </div>

                    <div class="btn_editpro" >
                        <i class="fa-solid fa-pen-to-square"></i>
                        <div class="product_hidden" id="product_hidden">
                            <form action="./UpdateImageController">
                                <p>Image ID: </p>
                                <input disabled type="text" name="image_id_update" value="${c.image_id}">
                                <p>Image Link:</p>
                                <input type="text" name="image_name_update" value="${c.image_link}">
                                <input class="submit_btn" type="submit" value="Edit">
                            </form>

                        </div>
                    </div>
                    <form action="./DeleteImageController">
                        <input name="image_id_delete" value="${c.image_id}" type="hidden">
                        <button type="submit" class="btn_deletepro"><i class="fa-solid fa-trash"></i></button>
                    </form>


                </div>
            </c:forEach>
        </div>
        <div class="product_save">
            <h3>Add Image</h3>
            <form action="./SaveImageController">
                <p>Image ID: </p>
                <input type="text" name="image_id" >
                <p>Image Name:</p>
                <input type="text" name="image_name" >
                <input class="submit_addbtn" type="submit" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
