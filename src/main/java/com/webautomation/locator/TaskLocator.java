package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

        driver.quit();
    }
}
