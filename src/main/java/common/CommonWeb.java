package common;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CommonWeb extends PageObject {
	WebElement element;
	JavascriptExecutor javascriptExecutor;
	Actions action;

	// get giá trị từng colum Table trong file *.feature
	/**
	 * @param table      : tên bảng Example
	 * @param columnName : tên cột của bảng Examples
	 */
	public String getValueColumnDataTableBDD(DataTable table, String columnName) {
		String valueColumn = null;
		String valueColumnRe = null;
		List<Map<String, String>> asMaps = table.asMaps(String.class, String.class);
		for (Map<String, String> featureMap : asMaps) {
			valueColumn = featureMap.get(columnName);
			valueColumnRe = valueColumn.replaceAll("\"", "");
		}
		return valueColumnRe;
	}

	// mở URL được cấu hình ở file serenity.properties
	public void openPage() {
		open();
	}

	// trả về list element
	/**
	 * @param xpath  : xpath element cần lấy
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public List<WebElementFacade> getListElement(String xpath, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		return findAll(xpath);
	}

	// trả về giá trị attribute element
	/**
	 * @param xpath         : xpath element cần lấy
	 * @param attributeName : tên attribute của element (VD: id, name, class, style...)
	 * @param values        : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public String getAttributeValue(String xpath, String attributeName, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		return element(xpath).waitUntilVisible().getAttribute(attributeName);
	}

	// trả về text element
	/**
	 * @param xpath  : xpath element cần lấy
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public String getText(String xpath, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		return element(xpath).waitUntilVisible().getText();
	}

	

	// verify element chứa text
	/**
	 * @param xpath            : xpath element cần lấy
	 * @param containTextValue : giá trị text của element mong muốn
	 * @param values           : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void verifyContainTextValueElement(String xpath, String containTextValue, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element(xpath).waitUntilVisible().shouldContainText(containTextValue);
	}

	// click element
	/**
	 * @param xpath  : xpath element cần lấy
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void clickToElement(String xpath, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element(xpath).waitUntilVisible().click();
	}

	// clear
	/**
	 * @param xpath  : xpath element cần lấy
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void clearToElement(String xpath, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element(xpath).waitUntilVisible().clear();
	}

	// sendkey
	/**
	 * @param xpath           : xpath element cần lấy
	 * @param valueToSendkey: giá trị muốn senkey vào element
	 * @param values          : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void sendkeyToElement(String xpath, String valueToSendkey, String... values) {
		// Trường hợp senkey nhiều dòng thì xuống dòng textare là dấu \n (VD: Cộng hoà xã hội chủ nghĩa VN\nĐộc lập - tự do - hạnh phúc")
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element(xpath).waitUntilVisible().sendKeys(valueToSendkey);
	}

	// sendkey and Enter
	/**
	 * @param xpath           : xpath element cần lấy
	 * @param valueToSendkey: giá trị muốn senkey vào element
	 * @param values          : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void sendkeyAndEnterToElement(String xpath, String valueToSendkey, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element(xpath).waitUntilVisible().typeAndEnter(valueToSendkey);
	}

	// verify visible element
	/**
	 * @param xpath  : xpath element cần lấy
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void verifyDisplayedOrVisibleElement(String xpath, String... values) {
		// element có trong Dom + có trên UI
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element(xpath).shouldBeVisible();
	}

	// switch to frame
	/**
	 * @param xpath  : xpath frame/iframe cần lấy
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void switchToIframeByElement(String xpath, String... values) {
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element = element(xpath);
		getDriver().switchTo().frame(element);
	}

	// switch to top windows
	public void backToTopWindows() {
		getDriver().switchTo().defaultContent();
		// getDriver().switchTo().parentFrame();
	}

	// Scoll to Element
	/**
	 * @param xpath  : xpath element muốn scroll tới
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public Object scrollToElementJS(String xpath, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		javascriptExecutor = (JavascriptExecutor) getDriver();
		element = element(xpath);
		return javascriptExecutor.executeScript("arguments[0]. scrollIntoView(true);", element);
	}

	// Remove attribute
	/**
	 * @param xpath     : xpath element muốn lấy
	 * @param attribute : tên attribute của element muốn remove
	 * @param values    : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public Object removeAttributeJS(String xpath, String attribute, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		javascriptExecutor = (JavascriptExecutor) getDriver();
		element = element(xpath);
		return javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	// Set attribute
	/**
	 * @param xpath     : xpath element muốn lấy
	 * @param attribute : tên attribute của element muốn set
	 * @param values    : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public Object setAttributeJS(String xpath, String attribute, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		javascriptExecutor = (JavascriptExecutor) getDriver();
		element = element(xpath);
		return javascriptExecutor.executeScript("arguments[0].setAttribute('" + attribute + "');", element);
	}

	// Highlight
	/**
	 * @param xpath  : xpath element muốn lấy
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void highlightElementJS(String xpath, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		javascriptExecutor = (JavascriptExecutor) getDriver();
		element = element(xpath).waitUntilVisible();
		String originalStyle = element.getAttribute("style");
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	// Sendkey Board
	/**
	 * @param xpath  : xpath element cần lấy
	 * @param key    : key enum's value (VD:key=Keys.CONTROL) muốn senkey vào element
	 * @param values : tham số dynamic trong String xpath (có thể có hoặc không)
	 */
	public void sendKeyBoardToElement(String xpath, Keys key, String... values) {
		// key=Keys.CONTROL
		highlightElementJS(xpath, values);
		xpath = String.format(xpath, (Object[]) values);
		element = element(xpath);

		action = new Actions(getDriver());
		action.sendKeys(element, key).perform();
		// element(xpath).sendKeys(key);
	}
}