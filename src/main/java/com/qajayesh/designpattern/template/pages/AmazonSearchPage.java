package com.qajayesh.designpattern.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = "input.nav-input")
    private WebElement searchBtn;


    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTO() {
        this.driver.get("https://www.amazon.com");
    }

    public void search(String product) {
        for (char ch : product.toCharArray()) {
            this.searchBox.sendKeys(ch + "");
        }
        this.searchBtn.click();
    }
}
