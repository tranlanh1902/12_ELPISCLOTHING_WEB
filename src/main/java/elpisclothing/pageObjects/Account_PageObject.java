package elpisclothing.pageObjects;

import common.CommonWeb;
import elpisclothing.pageUIs.Account_PageUI;

public class Account_PageObject extends CommonWeb {

	public void verifyOpenAccountPage(String acc) {
		verifyContainTextValueElement(Account_PageUI.label_ACCOUNT_NAME,acc);		
	}

}
