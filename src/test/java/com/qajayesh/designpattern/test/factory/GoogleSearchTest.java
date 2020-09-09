package com.qajayesh.designpattern.test.factory;

import com.qajayesh.designpattern.test.BaseTest;
import com.qajayesh.designpattern.factory.GoogleFactory;
import com.qajayesh.designpattern.factory.GooglePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        System.out.println(
                "Result Count : " +  this.googlePage.getResultCount()
        );
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {"ENG", "selenium"},
                {"FR", "docker"},
                {"SA", "design pattern"},
                {"ES", "selenium"}
        };
    }

}
