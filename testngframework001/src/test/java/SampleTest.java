package test.java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import main.java.pageObjects.HomePageElements;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
        public void sampleMethodForEmailEnter() {
        HomePageEvents homePageEvents = new HomePageEvents();
        LoginPageEvents loginPageEvents = new LoginPageEvents();

        homePageEvents.clickOnSignInBtn();
        loginPageEvents.verifyLoginPageIsOpen();
        loginPageEvents.enterEmailAddress();

    }
}
