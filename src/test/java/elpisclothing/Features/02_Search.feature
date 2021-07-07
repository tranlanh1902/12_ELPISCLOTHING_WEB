@search 
Feature: 02_Tìm kiếm sản phẩm 
Scenario Outline: 01_Tìm kiếm 
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
	Then Product-SearchPage: kiểm tra hiển thị thông báo 
		|thongBao  |type  |
		|<thongBao>|<type>|
		
		#type(0: nhập từ khoá tìm kiếm & có kết quả; 1: nhập từ khoá tìm kiếm & không có kết quả)
	Examples: 
		| case                                                   | tuKhoaTimKiem | thongBao                            |type |
		| Tìm kiếm khi nhập textbox là 1 phần của xâu đã tồn tại | mấn           | Có 5 sản phẩm cho tìm kiếm          | 0   |
		| Tìm kiếm không có kết quả                              | mấn123        | Không tìm thấy nội dung bạn yêu cầu | 1   |
		