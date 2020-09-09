package com.qajayesh.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleES extends GoogleEnglish {

    @FindBy(css = "div#SIvCob a")
    private WebElement language;

    public GoogleES(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.es");
        this.language.click();
    }
}
