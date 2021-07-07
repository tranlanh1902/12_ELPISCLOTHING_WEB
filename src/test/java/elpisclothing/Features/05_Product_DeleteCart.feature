@delete
#Tiền điều kiện: giỏ hàng có sản phẩm
Feature: 05_Xoá sản phẩm khỏi giỏ hàng 
Scenario: 01_Xoá giỏ hàng thành công 
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
	And Product-CartPage: nhấn hyperlink xoá sản phẩm 
	Then Product-CartPage: kiểm tra xoá thành công với thông báo "Giỏ hàng của bạn đang trống" 
	