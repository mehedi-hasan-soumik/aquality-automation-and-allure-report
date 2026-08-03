package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static io.qameta.allure.Allure.step;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
    }

    @Test
    public void test() {
        step("Home Page Displayed");
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home Page is not displayed");
    }
}