<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2022
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="./css/product_detail.css">
<%@ include file="./header.jsp"%>
<div class="product-contain">
    <div class="product-img">
        <img class="p-img" src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" alt="ban hoc sinh">
    </div>
    <div class="product-detail">
        <p class="product-name">bộ 3 dao inock cao cấp không gi</p>
        <p>Thương Hiệu: <span class="product-brand"> name brand</span></p>
        <p>
            price:<span class="product-sell-price"> 500000</span> <span class="product-price"> 700000</span>
        </p>
        <div class="product-detail-img">
        </div>
        <div class="product-quanlity">
            <p>Số Lượng:</p>
            <div class="quanlity">
                <button class="minus">-</button>
                <input type="text" name="number" id="num">
                <button class="plus">+</button>
            </div>
        </div>
        <button class="product-buy">Mua Ngay</button>
    </div>
    <div class="product-promotion">
        <h3>Khuyến mãi</h3>
        <ul>
            <li>Tặng cho khách lần đầu mua hàng online tại web</li>
            <li>Phiếu mua hàng 40.000đ</li>
            <li>5 lần FREEship</li>
            <li>giảm ngay 30.000đ khi thanh toán bằng city bank</li>
        </ul>
        <p>Áp dụng tại Tp.HCM và 1 số khu vực, 1 SĐT nhận 1 lần (Xem chi tiết)</p>
    </div>
</div>
<div class="product-info">
    <div class="infomation">
        <h3>thông tin sản phẩm</h3>
        <div class="lines"></div>
        <p>
            Thiết kế đơn giản, tinh tế
            Công nghệ mài đơn 65% tạo góc cắt nhỏ vượt trội
            Độ sắc bén, bền cứng và chống gỉ cao
            Nấu ăn nhanh hơn
            Tiện lợi, an toàn khi sử dụng
            Bề mặt mài lưỡi dao rộng gấp 3 lần giúp mài lại nhiều lần
            Chuyên sử dụng cho các loại hoa quả
        </p>
        <p>mô tả sản phẩm</p>
        <p>Để thưởng thức hoa quả ngon không thể thiếu đượcdao gọt hoa quảsắc bén, hỗ trợ tối đa cho công việc nhà bếp của bạn thêm phần đơn giản và nhanh chóng hơn.Sản phẩmdao gọt hoa quả Sunhouse KS-KN100PSlà sự lựa chọn hoàn hảo cho gia đình bạn với thiết kế đơn giản, tinh tế với lưỡi dao sắc bén cùng chất lượng tuyệt hảo mang đến sự chính xác và an toàn cho người sử dụng.</p>
    </div>
    <div class="delivery">
        <h3>Tùy Chọn Giao Hàng</h3>
        <div class="lines"></div>
        <p><i class="fas fa-location-arrow"></i> Hồ Chí Minh, Quận 1, Phường Phạm Ngũ Lão</p>
        <p>giao hàng tiêu chuẩn     11.000đ</p>
        <p>Thanh toán khi nhận hàng. (Không được đồng kiểm)</p>
        <h3>Chính Sách Bảo Hành</h3>
        <div class="lines"></div>
        <ul>
            <li>100% chính hãng</li>
            <li>15 ngày đổi trả hàng <span>không được đổi trả với lý do không vừa ý</span></li>
            <li>không áp dụng chính sách bảo hành</li>
        </ul>
    </div>
</div>
<div class="product-comment">
    <h3>NHẬN XÉT SẢN PHẨM</h3>
    <input type="text" name="input" id="input" placeholder="Mời Bạn Để Lại Đánh giá">
    <div class="comment">
        <div class="id-img">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="comment-logo" alt="comment-logo">
            <p class="text-comment">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est deserunt autem velit animi enim aspernatur voluptatum. A voluptate, accusamus id optio esse vero cupiditate molestias ut quia laborum minus veritatis.</p>
        </div>
        <div class="id-img">
            <img src="./images/main/ban-hoc-sinh-xep-gon-cho-be-tien-loi-san_2408576_L.jpg" class="comment-logo" alt="comment-logo">
            <p class="text-comment">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est deserunt autem velit animi enim aspernatur voluptatum. A voluptate, accusamus id optio esse vero cupiditate molestias ut quia laborum minus veritatis.</p>
        </div>
    </div>
    <button class="more">xem them</button>
</div>
<%@ include file="./footer.jsp"%>