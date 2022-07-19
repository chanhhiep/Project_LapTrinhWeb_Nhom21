<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/register.css">
<%@ include file="./header.jsp"%>
<div class="container">
    <h1>Sign Up</h1>
    <form>
        <p class="na">UserName:</p>
        <input type="email" name="email" class="txt" id="email" placeholder="user name or email">
        <p class="na">Password:</p>
        <input type="password" name="password" class="txt" id="password" placeholder="password">
        <p class="na">Full Name:</p>
        <input type="text" name="name" class="txt" id="name" placeholder="Your Full Name">
        <p class="na">Phone:</p>
        <input type="tel" name="phone" class="txt" id="phone" placeholder="phone number">
        <p class="na">Address:</p>
        <input type="text" name="Address" class="txt" id="Address" placeholder="Address">
        <input type="submit" id="btn" value="Sign Up">
    </form>
    <p class="signup">Alredy have a account? <a href="#">Login</a></p>
</div>
<%@ include file="./footer.jsp"%>