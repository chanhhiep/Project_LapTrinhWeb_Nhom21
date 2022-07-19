<%--
  Created by IntelliJ IDEA.
  User: Nguyen Chanh Hiep
  Date: 18/11/2021
  Time: 11:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <style>
        :root{
            --text-color:#00ff0d;
            --color-input:#e4e4e4;
        }
        body{
            background-color: aqua;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            font-family: 'Roboto', sans-serif;
        }
        .container{
            background-color: white;
            width: 35vw;
            height: 90vh;
            text-align: center;
            border: 10px solid rgb(163, 163, 163);
            border-radius: 10px;
        }
        .title{
            color: var(--text-color);
            text-align: left;
            margin-left: 50px;
        }
        .input{
            background-color: var(--color-input);
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            margin: 10px 50px;
            border: 1px solid rgb(158, 158, 158);
        }
        .input input{
            width: 320px;
            height: 30px;
            background-color: var(--color-input);
            border-style: hidden;
            border-left-style: solid;
            outline: none;
        }
        .input i{
            width: 50px;
        }
        .check{
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
            align-items: center;
        }
        .date{
            width: 40px;
            height: 20px;
            background-color: var(--color-input);
            border-style: none;
        }
        .day{
            margin-left: 50px;
        }
        .male input{
            width: 120px;
            height: 20px;
            margin-left: 50px;
            background-color: var(--color-input);
            border-style: none;
        }
        .payment{
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
            align-items: center;
        }
        .visa{
            background-color: #00ff0d;
            width: 150px;
            height: 30px;
            padding-top: 15px;
            margin-left: 50px;
            border: 1px solid rgb(180, 180, 180);
            color: white;
            padding-right: 40px;
        }
        .paypal{
            background-color: #fcfcfc;
            width: 150px;
            height: 30px;
            padding-top: 15px;
            border: 1px solid rgb(180, 180, 180);
            color: rgb(182, 182, 182);
            padding-right: 40px;
        }
        .group{
            display: flex;
            flex-direction: row;
        }
        .card-cvc{
            width: 200px;
        }
        .card-cvc input{
            width: 140px;
        }
        .date-card{

        }
        .date-card input{
            height: 30px;
            width: 140px;
            border: 1px solid rgb(180, 180, 180);
            margin-top: 12px;
            margin-right: 10px;
            background-color: var(--color-input);
        }
        .footer{
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
            align-items: center;
        }
        .footer p{
            font-size: 12px;
            color: rgb(117, 117, 117);
        }
        .footer-title{
            margin: 10px 0px 0px 50px;
        }
        .footer input{
            margin-left: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/Helloworld/Register" method="post">
        <p class="title">Account</p>
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
        <div class="input">
            <i class="fa fa-user"></i>
            <input type="text" name="name" id="name" value="Full Name">
        </div>
        <div class="input" >
            <i class="fa fa-envelope"></i>
            <input type="text" name="email" id="email" value="Email">
        </div>
        <div class="input">
            <i class="fa fa-key"></i>
            <input type="text" name="password" id="password" value="Password">
        </div>
        <div class="check">
            <div class="birth">
                <p class="title">Date of birth</p>
                <div class="day">
                    <input type="text" name="day" class="date" value="DD">
                    <input type="text" name="day" class="date" value="MM">
                    <input type="text" name="day" class="date" value="YYYY">
                </div>
            </div>
            <div class="gender">
                <p class="title">Gender</p>
                <div class="male">
                    <input type="text" name="gentle" id="" value="Male or Female">
                </div>
            </div>
        </div>
        <p class="title">Payment Details</p>
        <div class="payment">
            <p class="visa"><i class="fa fa-cc-visa" ></i> credit card</p>
            <p class="paypal"><i class="fa fa-cc-paypal"></i> PayPal</p>
        </div>
        <div class="card-number input">
            <i class="fa fa-credit-card"></i>
            <input type="text" name="cardnumber"  value="Card Number">
        </div>
        <div class="group">
            <div class="card-cvc input">
                <i class="fa fa-user"></i>
                <input type="text" name="cardcvc"  value="card cvc">
            </div>
            <div class="date-card">
                <input type="date" name="date-cart" >
            </div>
        </div>
        <p class="title footer-title">Term and Centificates</p>
        <div class="footer">
            <input type="checkbox" name="checkb" >
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. </p>
        </div>
    </form>
</div>
</body>
</html>
