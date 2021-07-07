package elpisclothing.StepsDefinitions;

import cucumber.api.java.en.When;
import elpisclothing.pageObjects.Menu_PageObject;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings({ "deprecation" })
public class Menu_PageDefinitions {
	@Steps
	Menu_PageObject menu;

	@When("^Menu: nhấn hyperlink Tài khoản$")
	public void nhn_hyperlink_ng_nhp() {
		menu.clickToLoginHyperlink();
	}

	@When("^Menu: nhấn icon Tìm kiếm$")
	public void menu_nhn_icon_tm_kim() {
		menu.clickToSearchIcon();
	}

	@When("^Menu: nhấn icon giỏ hàng$")
	public void menu_nhn_icon_gi_hng() {
		menu.clickToCartIcon();
	}

}
