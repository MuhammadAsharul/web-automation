package taskstepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.webautomation.taskpageobject.OnCartPage;
import com.webautomation.taskpageobject.AddToCartPage;
import com.webautomation.taskpageobject.CheckoutPage;
import com.webautomation.taskpageobject.InCompletePage;
import com.webautomation.taskpageobject.LoginPage;
import com.webautomation.taskpageobject.OverviewPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskStepDefinitionsImpl {
    WebDriver driver;

    @Given("Buyer landing to ecommerce")
    public void landingPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("^Buyer logged to website username (.+) and password (.+)$")
    public void buyerLoginn(String username, String password){
        // 1
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @When("^Buyer add (.+) to cart$")
    public void buyerAddProductt(String product_name)  throws InterruptedException{
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addToCartt(product_name);
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

    @And("^Buyer checkout (.+)$")
    public void buyerCartt(String  product_name) {
        OnCartPage cartPage = new OnCartPage(driver);
        Assert.assertTrue(cartPage.verifyProduct(product_name));
        cartPage.goToCheckoutPage();
    }

    @And("^Buyer input firstname (.+) and lastname (.+) and postal-code (.+)$")
    public void buyerCheckoutt(String first_name, String last_name, String postal_code) throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutt(first_name, last_name, postal_code);
    }

    @And("^Buyer finish order (.+)$")
    public void buyerFinishOrder(String product_name) {
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.verifyProductt(product_name));
        overviewPage.LastStep();
    }

    @Then("Buyer will see message is displayed on complete page Thank you for your order!")
    public void buyerSeeMessage() {
        InCompletePage completePage = new InCompletePage(driver);
        completePage.getCheckoutComplete();
        Assert.assertEquals(completePage.getCheckoutComplete(), "Thank you for your order!" );
    }
}
