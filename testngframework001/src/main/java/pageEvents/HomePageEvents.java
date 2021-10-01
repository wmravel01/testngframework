package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import test.java.BaseTest;

public class HomePageEvents {

    public void clickOnSignInBtn(){
        BaseTest.logger.info("Clicking on Sign In button");
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
    }
}
