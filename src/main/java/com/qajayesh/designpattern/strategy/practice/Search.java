package com.qajayesh.designpattern.strategy.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends AbstractComponent {

    @FindBy(xpath = "//span[contains(text(), 'Search')]")
    private WebElement searchBtn;

    public Search(WebDriver driver) {
        super(driver);
    }

    public void clickSearch() {
        this.searchBtn.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.searchBtn.isDisplayed());
    }
}
