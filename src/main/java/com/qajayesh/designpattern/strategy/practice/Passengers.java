package com.qajayesh.designpattern.strategy.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class Passengers extends AbstractComponent {

    @FindBy(xpath = "//select[contains(@id, 'numberAdults')]")
    private WebElement adult;

    @FindBy(xpath = "//select[contains(@id, 'numberChildren')]")
    private WebElement children;

    @FindBy(xpath = "//select[contains(@id, 'numberInfants')]")
    private WebElement infants;


    public Passengers(WebDriver driver) {
        super(driver);
    }

    private void selectNoOfAdults(Map<String, String> passengerDetails) {
        Select adultsDropdown = new Select(this.adult);
        adultsDropdown.selectByValue(passengerDetails.get("Adults"));
    }

    private void selectNoOfChildren(Map<String, String> passengerDetails) {
        Select childrenDropdown = new Select(this.children);
        childrenDropdown.selectByValue(passengerDetails.get("Children"));
    }

    private void selectNoOfInfants(Map<String, String> passengerDetails) {
        Select infantsDropdown = new Select(this.infants);
        infantsDropdown.selectByValue(passengerDetails.get("Infants"));
    }

    public Passengers enterPassengerDetails(Map<String, String> passengerDetails) {
       selectNoOfAdults(passengerDetails);
       selectNoOfChildren(passengerDetails);
       selectNoOfInfants(passengerDetails);
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.adult.isDisplayed());
    }
}
