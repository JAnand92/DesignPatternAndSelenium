package com.qajayesh.designpattern.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    public void enter(String keyword) {
        this.searchBox.clear();
        for (char c: keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(c + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        return this.searchBox.isDisplayed();
       /* return this.wait.until((d) -> this.searchBox.isDisplayed());*/
    }
}
