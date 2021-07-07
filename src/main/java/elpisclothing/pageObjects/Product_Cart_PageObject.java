package elpisclothing.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;

import common.CommonWeb;
import elpisclothing.pageUIs.Product_Cart_PageUI;
import net.serenitybdd.core.pages.WebElementFacade;

public class Product_Cart_PageObject extends CommonWeb {

	public String getNamePro() {
		return getText(Product_Cart_PageUI.label_NAME_PRODUCT);
	}

	public int getPricelPro() {
		String a = getText(Product_Cart_PageUI.label_PRICE_PRODUCT);

		String[] a1 = a.split("\\s");
		String a2 = a1[0];
		String a3 = a2.replaceAll(",", "");

		int a4 = Integer.parseInt(a3);
		return a4;
	}

	public String getTitlePro() {
		String a = getText(Product_Cart_PageUI.label_TITLE_SIZE_PRODUCT);

		String[] a1 = a.split("\\s");
		String a2 = a1[0];
		return a2;

	}

	public String getSizePro() {
		String a = getText(Product_Cart_PageUI.label_TITLE_SIZE_PRODUCT);
		String[] a1 = a.split("\\s");
		String a2 = a1[2];
		return a2;

	}

	public int getCountPro() {
		String attribute = "value";

		String a = getAttributeValue(Product_Cart_PageUI.label_COUNT_PRODUCT, attribute);
		int a1 = Integer.parseInt(a);
		return a1;
	}

	public int getTotalPricePro() {
		String a = getText(Product_Cart_PageUI.label_TOTAL_PRICE_VALUE);

		String[] a1 = a.split("\\s");
		String a2 = a1[0];
		String a3 = a2.replaceAll(",", "");

		int a4 = Integer.parseInt(a3);
		return a4;
	}

	public void clickToDeleteHyperlink() {
		List<WebElementFacade> lst = getListElement(Product_Cart_PageUI.hyperlink_dynamic_DELETE);

		if (lst.size() > 0) {
			for (WebElementFacade a : lst) {
				a.click();
			}

		}
	}

	public void verifyDeleteSuccess(String message) {
		verifyContainTextValueElement(Product_Cart_PageUI.lable_MESSAGE_DELETE, message);
	}

	public void chooseCountPro(int countEx) {
		int countCurrent = getCountPro();
		int downOrUp;

		int diff = countEx - countCurrent;

		if (diff > 0) {
			downOrUp = 1;
		} else if (diff < 0) {
			diff = -1 * diff;
			downOrUp = -1;
		} else {
			downOrUp = 0;
		}

		for (int i = 0; i < diff; i++) {
			if (downOrUp == 1) {
				sendKeyBoardToElement(Product_Cart_PageUI.cbo_count, Keys.ARROW_UP);
			} else if (downOrUp == -1) {
				sendKeyBoardToElement(Product_Cart_PageUI.cbo_count, Keys.ARROW_DOWN);

			} else {
				break;
			}
		}
	}

}
