package com.qajayesh.designpattern.test.decorator;

import com.qajayesh.designpattern.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplayed(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //ingredients
    private static final Consumer<DashboardPage> adminComponentPresent =
            (dp) -> shouldDisplay(dp.getAdminComponent());

    private static final Consumer<DashboardPage> adminComponentNotPresent =
            (dp) -> shouldNotDisplayed(dp.getAdminComponent());

    private static final Consumer<DashboardPage> superComponentPresent =
            (dp) -> shouldDisplay(dp.getSuperuserComponent());

    private static final Consumer<DashboardPage> superComponentNotPresent =
            (dp) -> shouldNotDisplayed(dp.getSuperuserComponent());

    private static final Consumer<DashboardPage> guestComponentPresent =
            (dp) -> shouldDisplay(dp.getGuestComponents());

    private static final Consumer<DashboardPage>guestComponentNotPresent =
            (dp) -> shouldNotDisplayed(dp.getGuestComponents());

    //role section
    private static final Consumer<DashboardPage> adminSelection =
            (dp) -> dp.selectRole("admin");

    private static final Consumer<DashboardPage> superSelection =
            (dp) -> dp.selectRole("superuser");

    private static final Consumer<DashboardPage> guestSelection =
            (dp) -> dp.selectRole("guest");

    //user role pages

    public static final Consumer<DashboardPage> guestPage =
            guestSelection.andThen(guestComponentPresent).andThen(superComponentNotPresent)
            .andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> superuserPage =
            superSelection.andThen(guestComponentPresent).andThen(superComponentPresent)
                    .andThen(adminComponentNotPresent);

    public static final Consumer<DashboardPage> adminPage =
            adminSelection.andThen(guestComponentPresent).andThen(superComponentPresent)
                    .andThen(adminComponentPresent);

}
