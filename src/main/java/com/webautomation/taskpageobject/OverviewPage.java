package com.webautomation.taskpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class OverviewPage extends AbstractComponent{
    WebDriver driver;

    public OverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="finish")
    WebElement finishBtn;

    By rowButton = By.id("finish");

    @FindBy(className="inventory_item_name")
    WebElement productNamed;

    public boolean verifyProductt(String productNamee){
        visibilityOfElementLocated(rowButton);
        Boolean match = productNamed.getText().contains(productNamee);
        return match;
    }
    public void LastStep() {
        visibilityOfElementLocated(rowButton);
        finishBtn.click();
    }
}   

