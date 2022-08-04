<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/product.css">
<%@ include file="./header.jsp"%>
<div class="section_product">
    <div class="product_select">
        <div class="product_select">
            <select name="select_detail" id="select_detail" disabled="disabled">
                <option value="newest">Newest</option>
                <option value="ascending">Ascending</option>
                <option value="descending">Descending</option>
            </select>
        </div>
        <div class="product_price_range">
            <p>price range:</p>
            <div class="price_range">
                <input type="text" name="price_from" id="price_from" placeholder="price from">
                <p>-</p>
                <input type="text" name="price_to" id="price_to" placeholder="price to">
            </div>
            <input type="button" value="apply" id="apply_range">
        </div>
        <div class="product_size">
            <p>Size:</p>
            <div class="button_size">
                <button class="btn_size">24</button>
                <button class="btn_size">25</button>
                <button class="btn_size">26</button>
                <button class="btn_size">27</button>
                <button class="btn_size">28</button>
                <button class="btn_size">29</button>
                <button class="btn_size">30</button>
                <button class="btn_size">31</button>
                <button class="btn_size">32</button>
                <button class="btn_size">33</button>
                <button class="btn_size">34</button>
                <button class="btn_size">35</button>
            </div>
        </div>
        <div class="product_color">
            <p>Color:</p>
            <div class="button_color">
                <button class="btn_color" style="background-color: red;"></button>
                <button class="btn_color" style="background-color: blue;"></button>
                <button class="btn_color" style="background-color: green;"></button>
                <button class="btn_color" style="background-color: yellow;"></button>
                <button class="btn_color" style="background-color: yellowgreen;"></button>
            </div>

        </div>
    </div>
    <div class="container">
        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>

        <div class="container-box">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="box-img" alt="domestic">
            <p><a href="./product.html" class="product-name">bộ 3 dao inock cao cấp không gi</a></p>
            <p class="sell-price">giá : 360.000đ <span class="price">520.000đ</span></p>
            <div class="btn-submit">
                <button class="sell-button">Buy Now</button>
                <button class="sell-button" style="background-color: orangered;">Add To Card</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="./footer.jsp"%>
