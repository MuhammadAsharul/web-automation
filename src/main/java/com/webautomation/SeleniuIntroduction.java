package com.webautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniuIntroduction {
    public static void main(String[] args) throws InterruptedException {
        // loginScenario();
        // invalidLoginScenario();
        resetPasswordScenario();

    }

    public static void loginScenario() throws InterruptedException{
        // Write your code here
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        // driver.findElement(By.id("inputUsername")).sendKeys("masharul51@gmail.com");
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("masharul51@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(5000);

        String name = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
        System.out.println(name);

        driver.quit();
    }

    public static void invalidLoginScenario() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        driver.findElement(By.id("inputUsername")).sendKeys("masharul51@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("awkoawkoawkaok");
        driver.findElement(By.className("signInBtn")).click();

        String errorMessage = driver.findElement(By.xpath("//p[@class='error']")).getText();
        System.out.println(errorMessage);

        Thread.sleep(5000);
        driver.quit();
    }

    public static void resetPasswordScenario() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Muhammad Asharul");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("masharul51@gmail.com");
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        Thread.sleep(5000);

        String password = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        // System.out.println(password);

        String [] splitParts = password.split("'");
        String extractedPassword = splitParts[1];
        System.out.println(extractedPassword);

        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("masharul51@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(extractedPassword);
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(5000);
        driver.quit();
    }


}
