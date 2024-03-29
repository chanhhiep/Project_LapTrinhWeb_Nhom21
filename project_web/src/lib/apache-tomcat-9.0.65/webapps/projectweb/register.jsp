<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String error = (String) request.getAttribute("error");
%>
<link rel="stylesheet" href="./css/register.css">
<%@ include file="./header.jsp"%>
<div class="container">
    <h1>Sign Up</h1>
    <form action="./Register">
        <%
            if(error != null){
        %>
        <div class="alert" role="alert">
            <p>
                <%= error %>
            </p>
        </div>
        <%
            }
        %>
        <p class="na">UserName:</p>
        <input type="text" name="username" class="txt" id="username" placeholder="user name">
        <p class="na">Password:</p>
        <input type="password" name="password" class="txt" id="password" placeholder="password">
        <p class="na">Confirm Password:</p>
        <input type="password" name="confirm" class="txt" id="confirm_password" placeholder="Confirm password">
        <p class="na">Email:</p>
        <input type="email" name="email" class="txt" id="email" placeholder="email">
        <p class="na">Full Name:</p>
        <input type="text" name="name" class="txt" id="name" placeholder="Your Full Name">
        <p class="na">Phone:</p>
        <input type="tel" name="phone" class="txt" id="phone" placeholder="phone number">
        <p class="na">Address:</p>
        <input type="text" name="address" class="txt" id="Address" placeholder="Address">
        <input type="submit" id="btn" value="Sign Up">
    </form>
    <p class="signup">Alredy have a account? <a href="./LoginPage">Login</a></p>
</div>
<%@ include file="./footer.jsp"%>