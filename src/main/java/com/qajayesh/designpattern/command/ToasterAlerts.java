package com.qajayesh.designpattern.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToasterAlerts extends AbstractComponent{

    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div-button.box button.btn-warning")
    private WebElement warnBtn;

    @FindBy(css = "div-button.box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div-button.box button.btn-danger")
    private WebElement dangerBtn;

    public ToasterAlerts(WebDriver driver) {
        super(driver);
    }

    public WebElement getInfoBtn() {
        return infoBtn;
    }

    public WebElement getSuccessBtn() {
        return successBtn;
    }

    public WebElement getWarnBtn() {
        return warnBtn;
    }

    public WebElement getDangerBtn() {
        return dangerBtn;
    }
}
