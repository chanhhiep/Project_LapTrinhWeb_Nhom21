<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/7/2022
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
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
            <div class="product_detail">
                <div class="detail_area">
                    <p>Product ID: xxxx</p>
                    <p>Product Nane: Name</p>
                    <p>CategoryID: Category</p>
                    <p>Price: 1000 vnd</p>
                    <p>PromotionId: promotion01</p>
                    <p>Brand: CXXX</p>
                    <p>Inventory Quantity: 1000 sp</p>
                    <p>Description</p>
                    <p>Active: </p>
                </div>

                <div class="btn_editpro" >
                    <i class="fa-solid fa-pen-to-square"></i>
                    <div class="product_hidden" id="product_hidden">
                        <form action="">
                            <p>Product ID: </p>
                            <input type="text" value="xxx">
                            <p>Product Nane:</p>
                            <input type="text" value="xxx">
                            <p>CategoryID:</p>
                            <input type="text" value="xxx">
                            <p>Price:</p>
                            <input type="number" value="xxx">
                            <p>PromotionId:</p>
                            <input type="text" value="xxx">
                            <p>Brand:</p>
                            <input type="text" value="xxx">
                            <p>Inventory Quantity:</p>
                            <input type="number" value="xxx">
                            <p>Description</p>
                            <input type="text" value="xxx">
                            <p>Active: </p>
                            <input type="number" value="xxx">
                            <input class="submit_btn" type="submit" value="Edit">
                        </form>

                    </div>
                </div>
                <p class="btn_deletepro"><i class="fa-solid fa-trash"></i></p>
            </div>

        </div>
    </div>
</div>
</body>
</html>
