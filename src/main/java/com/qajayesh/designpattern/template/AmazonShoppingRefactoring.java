package com.qajayesh.designpattern.template;

import com.qajayesh.designpattern.template.pages.AmazonProductDescriptionPage;
import com.qajayesh.designpattern.template.pages.AmazonResultPage;
import com.qajayesh.designpattern.template.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShoppingRefactoring implements ShoppingTemplate {

    private WebDriver driver;
    private String product;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultPage amazonResultPage;
    private AmazonProductDescriptionPage amazonProductDescriptionPage;

    public AmazonShoppingRefactoring(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultPage = PageFactory.initElements(driver, AmazonResultPage.class);
        this.amazonProductDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);
        PageFactory.initElements(driver, this);

    }

    @Override
    public void launchSite() {
       this.amazonSearchPage.goTO();
    }

    @Override
    public void searchForProduct() {
       this.amazonSearchPage.search(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonResultPage.selectProduct();

    }

    @Override
    public void buy() {
       this.amazonProductDescriptionPage.buy();
    }
}
