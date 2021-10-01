package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.BaseTest;

public class LoginPageEvents {

    public void verifyLoginPageIsOpen(){
        BaseTest.logger.info("Verification of Login Page...");
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListWebElement("XPATH", LoginPageElements.loginText).size()>0,"Login page is not opened");
    }

    public void enterEmailAddress(){
        BaseTest.logger.info("Entering the email address");
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.emailAddressID).sendKeys("sample.gmail@gmail.com");
    }
}
