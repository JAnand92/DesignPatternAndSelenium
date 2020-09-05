package googleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class GoogleWorkFlowTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
         Path path = Paths.get("resources/chromedriver.exe");
         System.setProperty("webdriver.chrome.driver", path.toString());
         this.driver = new ChromeDriver();
         this.driver.manage().window().maximize();
    }

    @Test
    public void googleTest() {
        this.driver.get("https://www.google.com/");
        this.driver.findElement(By.name("q")).sendKeys("selenium");
        this.driver.findElements(By.cssSelector("li.sbct")).get(1).click();
        this.driver.findElement(By.name("q")).sendKeys("selenium");
        this.driver.findElements(By.cssSelector("li.sbct")).get(1).click();
        this.driver.findElement(By.linkText("News")).click();
        System.out.println(
                this.driver.findElement(By.id("resultStats")).getText()
        );
    }

    @AfterTest
    public void teardown() {
        this.driver.quit();
    }
}
