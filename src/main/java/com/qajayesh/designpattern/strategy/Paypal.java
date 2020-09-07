package com.qajayesh.designpattern.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class Paypal implements PaymentOption {

    @FindBy(id = "paypal_username")
    private WebElement userName;

    @FindBy(id = "paypal_password")
    private WebElement password;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.userName.sendKeys(paymentDetails.get("userName"));
        this.password.sendKeys(paymentDetails.get("password"));
    }
}
