package com.qajayesh.designpattern.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToasterAlertsNotifications extends AbstractComponent{

    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement errorAlert;

    public ToasterAlertsNotifications(WebDriver driver) {
        super(driver);
    }

    public WebElement getInfoAlert() {
        return infoAlert;
    }

    public WebElement getSuccessAlert() {
        return successAlert;
    }

    public WebElement getWarningAlert() {
        return warningAlert;
    }

    public WebElement getErrorAlert() {
        return errorAlert;
    }
}
