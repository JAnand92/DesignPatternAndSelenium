package com.qajayesh.desingpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish {

    @FindBy(css = "div#SIvCob a")
    private WebElement language;

    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.goggle.com.sa");
        this.keyboardBtn.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until((d) -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d) -> this.keyboard.isDisplayed());
        super.search(keyword);
    }
}
