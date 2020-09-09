package com.qajayesh.designpattern.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DismissalAlerts extends AbstractComponent{

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert.info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert.success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert.danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert.warning")
    private WebElement dismissWarningAlert;


    public DismissalAlerts(WebDriver driver) {
        super(driver);
    }

    public WebElement getDismissInfoAlert() {
        return dismissInfoAlert;
    }

    public WebElement getDismissSuccessAlert() {
        return dismissSuccessAlert;
    }

    public WebElement getDismissWarningAlert() {
        return dismissWarningAlert;
    }

    public WebElement getDismissDangerAlert() {
        return dismissDangerAlert;
    }
}
