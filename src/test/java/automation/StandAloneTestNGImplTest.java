package automation;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StandAloneTestNGImplTest {
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));

        // Thread.sleep(100000);
        // Scenario Login
        // driver.findElement(By.id("userEmail")).sendKeys(email);
        // driver.findElement(By.id("userPassword")).sendKeys(password);

        driver.findElement(By.id("userEmail")).sendKeys(input.get("userEmail"));
        driver.findElement(By.id("userPassword")).sendKeys(input.get("password"));

        driver.findElement(By.className("login-btn")).click();

        // Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        //List Product
        List<WebElement> listProduct =  driver.findElements(By.cssSelector(".mb-3"));

        WebElement product = listProduct.stream().filter(prod -> 
        // prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector("b")).getText().equals(input.get("productName"))).findFirst().orElse(null);

        product.findElement(By.xpath("//div[@class='card-body']//child::button//child::i[@class='fa fa-shopping-cart']")).click();

        System.out.println("list product" + product);

        // Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

        Thread.sleep(2000);
        // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner[@class = 'ng-star-inserted']"))));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));


        driver.findElement(By.cssSelector(".totalRow button")).click();

        // Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder = 'Select Country']")));

        // driver.findElement(By.cssSelector("[placeholder = 'Select Country']")).sendKeys("Indonesia");

        Actions action =  new Actions(driver);

        action.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")),"ind").build().perform();

        // Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-star-inserted']")));


        String destination = "Indonesia";

        List<WebElement> country = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));

        // System.out.println(country.get(0).getText());

        // for (WebElement cont : country){
        //     if (cont.getText().equalsIgnoreCase(destination)) {
        //         cont.click();
        //     }
        // }

        WebElement cont = country.stream().filter(cont2 -> 
        cont2.getText().equalsIgnoreCase(destination)).findFirst().orElse(null);

        cont.click();

        driver.findElement(By.cssSelector(".action__submit")).click(); 


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));

        String confirmationPage = driver.findElement(By.className("hero-primary")).getText();

        System.out.println("buyer berhasil checkout " + confirmationPage);
        

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
