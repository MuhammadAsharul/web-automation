package com.webautomation.taskpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class InCompletePage extends AbstractComponent{
    WebDriver driver;

    public InCompletePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className="complete-header")
    WebElement checkoutComplete;

    By completeText = By.className("complete-header");

    public String getCheckoutComplete(){
        visibilityOfElementLocated(completeText);
        return checkoutComplete.getText();
    }



}
