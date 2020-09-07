package com.qajayesh.designpattern.test.strategy;

import com.qajayesh.designpattern.strategy.practice.SearchOptionFactory;
import com.qajayesh.designpattern.strategy.practice.SearchScreen;
import com.qajayesh.designpattern.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchScreenTest extends BaseTest {

    private SearchScreen searchScreen;

    @BeforeClass
    public void setSearchScreen() {
        this.searchScreen = new SearchScreen(this.driver);
    }

    @Test
    public void searchTest(Map<String, String> searchDetails, String option) {
        this.searchScreen
                .goTo()
                .setSearchOption(SearchOptionFactory.get(option))
                .enterSearchDetails(searchDetails)
                .getPassengers()
                .enterPassengerDetails(searchDetails);
        this.searchScreen.getPromotionalOffers();
        this.searchScreen.getSearch().clickSearch();

    }
}
