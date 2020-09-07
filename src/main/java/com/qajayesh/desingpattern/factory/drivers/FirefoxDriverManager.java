package com.qajayesh.desingpattern.factory.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {

    private GeckoDriverService geService;

    @Override
    protected void startService() {
        if(null == geService) {
            try {
                geService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("resources/geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                geService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void stopService() {
        if(null != geService && geService.isRunning()) {
            geService.stop();
            geService = null;
        }

    }

    @Override
    protected void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver(options);
    }
}
