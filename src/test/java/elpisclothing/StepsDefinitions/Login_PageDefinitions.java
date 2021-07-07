package elpisclothing.StepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import elpisclothing.pageObjects.Login_PageObject;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings({ "deprecation" })
public class Login_PageDefinitions {
	@Steps
	Login_PageObject login;

	@Then("^LoginPage: kiểm tra mở trang Đăng nhập với header \"([^\"]*)\" được hiển thị$")
	public void loginpage_kim_tra_m_trang_ng_nhp_vi_header_something_c_hin_th(String header) {
		login.verifyOpenLoginPage(header);
	}

	@Given("^LoginPage: nhập thông tin đăng nhập$")
	public void dangnhappage_nhp_thng_tin_ng_nhp_thnh_cng(DataTable table) {
		String emailSenkey = login.getValueColumnDataTableBDD(table, "email");
		String passSenkey = login.getValueColumnDataTableBDD(table, "matKhau");

		if (emailSenkey.trim().length() > 0) {
			login.inputToEmailTxt(emailSenkey);
		}

		if (passSenkey.trim().length() > 0) {
			login.inputToPassTxt(passSenkey);
		}
	}

	@And("^LoginPage: nhấn button Đăng nhập$")
	public void dangnhappage_nhn_button_ng_nhp() {
		login.clickToDanNhapBtn();
	}

	@Then("^LoginPage: kiểm tra hiển thị thông báo lỗi$")
	public void dangnhappage_kim_tra_hin_th_thng_bo_li(DataTable table) {
		String message = login.getValueColumnDataTableBDD(table, "thongBaoLoi");
		login.verifyMessagerErrorDisplayed(message);

	}
}
