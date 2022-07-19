<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <style>
        body{
            background-image: linear-gradient(90deg,rgba(0, 95, 204, 0.8),
            rgba(116, 20, 172, 0.7)),url("./th.jpg");
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
            width: 23vw;
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
            width: 220px;
            height: 30px;
            border-radius: 10px;
            margin-bottom: 20px;
            box-shadow: 5px 10px 5px 5px #e7e7e7;
            border-style: none;
            outline: none;
        }
        #btn{
            width: 120px;
            height: 40px;
            border-radius: 30px;
            margin-bottom: 10px;
            border-style: none;
            background-color: #00ffea;
            margin-top: 10px;
        }
        .device{
            margin: 30px 0px 20px 0px;
            color: #bbbbbb;
        }
        .platform img{
            width: 50px;
            height: 50px;
            border-radius: 50%;
            box-shadow: 5px 5px 5px 5px #e7e7e7;
            margin:0px 10px;
        }
        .signup{
            margin-top: 100px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Sign In</h1>
    <form action="/Helloworld/Login" method="post">
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
        <input type="text" <% if(request.getParameter("email")!=null){ %> value="<%=request.getParameter("email") %>"<% } %> name="email" class="txt" id="email" placeholder="user name or email">
        <input type="text" name="password" class="txt" id="password" placeholder="password">
        <input type="submit" id="btn" value="Sign In">
    </form>
    <p class="device">or login with</p>
    <div class="platform">
        <img src="./fb(1).jpg">
        <img src="./t_500x300 (1).jpg">
    </div>
    <p class="signup">sign up</p>
</div>
</body>
</html>