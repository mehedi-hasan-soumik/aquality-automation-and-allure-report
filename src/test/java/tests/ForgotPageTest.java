package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ForgotPage;
import pages.HomePage;

import static io.qameta.allure.Allure.step;

public class ForgotPageTest extends BaseTest {

    public static final String EMAIL = "mehedihasan@gmail.com";

    private HomePage homePage;
    private ForgotPage forgotPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        forgotPage = new ForgotPage();
    }

    @Test
    public void test() {
        step("Click Forgot Page Link");
        homePage.clickForgotBtn();

        step("Forgot page Displayed");
        Assert.assertTrue(forgotPage.isForgotPageDisplayed(),
                "Forgot page is not displayed");

        step("Input email");
        forgotPage.inputTextField(EMAIL);

        step("Click forgot Button");
        forgotPage.clickForgotBtn();
    }
}