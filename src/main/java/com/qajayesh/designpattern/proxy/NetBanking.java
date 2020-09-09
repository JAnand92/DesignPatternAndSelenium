package com.qajayesh.designpattern.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentOption {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement accountNum;

    @FindBy(id = "pin")
    private WebElement pin;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        Select bankDropdown = new Select(bank);
        bankDropdown.selectByValue(paymentDetails.get("bank"));
        this.accountNum.sendKeys(paymentDetails.get("account"));
        this.pin.sendKeys(paymentDetails.get("pin"));
    }
}
