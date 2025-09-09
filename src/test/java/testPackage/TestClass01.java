package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestClass01 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testElementPresenceAndClick() {
        driver.navigate().to("https://duckduckgo.com/");

        By logoSelector = By.xpath("(//im" +
                "g)[2]");
        WebElement imgLogo = wait.until(ExpectedConditions.presenceOfElementLocated(logoSelector));
        String actualResult = driver.getTitle();
        System.out.println(actualResult);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualResult.contains("Google"), "Title does not containm 'Google'");
        softAssert.assertAll();


        if (imgLogo.isDisplayed()) {
            imgLogo.click();
            System.out.println("The logo has been pressed.");
        } else {
            System.out.println("The item is present but not visible.");
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}