package com.qajayesh.designpattern.test.srp;

import com.qajayesh.designpattern.srp.main.GoogleMainPage;
import com.qajayesh.designpattern.srp.result.GoogleResultPage;
import com.qajayesh.designpattern.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeClass
    public void initialisePages() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }


    @Test(dataProvider = "getData")
    public void googleWorkflow(String keyword, int index) {
      /*  String keyword = "Selenium";
        int index = 3;*/

        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();

        System.out.println(
                googleResultPage.getResultStat().getStat()
        );
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {"selenium", 3},
                {"docker", 2}
        };
    }
}
