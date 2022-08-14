<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LivingOn</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="./css/head.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
</head>
<body>
<div class="contain">
    <header>
        <a href="./HomePage"><img src="./images/main/Logo_GiaDung_livingON-80227.jpg" alt="logo" id="logo"></a>
        <input type="text" name="search" id="search" placeholder="  Tìm Kiếm Sản Phẩm">
        <p><a href=./ProductListController>Sản Phẩm</a></p>
        <p><a href="#">Khuyến Mãi</a></p>
        <p><a href="./brand.jsp">Thương Hiệu</a></p>
        <a href="./ShowCartController"><img src="./images/icon/cart.png" alt="cart" class="head-img"></a>
        <a href="./LoginPage"><img src="./images/icon/acount.png" alt="acount" class="head-img"></a>

    </header>
    <ul class="header-list">
        <li>
            <a href="./FashionCategory">
            <img src="./images/icon/dress.png" alt="fashion">
            <p>Thời Trang</p>
            </a>
        </li>
        <li>
            <a href="./CosmeticCategory">
            <img src="./images/icon/comestics.png" alt="comestics">
            <p>Mỹ Phẩm</p>
            </a>
        </li>
        <li>
            <a href="./HousewareCategory">
            <img src="./images/icon/kitchen.png" alt="kitchen">
            <p>Đồ Gia Dụng</p>
            </a>
        </li>
        <li>
            <a href="./WoodenCategory">
            <img src="./images/icon/wood.png" alt="wood">
            <p>Đồ Gỗ</p>
            </a>
        </li>
        <li>
            <a href="./ElectricalCategory">
            <img src="./images/icon/electric.png" alt="electric">
            <p>Đồ Điện Máy</p>
            </a>
        </li>
        <li class="cskh">
            <a>
            Tin Tức 24h
            </a>
        </li>
        <li class="cskh">
            <a>
            Hỏi Đáp
            </a>
        </li>
    </ul>
</div>

