package elpisclothing.pageUIs;

import common.CommonWeb;

public class Product_Cart_PageUI extends CommonWeb {
	public static final String label_NAME_PRODUCT = "//h5//a[contains(@href,'/products/')]";
	public static final String label_PRICE_PRODUCT = "//div[contains(@class,'price')]//span";
	public static final String label_TITLE_SIZE_PRODUCT = "//div[contains(@class,'variant')]";
	public static final String label_COUNT_PRODUCT = "//div[@class='sitenav-cart-item-info']//following-sibling::div//input";

	public static final String label_TOTAL_PRICE_TITLE = "//div[@class='sitenav-cart-lines']//following-sibling::div//span[@class='sitenav-cart-total-title']";
	public static final String label_TOTAL_PRICE_VALUE = "//div[@class='sitenav-cart-lines']//following-sibling::div//span[@class='sitenav-cart-total-value']";

	public static final String hyperlink_dynamic_DELETE = "//div[contains(@class,'remove')]//a";
	public static final String lable_MESSAGE_DELETE = "//div[@class='sitenav-cart-lines' and @data-total='0']//p[1]";

	public static final String cbo_count = "//div[@class='sitenav-cart-item-quantity']/input";

}