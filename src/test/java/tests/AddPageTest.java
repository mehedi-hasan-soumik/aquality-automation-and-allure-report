package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.HomePage;

import static io.qameta.allure.Allure.step;

public class AddPageTest extends BaseTest {

    private HomePage homePage;
    private AddPage addPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        addPage = new AddPage();
    }

    @Test
    public void testAdd() {
        step("Click Add and Remove Page");
        homePage.clickaddandRemovelink();

        step("Check Add and Remove Page is Displayed");
        Assert.assertTrue(addPage.isAddPageDisplayed(), "Add Page is not displayed");

        step("Click Add element");
        addPage.clickElementBtn();

        step("Click Remove Element");
        addPage.clickDeleteElement();
    }
}

