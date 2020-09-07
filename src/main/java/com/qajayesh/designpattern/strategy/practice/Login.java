package com.qajayesh.designpattern.strategy.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractComponent {

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
        this.loginBtn.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.loginBtn.isDisplayed());
    }
}
