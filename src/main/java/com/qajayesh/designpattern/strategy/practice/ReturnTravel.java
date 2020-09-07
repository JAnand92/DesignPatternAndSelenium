package com.qajayesh.designpattern.strategy.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ReturnTravel implements SearchOption {

    @FindBy(xpath = "//span[contains(@id, 'Return')]")
    private WebElement returnOpt;

    @FindBy(xpath = "//input[contains(@id, 'From-suggest')]")
    private WebElement departure;

    @FindBy(xpath = "//input[contains(@id, 'To-suggest')]")
    private WebElement arrival;

    @FindBy(xpath = "//span[contains(@id, 'Oneway')]")
    private WebElement oneWayOpt;

    @FindBy(id = "M")
    private WebElement advanceSearchOpt;

    @Override
    public void enterSearchOption(Map<String, String> searchDetails) {
        boolean flag = this.returnOpt.isSelected();
        if(flag) {
            this.departure.sendKeys(searchDetails.get("departure"));
            this.arrival.sendKeys(searchDetails.get("arrival"));
        }
    }
}
