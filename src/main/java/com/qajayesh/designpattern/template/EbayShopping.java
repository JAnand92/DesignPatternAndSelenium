package com.qajayesh.designpattern.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayShopping implements ShoppingTemplate {


    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    public EbayShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {

    }

    @Override
    public void searchForProduct() {

    }

    @Override
    public void selectProduct() {

    }

    @Override
    public void buy() {

    }
}
