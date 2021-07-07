package elpisclothing.StepsDefinitions;

import cucumber.api.java.en.Then;
import elpisclothing.pageObjects.Account_PageObject;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings({ "deprecation" })
public class Account_PageDefinitions {
	@Steps
	Account_PageObject account;

	@Then("^AccountPage: kiểm tra login thành công với tên acc \"([^\"]*)\" được hiển thị$")
	public void taikhoanpage_kim_tra_login_thnh_cng_vi_tn_acc_something_c_hin_th(String acc) {
		account.verifyOpenAccountPage(acc);
	}

}
