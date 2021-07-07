@add
#Tiền điều kiện: xoá sạch giỏ hàng
Feature: 03_Thêm sản phẩm vào giỏ hàng 
Scenario Outline: 01_Thêm vào giỏ hàng thành công 
	Given HomePage: mở trang https://elpisclothing.vn 
	When HomePage: đóng chatbox nếu hiển thị 
	And Menu: nhấn hyperlink Tài khoản
	Then LoginPage: kiểm tra mở trang Đăng nhập với header "Đăng nhập" được hiển thị 
	When LoginPage: nhập thông tin đăng nhập 
		| email                   | matKhau       | 
		| quynhkudo1998@gmail.com | Matkhaula9998 |   
	And LoginPage: nhấn button Đăng nhập 
	Then AccountPage: kiểm tra login thành công với tên acc "QUYNH VUONG" được hiển thị 
	When Menu: nhấn icon Tìm kiếm 
	And Product-SearchPage: nhập từ khoá tìm kiếm và nhấn Enter 
		|tuKhoaTimKiem  |
		|<tuKhoaTimKiem>|
	Then Product-SearchPage: kiểm tra hiển thị thông báo tìm kiếm thành công 
		|thongBao  |
		|<thongBao>|
	When Product-SearchPage: nhấn vào sản phẩm đã tìm kiếm để xem chi tiết 
		|tuKhoaTimKiem  |
		|<tuKhoaTimKiem>|
	Then Product-ViewDetailPage: kiểm tra mở trang Xem chi tiết sản phẩm thành công với button Thêm vào giỏ hàng được hiển thị 
	When Product-ViewDetailPage: chọn thông tin sản phẩm 
		|tieuDe  |kichThuoc  |
		|<tieuDe>|<kichThuoc>|
	And Product-ViewDetailPage: lấy thông tin Tên, Giá tiền, Tiêu đề, Kích thước của sản phẩm đã chọn 
		|tieuDe  |kichThuoc  |
		|<tieuDe>|<kichThuoc>|
	And Product-ViewDetailPage: nhấn button Thêm vào giỏ hàng 
	And Product-CartPage: lấy thông tin Tên, Giá tiền, Tiêu đề, Kích thước, Số lượng sản phẩm trong giỏ hàng và Tổng tiền 
	Then Product-CartPage: kiểm tra thông tin Tên, Giá tiền, Tiêu đề, Kích thước sản phẩm đã chọn lần lượt trùng với thông tin Tên, Giá tiền, Tiêu đề, Kích thước sản phẩm với trong giỏ hàng 
	And Product-CartPage: kiểm tra thông tin số lượng của sản phẩm đã chọn là 1 
	And Product-CartPage: kiểm tra tổng tiền = số lượng x giá tiền 
	Examples: 
		| case                         | tuKhoaTimKiem | thongBao                   | tieuDe | kichThuoc |
		| Thêm vào giỏ hàng thành công | SS21B02       | Có 1 sản phẩm cho tìm kiếm | Hồng   | L         | 
		