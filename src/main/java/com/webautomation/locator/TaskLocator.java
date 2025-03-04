package com.webautomation.locator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskLocator {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        // radio button
        driver.findElement(By.xpath("//label[@for='radio1']//child::input[@value='radio1']")).click();
        driver.findElement(By.xpath("//label[@for='radio2']//child::input[@value='radio2']")).click();
        driver.findElement(By.xpath("//label[@for='radio3']//child::input[@value='radio3']")).click();

        Thread.sleep(4000);
        

        // suggest
        driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys("ind");
        driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Indonesia']")).click();

        Thread.sleep(4000);


        // dropdown
        List<WebElement> dropdown = driver.findElements(By.xpath("//select[@id='dropdown-class-example']//option"));

        for (WebElement element : dropdown) {
            System.out.println("Ini adalah negara " + element.getText());
            if(element.getText().equals("Option2")) {
                element.click();
                break;
                }   
        }
        Thread.sleep(3000);


        // checkbox
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();

        Thread.sleep(3000);
        
        // open new window
        driver.findElement(By.id("openwindow")).click();

		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		for (String S : allWindows) {
			System.out.println("Window " + S);
			Thread.sleep(2000);
		}
		driver.switchTo().window(tabs.get(1));

		// String text = driver.getTitle();
		// System.out.println("Join Button text = " + text);

		driver.switchTo().window(tabs.get(0));

        Thread.sleep(3000);
        
        // open new tab
        driver.findElement(By.id("opentab")).click();

		Set<String> allWindow = driver.getWindowHandles();
		ArrayList<String> tab = new ArrayList<String>(allWindow);
		for (String S : allWindow) {
			System.out.println("Window " + S);
			Thread.sleep(2000);
		}
		driver.switchTo().window(tab.get(1));
		driver.switchTo().window(tabs.get(0));

        Thread.sleep(3000);


        // alert
        driver.findElement(By.id("name")).sendKeys("Asharul");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());

        Thread.sleep(3000);

        

        driver.quit();
    }
}
