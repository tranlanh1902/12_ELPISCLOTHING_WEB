@edit
#Tiền điều kiện: giỏ hàng có sản phẩm
Feature: 04_Sửa sản phẩm ở giỏ hàng 
Scenario: 01_Sửa giỏ hàng thành công 
	Given HomePage: mở trang https://elpisclothing.vn 
	When HomePage: đóng chatbox nếu hiển thị 
	And Menu: nhấn hyperlink Tài khoản
	Then LoginPage: kiểm tra mở trang Đăng nhập với header "Đăng nhập" được hiển thị 
	When LoginPage: nhập thông tin đăng nhập 
		| email                   | matKhau       | 
		| quynhkudo1998@gmail.com | Matkhaula9998 |   
	And LoginPage: nhấn button Đăng nhập 
	Then AccountPage: kiểm tra login thành công với tên acc "QUYNH VUONG" được hiển thị 
	When Menu: nhấn icon giỏ hàng 
	And Product-CartPage: chọn số lượng sản phẩm là 5
	And Product-CartPage: lấy thông tin Tên, Giá tiền, Tiêu đề, Kích thước, Số lượng sản phẩm trong giỏ hàng và Tổng tiền 
	Then Product-CartPage: kiểm tra tổng tiền = số lượng x giá tiền 
