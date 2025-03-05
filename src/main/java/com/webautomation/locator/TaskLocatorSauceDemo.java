package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskLocatorSauceDemo {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        
        // login scenario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        // add to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_link")));
        driver.findElement(By.className("shopping_cart_link")).click();

        // checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        driver.findElement(By.id("checkout")).click();

        // checkout info
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        driver.findElement(By.name("first-name")).sendKeys("Albert");
        driver.findElement(By.name("last-name")).sendKeys("Einstein");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        // finish
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
        driver.findElement(By.id("continue")).click();

        driver.close();
    }
}