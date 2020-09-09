package com.qajayesh.designpattern.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private ToasterAlerts toasterAlerts;
    private ToasterAlertsNotifications toasterAlertsNotifications;
    private DismissalAlerts dismissalAlerts;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        this.toasterAlerts = PageFactory.initElements(driver, ToasterAlerts.class);
        this.toasterAlertsNotifications = PageFactory.initElements(driver, ToasterAlertsNotifications.class);
        this.dismissalAlerts = PageFactory.initElements(driver, DismissalAlerts.class);
    }

    public void goTO() {
        this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
                new NotificationValidator(toasterAlerts.getInfoBtn(), toasterAlertsNotifications.getInfoAlert()),
                new NotificationValidator(toasterAlerts.getSuccessBtn(), toasterAlertsNotifications.getSuccessAlert()),
                new NotificationValidator(toasterAlerts.getWarnBtn(), toasterAlertsNotifications.getWarningAlert()),
                new NotificationValidator(toasterAlerts.getDangerBtn(), toasterAlertsNotifications.getErrorAlert()),

                new DismissalAlertValidator(dismissalAlerts.getDismissInfoAlert()),
                new DismissalAlertValidator(dismissalAlerts.getDismissSuccessAlert()),
                new DismissalAlertValidator(dismissalAlerts.getDismissWarningAlert()),
                new DismissalAlertValidator(dismissalAlerts.getDismissDangerAlert())

        );
    }

    public ToasterAlerts getToasterAlerts() {
        return toasterAlerts;
    }

    public ToasterAlertsNotifications getToasterAlertsNotifications() {
        return toasterAlertsNotifications;
    }

    public DismissalAlerts getDismissalAlerts() {
        return dismissalAlerts;
    }
}
