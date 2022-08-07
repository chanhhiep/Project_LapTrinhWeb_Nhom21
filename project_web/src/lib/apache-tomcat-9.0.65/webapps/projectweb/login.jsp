<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String error = (String) request.getAttribute("error");
%>
<link rel="stylesheet" href="./css/login.css">
<%@ include file="./header.jsp"%>
<div class="container">
    <h1>Sign In</h1>
    <form action="./Login">
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
        <input type="text" name="username" class="txt" id="email" placeholder="user name or email">
        <p class="na">Password:</p>
        <input type="password" name="password" class="txt" id="password" placeholder="password">
        <input type="submit" id="btn" value="Sign In">
    </form>
    <p class="device">or login with</p>
    <div class="platform">
        <img src="./images/main/t_500x300.jpg">
        <img src="./images/main/t_500x300 (1).jpg">
    </div>
    <div class="linking">
        <p><a href="./register.jsp" class="signup">Sign Up</a></p>
        <p>OR</p>
        <p><a  href="#" class="forget">forget Account Password</a></p>
    </div>

</div>
<%@ include file="./footer.jsp"%>
