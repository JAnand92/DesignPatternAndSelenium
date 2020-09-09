package com.qajayesh.designpattern.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractComponent {

    protected final WebDriver driver;

    public AbstractComponent(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
