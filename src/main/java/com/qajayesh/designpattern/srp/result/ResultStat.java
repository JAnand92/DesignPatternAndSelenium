package com.qajayesh.designpattern.srp.result;

import com.qajayesh.designpattern.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "resultStats")
    private WebElement stats;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return this.stats.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.stats.isDisplayed());
    }
}
