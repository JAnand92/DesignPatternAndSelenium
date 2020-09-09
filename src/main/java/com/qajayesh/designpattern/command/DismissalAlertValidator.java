package com.qajayesh.designpattern.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {

    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement element) {
        this.dismissalAlert = element;
    }

    @Override
    public boolean validate() {
        boolean appearanceState = this.dismissalAlert.isDisplayed(); //true
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean disappearanceState = this.dismissalAlert.isDisplayed(); //false
        return appearanceState && (!disappearanceState);
    }
}
