package automation;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webautomation.pageobject.CartPage;
import com.webautomation.pageobject.ConfirmationPage;
import com.webautomation.pageobject.LandingPage;
import com.webautomation.pageobject.OrderPage;
import com.webautomation.pageobject.ProductListPage;

public class StandAloneTestNGImplTest2 {
    /* 
     * Annotation
     * dataprovider
     * Running Test
     */
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider = "dataTestMapping")
    // public void createOrder(String email, String password, String productName) throws InterruptedException{
        public void createOrder(HashMap<String, String> input) throws InterruptedException{ 

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(input.get("userEmail"), input.get("password"));   

        //List Product
        String productName = "ZARA COAT 3";
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(productName);

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyProduct(productName));
        cartPage.goToCheckoutPage();

        String destination = "Indonesia";

        OrderPage orderPage = new OrderPage(driver);
        orderPage.selectCountry(destination);
        orderPage.sumbitOrder();

        ConfirmationPage onfirmationPage = new ConfirmationPage(driver);
        onfirmationPage.getConfirmationPage();

        Assert.assertEquals(onfirmationPage.getConfirmationPage(), "THANKYOU FOR THE ORDER.");
    }
    @AfterMethod
    public void TearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    // @DataProvider
    // public Object[][] dataTest(){
    //     return new Object[][]{
    //         {"masharul51@gmai.com", "Boyolali15", "ZARA COAT 3"},
    //     };
    // }

    @DataProvider
    public Object[][] dataTestMapping(){
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("userEmail", "masharul51@gmai.com");
        data.put("password", "Boyolali15");
        data.put("productName", "ZARA COAT 3");
        return new Object[][]{
            {data}
        }; 
    }
}
