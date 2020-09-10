package com.qajayesh.designpattern.test.decorator;

import com.qajayesh.designpattern.decorator.DashboardPage;
import com.qajayesh.designpattern.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeClass
    public void setDashboardPage() {
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashboardPage> role) {
        this.dashboardPage.goTo();
        role.accept(this.dashboardPage);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                Decorators.guestPage,
                Decorators.superuserPage,
                Decorators.adminPage
        };
    }
}
