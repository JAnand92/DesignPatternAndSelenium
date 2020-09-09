package com.qajayesh.designpattern.executeAround;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FrameA {

    @FindBy(name = "fn")
    private WebElement firstName;

    @FindBy(name = "ln")
    private WebElement lastName;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(id = "area")
    private WebElement message;

    public FrameA setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public FrameA setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FrameA setAddress(String address) {
        this.address.sendKeys(address);
        return this;
    }

    public FrameA setMessage(String message) {
        this.message.sendKeys(message);
        return this;
    }
}
