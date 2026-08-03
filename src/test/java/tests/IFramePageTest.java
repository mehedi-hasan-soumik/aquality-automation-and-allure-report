package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IFramePage;

import static io.qameta.allure.Allure.step;

public class IFramePageTest extends BaseTest {

    public static final String TEXT = "Your content goes here.";

    private HomePage homePage;
    private IFramePage iFramePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        iFramePage = new IFramePage();
    }

    @Test
    public void test() {
        step("Click Iframe Page Link");
        homePage.clickIframeLink();

        step("Iframe page displayed");
        Assert.assertTrue(iFramePage.isIframePageDisplayed(), "Page is not displayed");

        step("Click i frame Link");
        iFramePage.clickFrameLink();

        step("Switch to iframe");
        iFramePage.switchIframes();

        step("Get text from Iframe page");
        String actualText = iFramePage.getText();

        step("Text is same");
        Assert.assertEquals(actualText, TEXT, "Text is not Same");

        step("Switch to default content");
        AqualityServices.getBrowser().getDriver().switchTo().defaultContent();
    }
}