package com.qajayesh.designpattern.test.template;

import com.qajayesh.designpattern.template.AmazonShoppingRefactoring;
import com.qajayesh.designpattern.template.ShoppingTemplate;
import com.qajayesh.designpattern.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                new AmazonShoppingRefactoring(driver, "Iphone"),
               /* new EbayShopping(driver, "Iphone")*/
        };
    }
}
