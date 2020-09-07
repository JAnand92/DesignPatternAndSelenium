package com.qajayesh.designpattern.strategy.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromotionalOffers extends AbstractComponent {

    @FindBy(xpath = "//select[contains(@id, 'EnterCode')]")
    private WebElement enterCode;

    public PromotionalOffers(WebDriver driver) {
        super(driver);
    }

    public void enterPromotionalCode(String promoCode) {
        this.enterCode.sendKeys(promoCode);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.enterCode.isDisplayed());
    }
}
