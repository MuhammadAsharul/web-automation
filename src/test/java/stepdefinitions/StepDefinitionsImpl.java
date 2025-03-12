package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.webautomation.pageobject.CartPage;
import com.webautomation.pageobject.ConfirmationPage;
import com.webautomation.pageobject.LandingPage;
import com.webautomation.pageobject.OrderPage;
import com.webautomation.pageobject.ProductListPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImpl {
    WebDriver driver;
    // String productName = "ZARA COAT 3";
    // String destination = "Indonesia";
    @Given("Buyer landing to ecommerce")
    public void landingPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("^Buyer logged to website email (.+) and password (.+)$")
    public void buyerLogin(String email, String password) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(email, password);   
    }

    @When("^Buyer add (.+) to cart$")
    public void buyerAddProduct(String product_name)  throws InterruptedException{
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(product_name);
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    }

    @And("^Buyer checkout (.+)$")
    public void buyerCheckout(String  product_name) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyProduct(product_name));
        cartPage.goToCheckoutPage();
    }

    @And("^Buyer place order (.+)$")
    public void buyerPlaceOrder(String destination) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.selectCountry(destination);
        orderPage.sumbitOrder();
    }

    @Then("Buyer will see message is displayed on confirmation page THANKYOU FOR THE ORDER.")
    public void buyerSeeMessage() {
        ConfirmationPage onfirmationPage = new ConfirmationPage(driver);
        onfirmationPage.getConfirmationPage();
        Assert.assertEquals(onfirmationPage.getConfirmationPage(), "THANKYOU FOR THE ORDER.");
    }
}
