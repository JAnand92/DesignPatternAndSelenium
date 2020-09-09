package com.qajayesh.designpattern.test.command;

import com.qajayesh.designpattern.command.HomePage;
import com.qajayesh.designpattern.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void goTo() {
        this.homePage.goTO();
    }

    @Test(dependsOnMethods = "goTo")
    public void homePageTest() {
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));

        /*Another way*/
       /* for (ElementValidator ev : this.homePage.getElementValidators()) {
            boolean result = ev.validate();
            Assert.assertTrue(result);
        }*/
    }

    /*document.querySelector('div.card-body div:nth-child(2)*/

    /*@DataProvider
    public Object[] getData() {
        return this.homePage.getElementValidators()
                .toArray();
    }*/
}
