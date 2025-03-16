package com.webautomation.taskpageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class AddToCartPage extends AbstractComponent{

    WebDriver driver;
    WebElement productt;

    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    List<WebElement> listProducts;

    // By cartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    By listElement = By.cssSelector(".inventory_item");
    By titleProduct = By.cssSelector(".inventory_item_name");

    public List<WebElement> getProductList() {
        return listProducts;
    }

    public WebElement getProductName(String productName) {
        WebElement productt = getProductList().stream().filter(prod -> prod.findElement(titleProduct).getText().equals(productName)).findFirst().orElse(null);
        return productt;
    }

    By checkoutBtn = By.cssSelector(".checkout");

    public void toCheckoutPage(){
        visibilityOfElementLocated(checkoutBtn);
    }
    
    public void addToCartt(String productName) throws InterruptedException {
        visibilityOfElementLocated(listElement);
        productt = getProductName(productName);
        System.out.println("list product" + productt);
        productt.findElement(cartButton).click();
        Thread.sleep(2000);

    }

}
