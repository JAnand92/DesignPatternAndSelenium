package com.qajayesh.designpattern.executeAround;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class MainPage {

    private final WebDriver driver;

    private FrameA frameA;
    private FrameB frameB;
    private FrameC frameC;

    @FindBy(id = "a")
    private WebElement a;

    @FindBy(id = "b")
    private WebElement b;

    @FindBy(id = "c")
    private WebElement c;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.frameA = PageFactory.initElements(driver, FrameA.class);
        this.frameB = PageFactory.initElements(driver, FrameB.class);
        this.frameC = PageFactory.initElements(driver, FrameC.class);
    }

    public MainPage goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
        return this;
    }


    /*One way of implementation*/
    public FrameA getFrameA() {
        this.driver.switchTo().defaultContent();
        this.driver.switchTo().frame(a);
        return frameA;
    }
    public FrameB getFrameB() {
        this.driver.switchTo().defaultContent();
        this.driver.switchTo().frame(b);
        return frameB;
    }

    /*Another way of implementation*/
    public void onFrameA(Consumer<FrameA> consumer) {
        this.driver.switchTo().frame(a);
        consumer.accept(this.frameA);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameB(Consumer<FrameB> consumer) {
        this.driver.switchTo().frame(b);
        consumer.accept(this.frameB);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameC(Consumer<FrameC> consumer) {
        this.driver.switchTo().frame(a);
        consumer.accept(this.frameC);
        this.driver.switchTo().defaultContent();
    }


}
