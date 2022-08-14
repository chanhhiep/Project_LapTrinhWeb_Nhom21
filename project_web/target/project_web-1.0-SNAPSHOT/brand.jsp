<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/brand.css">
<c:set var="auth" value="${sessionScope.auth}"/>
<c:if test="${auth==null}">
    <%@ include file="header.jsp"%>
</c:if>
<c:if test="${auth!=null}">
    <c:if test="${auth.role.equals('customer')}">
        <%@ include file="pheader.jsp"%>
    </c:if>
</c:if>
<div class="des2">
    <h2 >TOP BRAND TỐT NHẤT NĂM</h2>
    <div class="row">
        <img class="col" src="./images/main/Logo_GiaDung_3_Everon-45288.jpg" alt="Everon">
        <img class="col" src="./images/main/Logo_GiaDung_1_Luminarc-33864.jpg" alt="Luminarc">
        <img class="col" src="./images/main/Logo_GiaDung_2_Lock-63532.jpg" alt="Lock&Lock">
        <img class="col" src="./images/main/Logo_GiaDung_4_LaGourmet-31531.jpg" alt="LaGourmet">
    </div>
    <div class="row">
        <img class="col" src="./images/main/Logo_GiaDung_5_Glasslock-56626.jpg" alt="GlassLock">
        <img class="col" src="./images/main/Logo_GiaDung_6_DongHwa-41743.jpg" alt="DongHwa">
        <img class="col" src="./images/main/Logo_GiaDung_ecoramic-37866.jpg" alt="Ecoramic">
        <img class="col" src="./images/main/Logo_GiaDung_livingON-80227.jpg" alt="LivingOn">
    </div>
</div>
<div>
    <div class="row">
        <img  class="col" src="./images/main/03_AllBrand_20190815_01.jpg" alt="brand">
    </div>
    <h2>Top Thương Hiệu Thời Trang</h2>
    <div class="row">
        <img class="col" src="./images/thuong_hieu/Deleah-94291.jpg" alt="Deleah">
        <img class="col" src="./images/thuong_hieu/chrischristy-29001.jpg">
        <img class="col" src="./images/thuong_hieu/Aokang-99066.jpg">
        <img class="col" src="./images/thuong_hieu/lamer-44703%20(1).jpg">
    </div>
</div>
<div class="des4">
    <h2>Thương Hiệu Mỹ Phẩm Của Năm</h2>
    <div  class="row">
        <img class="col" src="./images/thuong_hieu/2-96049%20(1).jpg" alt="Nacific">
        <img class="col" src="./images/thuong_hieu/2-99376.jpg" alt="Adiva">
        <img class="col" src="./images/thuong_hieu/3-9589%20(1).jpg" alt="Yves Rocher">
        <img class="col" src="./images/thuong_hieu/4-53628%20(1).jpg" alt="Celluver">
    </div>
    <h2>Thương Hiệu Trang Sức Cao Cấp</h2>
    <div class="row">
        <img class="col" src="./images/thuong_hieu/AT-42412.jpg" alt="Anh Tho">
        <img class="col" src="./images/thuong_hieu/julius-82266.jpg" alt="Julius">
        <img class="col" src="./images/thuong_hieu/dw-96943.jpg" alt="Daniel Wellington" >
        <img class="col" src="./images/thuong_hieu/opal-97591.jpg" alt="Opal">
    </div>
</div>
<div class="des5">
    <h2>Thương Hiệu Sản Phẩm Nhà Bếp</h2>
    <div class="row">
        <img class="col" src="./images/thuong_hieu/Fivestar-3115.jpg" alt="Five Star">
        <img class="col" src="./images/thuong_hieu/Electrolux-29910.jpg" alt="Electrolux">
        <img class="col" src="./images/thuong_hieu/Happycook-27096.jpg" alt="Happycook" >
        <img class="col" src="./images/thuong_hieu/Sato-16641.jpg" alt="Sato">
    </div>
    <h2>Thương Hiệu</h2>
    <div class="row">
        <img class="col" src="./images/thuong_hieu/Everon-88562.jpg" alt="Everon">
        <img class="col" src="./images/thuong_hieu/Kamiliant-49830.jpg" alt="Kamilian">
        <img class="col" src="./images/thuong_hieu/Venuco-36721.jpg" alt="Venuco" >
        <img class="col" src="./images/thuong_hieu/dunlop-37267%20(1).jpg" alt="Dunlop">
    </div>
</div>
<%@ include file="./footer.jsp"%>
