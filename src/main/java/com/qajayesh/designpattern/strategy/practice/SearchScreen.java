package com.qajayesh.designpattern.strategy.practice;

import com.qajayesh.designpattern.strategy.PaymentOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class SearchScreen {

    private WebDriver driver;
    private Login login;
    private SearchOption searchOption;
    private Passengers passengers;
    private PromotionalOffers promotionalOffers;
    private Search search;

    public SearchScreen(final WebDriver driver) {
        this.driver = driver;
        this.login = PageFactory.initElements(driver, Login.class);
        this.passengers = PageFactory.initElements(driver, Passengers.class);
        this.promotionalOffers = PageFactory.initElements(driver, PromotionalOffers.class);
        this.search = PageFactory.initElements(driver, Search.class);
    }


    public SearchScreen goTo() {
        this.driver.get("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");
        return this;
    }

    public Login getLogin() {
        return login;
    }

    public SearchScreen setSearchOption(SearchOption searchOption) {
        this.searchOption = searchOption;
        PageFactory.initElements(driver, PaymentOption.class);
        return this;
    }

    public SearchScreen enterSearchDetails(Map<String, String> searchDetails) {
        this.searchOption.enterSearchOption(searchDetails);
        return this;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public PromotionalOffers getPromotionalOffers() {
        return promotionalOffers;
    }

    public Search getSearch() {
        return search;
    }
}
