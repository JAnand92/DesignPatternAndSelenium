package com.qajayesh.designpattern.factory.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chService;

    @Override
    protected void startService() {
        if(null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("resources/chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if(chService != null && chService.isRunning()) {
            chService.stop();
        }
    }

    @Override
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
    }
}
