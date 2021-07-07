package elpisclothing.StepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import elpisclothing.pageObjects.Home_PageObject;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings({ "deprecation" })
public class Home_PageDefinitions {
	@Steps
	Home_PageObject home;

	@Given("^HomePage: mở trang https://elpisclothing.vn$")
	public void m_trang_httpselpisclothingvn() {
		home.openPageEpisclothing();
	}

	@When("^HomePage: đóng chatbox nếu hiển thị$")
	public void homepage_ng_chatbox_nu_hin_th() throws InterruptedException {
		home.closeChatBox();
	}

}
