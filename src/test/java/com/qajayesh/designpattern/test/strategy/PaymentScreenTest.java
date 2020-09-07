package com.qajayesh.designpattern.test.strategy;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qajayesh.designpattern.strategy.*;
import com.qajayesh.designpattern.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeClass
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        this.paymentScreen
                .goTo()
                .getUserInformation()
                .enterFirstName("Jay")
                .enterLastName("Ana")
                .enterEmailAddress("test@test.com");

        this.paymentScreen
                .setPaymentOption(PaymentOptionFactory.get(option))
                .pay(paymentDetails)
                .getOrder()
                .clickBuyNow()
                .getOrderNumber();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "1231231231");
        cc.put("year", "2023");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "1231231231");
        nb.put("pin", "123");

        return new Object[][] {
                {"CC", cc},
                {"NB", nb}
        };
    }
}
