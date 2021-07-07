package elpisclothing.pageObjects;

import common.CommonWeb;
import elpisclothing.pageUIs.Menu_PageUI;

public class Menu_PageObject extends CommonWeb {

	public void clickToLoginHyperlink() {
		clickToElement(Menu_PageUI.hyperlink_LOGIN);
	}

	public void clickToSearchIcon() {
		clickToElement(Menu_PageUI.icon_SEARCH);
	}

	public void clickToCartIcon() {
		clickToElement(Menu_PageUI.icon_CART);

	}

}
