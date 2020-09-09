package com.qajayesh.designpattern.test.executeAround;

import com.qajayesh.designpattern.executeAround.FrameA;
import com.qajayesh.designpattern.executeAround.FrameB;
import com.qajayesh.designpattern.executeAround.MainPage;
import com.qajayesh.designpattern.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeClass
    public void initialisePages() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest1() {
        this.mainPage
                .goTo()
                .getFrameA()
                .setFirstName("JA");
        this.mainPage
                .getFrameB()
                .setFirstName("BA");
    }

    @Test
    public void frameTest2() {
        this.mainPage.goTo();
        FrameA a = this.mainPage.getFrameA();
        FrameB b = this.mainPage.getFrameB();

        a.setFirstName("JA");
        b.setFirstName("BA");
    }


    @Test
    public void frameTest3() {
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> a.setFirstName("JA"));
        this.mainPage.onFrameB(b -> b.setFirstName("BA"));
        this.mainPage.onFrameA(c -> c.setFirstName("CA"));
    }

    @Test
    public void frameTest4() {
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> {
            a.setFirstName("A");
            a.setLastName("B");
        });
        this.mainPage.onFrameB(b -> b.setFirstName("BA"));
        this.mainPage.onFrameA(c -> c.setFirstName("CA"));
    }

}
