package tests;

import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptAlertsPage;

import static io.qameta.allure.Allure.step;

public class AlertPageTest extends BaseTest {

    private HomePage homePage;
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        javaScriptAlertsPage = new JavaScriptAlertsPage();
    }

    @Test
    public void test() {
        step("Click Alert Link");
        homePage.clickAlertLink();

        step("JavaScript Alert Page is displayed");
        Assert.assertTrue(javaScriptAlertsPage.isJavaScriptAlertPageDisplayed(),
                "Java Script Alert Page is not displayed");

        step("Click alert Button");
        javaScriptAlertsPage.clickAlertBtn();

        step("Alert accept and sent text");
        AqualityServices.getBrowser().handlePromptAlert(AlertActions.ACCEPT, "Mehedi");

        step("Refresh Page");
        AqualityServices.getBrowser().getDriver().navigate().refresh();

        step("Second alert button is enabled");
        Assert.assertTrue(javaScriptAlertsPage.isSecondAlertBtnEnabled(),
                "Second Button is not Enabled");

        step("Click second alert Button");
        javaScriptAlertsPage.clickSecondAlert();

        step("Accept Alert");
        AqualityServices.getBrowser().handleAlert(AlertActions.ACCEPT);

        step("Again click second alert Button");
        javaScriptAlertsPage.clickSecondAlert();

        step("Decline Alert");
        AqualityServices.getBrowser().handleAlert(AlertActions.DECLINE);
    }
}

