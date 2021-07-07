package elpisclothing.pageObjects;

import common.CommonWeb;
import elpisclothing.pageUIs.Home_PageUI;

public class Home_PageObject extends CommonWeb {

	public void openPageEpisclothing() {
		openPage();
	}

	public void closeChatBox() throws InterruptedException {
		Thread.sleep(2000);

		switchToIframeByElement(Home_PageUI.iframe_CHAT);
		

		if (getListElement(Home_PageUI.icon_CLOSE_CHAT).size() > 0) {
			clickToElement(Home_PageUI.icon_CLOSE_CHAT);
		}
		backToTopWindows();
	}
}
