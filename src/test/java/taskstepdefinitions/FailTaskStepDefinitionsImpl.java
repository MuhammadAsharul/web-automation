package taskstepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.webautomation.taskpageobject.AddToCartPage;
import com.webautomation.taskpageobject.CheckoutPage;
import com.webautomation.taskpageobject.LoginPage;
import com.webautomation.taskpageobject.OnCartPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FailTaskStepDefinitionsImpl {
    WebDriver driver;
    @Given("Buyer landing to ecommercee")
    public void landingPagee() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Given("^Buyer logs in to SauceDemo using username (.+) and password (.+)$")
    public void buyerLoginn(String username, String password){
        // 1
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @When("^Buyer adds (.+) to the cart, goes to the cart page$")
    public void buyerAddProductt(String product_name)  throws InterruptedException{
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addToCartt(product_name);
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

    @And("^Buyer proceeds to checkout (.+)$")
    public void buyerCartt(String  product_name) {
        OnCartPage cartPage = new OnCartPage(driver);
        Assert.assertTrue(cartPage.verifyProduct(product_name));
        cartPage.goToCheckoutPage();
    }

    @And("^Buyer enters shipping details: (.*), (.*), (.*)$")
    public void buyerCheckoutt(String first_name, String last_name, String postal_code) throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutt(first_name, last_name, postal_code);
    }
    @Then("^Buyer sees an error message (.+)$")
    public void buyerSeesErrorMessage(String error_message) {
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-button")).isDisplayed());
    }
}
