<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/8/2022
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String) request.getAttribute("error");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <style>
        body{
            background-image: linear-gradient(90deg,rgba(86, 160, 1, 0.8),
            rgba(20, 167, 172, 0.7)),url("./images/classic-living-room-home-interior-design-banner-vector.jpg");
            background-position: center;
            display: flex;
            align-items: center;
            justify-content: center;
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
            font-family: 'Roboto', sans-serif;
        }
        .container{
            background: #ffffff;
            height: 80vh;
            width: 30vw;
            text-align: center;
            border-radius: 10px;
        }
        form{
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        form .txt{
            width: 280px;
            height: 35px;
            border-radius: 30px;
            margin-bottom: 0px;
            box-shadow: 0px 0px 10px 10px #e7e7e7;
            border-style: none;
            outline: none;

        }
        .na{
            align-self: flex-start;
            margin-left: 30px;
            font-size: 16px;
        }
        #btn{
            width: 120px;
            height: 40px;
            border-radius: 30px;
            margin-bottom: 10px;
            border-style: none;
            background-color: #008f83;
            margin-top: 20px;
        }
        .device{
            margin: 10px 0px 10px 0px;
            color: #bbbbbb;
        }
        .platform img{
            width: 50px;
            height: 50px;
            border-radius: 50%;
            box-shadow: 5px 5px 5px 5px #e7e7e7;
            margin:10px 20px;
        }
        .signup{
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Sign In</h1>
    <form action="./CheckLogin">
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
        <input type="text" name="username" class="txt" id="email" placeholder="user name">
        <p class="na">Password:</p>
        <input type="password" name="password" class="txt" id="password" placeholder="password">
        <input type="submit" id="btn" value="Sign In">
    </form>
</div>
</body>
</html>
