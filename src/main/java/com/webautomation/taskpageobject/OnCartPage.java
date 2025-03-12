package com.webautomation.taskpageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class OnCartPage extends AbstractComponent{
    WebDriver driver;

    public OnCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = ".cart_item .inventory_item_name" )
    List<WebElement> listProducts;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    By rowButton = By.id("checkout");
    public void goToCheckoutPage(){
        visibilityOfElementLocated(rowButton);
        checkoutBtn.click();
    }

    public boolean verifyProduct(String productName){ 
        visibilityOfElementLocated(rowButton);
        Boolean match = listProducts.stream().anyMatch(prod -> prod.getText().contains(productName));
        return match;
    }
}
