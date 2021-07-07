package elpisclothing.pageObjects;

import common.CommonWeb;
import elpisclothing.pageUIs.Product_Search_PageUI;

public class Product_Search_PageObject extends CommonWeb {

	public void inputToSearchAndEnterTxt(String key) {
		sendkeyAndEnterToElement(Product_Search_PageUI.txt_SEARCH, key);
	}

	public void verifyMessageResultSeach(String mesage) {
		verifyContainTextValueElement(Product_Search_PageUI.label_RESULT_SEARCH, mesage);
	}

	public void verifyNoMessageResultSeach(String mesage) {
		verifyContainTextValueElement(Product_Search_PageUI.label_NO_RESULT_SEARCH, mesage);

	}

	public void clickToNameLabel(String key) {
		scrollToElementJS(Product_Search_PageUI.label_dynamic_NAME,key);
		
		clickToElement(Product_Search_PageUI.label_dynamic_NAME, key);
	}

}
