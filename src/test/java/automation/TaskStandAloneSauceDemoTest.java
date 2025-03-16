package automation;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webautomation.taskpageobject.AddToCartPage;
import com.webautomation.taskpageobject.CheckoutPage;
import com.webautomation.taskpageobject.InCompletePage;
import com.webautomation.taskpageobject.LoginPage;
import com.webautomation.taskpageobject.OnCartPage;
import com.webautomation.taskpageobject.OverviewPage;

import org.testng.Assert;

public class TaskStandAloneSauceDemoTest {

    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
    }
    @Test(dataProvider = "dataTestMapping") 
    public void createOrder(HashMap<String, String> input) throws InterruptedException{ 
        // 1
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(input.get("user-name"), input.get("password"));

        // 2
        String productName = "Sauce Labs Backpack";
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addToCartt(productName);

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        // 3
        OnCartPage onCartPage = new OnCartPage(driver);
        Assert.assertTrue(onCartPage.verifyProduct(productName));
        onCartPage.goToCheckoutPage();

        // 4
        String firstNamee = "Albert";
        String lastNamee = "Einstein";
        String postalCodee = "12345";
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutt(firstNamee, lastNamee, postalCodee);

        // 5
        String productNamee = "Sauce Labs Backpack";
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.verifyProductt(productNamee));
        overviewPage.LastStep();

        // 6
        InCompletePage completePage = new InCompletePage(driver);
        completePage.getCheckoutComplete();
        Assert.assertEquals(completePage.getCheckoutComplete(), "Thank you for your order!" );
    }

    @AfterMethod
    public void TearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @DataProvider
    public Object[][] dataTestMapping(){
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("user-name", "standard_user");
        data.put("password", "secret_sauce");
        data.put("first-name", "Albert");
        data.put("last-name", "Einstein");
        data.put("postal-code", "12345");
        return new Object[][]{
            {data}
        }; 
    }
}
