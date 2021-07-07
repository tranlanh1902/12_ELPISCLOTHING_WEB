package elpisclothing.pageUIs;

import common.CommonWeb;

public class Product_ViewDetail_PageUI extends CommonWeb {
	public static final String label_TITLE = "//select[@id='product-select-option-0']//preceding-sibling::label";
	public static final String label_NAME_PRODUCT = "//h1[@class='product-title']";
	public static final String label_PRICE_PRODUCT = "//div[@class='product-price']//span";
	public static final String label_dynamic_OPTION_TITLE = "//label[contains(@for,'product-choose-swatch-0') and text()='%s']";
	public static final String label_dynamic_OPTION_SIZE = "//label[contains(@for,'product-choose-swatch-1') and text()='%s']";
	public static final String btn_ADD = "//button[@class='btn-add-cart']";

}
