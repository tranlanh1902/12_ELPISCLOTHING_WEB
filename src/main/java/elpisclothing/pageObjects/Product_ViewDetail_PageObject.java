package elpisclothing.pageObjects;

import common.CommonWeb;
import elpisclothing.pageUIs.Product_ViewDetail_PageUI;

public class Product_ViewDetail_PageObject extends CommonWeb {

	public void verifyOpenViewPage() {
		verifyDisplayedOrVisibleElement(Product_ViewDetail_PageUI.btn_ADD);
	}

	public void dynamicSelectTitleLabel(String title) {
		clickToElement(Product_ViewDetail_PageUI.label_dynamic_OPTION_TITLE, title);
	}

	public void dynamicSelectSizeLabel(String size) {
		clickToElement(Product_ViewDetail_PageUI.label_dynamic_OPTION_SIZE, size);
	}

	public void clickToAddBtn() {
		clickToElement(Product_ViewDetail_PageUI.btn_ADD);

	}

	public String getNamePro() {
		return getText(Product_ViewDetail_PageUI.label_NAME_PRODUCT);
	}

	public int getPricePro() {
		String a = getText(Product_ViewDetail_PageUI.label_PRICE_PRODUCT);

		String[] a1 = a.split("\\s");
		String a2 = a1[0];
		String a3 = a2.replaceAll(",", "");

		int a4 = Integer.parseInt(a3);
		return a4;
	}

}
