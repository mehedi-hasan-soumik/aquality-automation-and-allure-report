package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptScrollPage;

import static io.qameta.allure.Allure.step;

public class JavaScriptScrollTest extends BaseTest {

    private HomePage homePage;
    private JavaScriptScrollPage javaScriptScrollPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        javaScriptScrollPage = new JavaScriptScrollPage();
    }

    @Test
    public void test() throws InterruptedException {
        step("Click unlimited scroll page");
        homePage.clickScrollLink();

        step("Get text in first index");
        javaScriptScrollPage.getResult(0);

        step("Get text in seven index");
        javaScriptScrollPage.getResultByIndex(7);
    }
}