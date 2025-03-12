package com.webautomation.taskpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="first-name")
    WebElement firstName;

    @FindBy(id="last-name")
    WebElement lastName;

    @FindBy(id="postal-code")
    WebElement postalCode;

    @FindBy(id="continue")
    WebElement continueBtn;

    By visibilityOfElementLocated = By.id("first-name");

    public void checkout(String firstNamee, String lastNamee, String postalCodee) throws InterruptedException{
        visibilityOfElementLocated(visibilityOfElementLocated);
        firstName.sendKeys(firstNamee);
        lastName.sendKeys(lastNamee);
        postalCode.sendKeys(postalCodee);
        continueBtn.click();
    }

}
