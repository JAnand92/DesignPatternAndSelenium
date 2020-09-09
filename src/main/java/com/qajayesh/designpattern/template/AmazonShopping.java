package com.qajayesh.designpattern.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonShopping implements ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = "input.nav-input")
    private WebElement searchBtn;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    @FindBy(id = "dp")
    private WebElement price;


    public AmazonShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }


    @Override
    public void launchSite() {
        this.driver.get("https://www.amazon.com");
    }

    @Override
    public void searchForProduct() {
        for (char ch : this.product.toCharArray()) {
            this.searchBox.sendKeys(ch + "");
        }
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();

    }

    @Override
    public void buy() {
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println(
                this.price.getText()
        );

    }
}
