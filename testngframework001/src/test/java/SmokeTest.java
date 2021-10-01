package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest{


    @Test
    public void verifyPageTitleTest(){

    String sTitle = driver.getTitle();
    BaseTest.logger.info(" The title of the page is "+sTitle);
        Assert.assertEquals(sTitle, "Sign");

    }
}
