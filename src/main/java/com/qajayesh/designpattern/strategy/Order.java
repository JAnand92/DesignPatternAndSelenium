package com.qajayesh.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Order extends AbstractComponent{

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "orderNumber")
    private WebElement orderNumber;

    public Order(WebDriver driver) {
        super(driver);
    }

    public Order clickBuyNow() {
        this.buyNow.click();
        return this;
    }

    public String getOrderNumber() {
        this.wait.until((d) -> orderNumber.isDisplayed());
        var orderNum = this.orderNumber.getText();
        System.out.println(
                "Order Number : " + orderNum
        );
        return orderNum;
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> buyNow.isDisplayed());
    }
}
