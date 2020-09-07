package com.qajayesh.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInformation extends AbstractComponent{

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public UserInformation(WebDriver driver) {
        super(driver);
    }

    public UserInformation enterFirstName(String fName) {
        this.firstName.sendKeys(fName);
        return this;
    }

    public UserInformation enterLastName(String lName) {
        this.lastName.sendKeys(lName);
        return this;
    }

    public UserInformation enterEmailAddress(String eAddress) {
        this.email.sendKeys(eAddress);
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> firstName.isDisplayed());
    }
}
