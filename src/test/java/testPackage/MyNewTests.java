package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class MyNewTests {
    private WebDriver driver;

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo.com</a>]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void myTestTask1() {
        driver.get("https://duckduckgo.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch!");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo.com</a>]
     * Assert that the DuckDuckGo logo is displayed
     * Close Google Chrome
     */
    @Test
    public void myTestTask2() {
        driver.get("https://duckduckgo.com/");

        By logoSelector = By.xpath("//div[contains(@class,'Desktop')]//img");

        boolean isLogoDisplayed = driver.findElement(logoSelector).isDisplayed();

        Assert.assertTrue(isLogoDisplayed, "DuckDuckGo logo is not displayed!");
    }

    @Test(dependsOnMethods = "myTestTask2")
    public void test1() {
        System.out.println("Test1 is running");

    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        System.out.println("Test2 is running");
    }

    @Test(dependsOnMethods = {"test2", "test1", "myTestTask2"})
    public void test3() {
        System.out.println("Test3 is running");
    }

    @Test
    public void checkPageTitleIsAsExpected() {
        driver.get("https://www.selenium.dev/");

        By headerLocator = By.tagName("h1");
        String actualHeader = driver.findElement(headerLocator).getText();
        String expectedHeader = "Selenium automates browsers. That's it!";

        Assert.assertEquals(actualHeader, expectedHeader, "Header text mismatch!");
    }

    @Test
    public void myTestTask3() {
        driver.navigate().to("https://www.selenium.dev/");
        By headerSelector = By.xpath("//h1[@class='d-1 fw-bold']");
        boolean isHeaderDisplayed = driver.findElement(headerSelector).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "Selenium automates browsers. is display!");
    }

    @Test
    public void myTestTask4() {
        driver.navigate().to("https://www.selenium.dev/");
        By SecondHeaderSelector = By.xpath("//p[contains(@class,'normal')]");
        System.out.println(driver.findElement(SecondHeaderSelector).getText());
        System.out.println(SecondHeaderSelector);
        String actualHeader = driver.findElement(SecondHeaderSelector).getText();
        String expectedHeader = "What you do with that power is entirely up to you.";
        Assert.assertEquals(actualHeader, expectedHeader, "Header text mismatch!");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://www.selenium.dev/">selenium.dev</a>]
     * Assert that the page third title is [Getting Started]
     */
    @Test
    public void myTestTask5() {
        driver.navigate().to("https://www.selenium.dev/");
        By ThirdHeaderSelector = By.xpath("//h2[normalize-space()='Getting Started']");
        String actualHeader = driver.findElement(ThirdHeaderSelector).getText();
        String expectedHeader = "Getting Started";
        Assert.assertEquals(actualHeader, expectedHeader, "Header text mismatch!");
    }

    @Test
    public void myTestTask6() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By readOnlyInputLocator = By.xpath("//input[@name='my-readonly']");
        WebElement readOnlyInput = driver.findElement(readOnlyInputLocator);
        String readOnlyValue = readOnlyInput.getDomAttribute("value");
        String expectedValue = "Readonly input";
        Assert.assertEquals(readOnlyValue, expectedValue, "Read-only input value mismatch!");
        System.out.println("Read-only input value: " + readOnlyValue);

    }

    @Test
    public void myTestTask7() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By customListLocator = By.xpath("//input[@name='my-datalist']");
        String expectedValue = "Cobra";
        driver.findElement(customListLocator).sendKeys(expectedValue);
        String actualValue = driver.findElement(customListLocator).getDomProperty("value");

        Assert.assertEquals(actualValue, expectedValue, "Custom list value mismatch!");
        System.out.println("Custom list value: " + actualValue);


    }

    @Test
    public void myTestTask8() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By buttonAppearanceStyle = By.xpath("//button[contains(@class,'primary')]");
        driver.findElement(buttonAppearanceStyle);
        String actualStyle = driver.findElement(buttonAppearanceStyle).getCssValue("appearance");
        String expectedStyle = "button";
        Assert.assertEquals(actualStyle, expectedStyle, "Button appearance style mismatch!");
        System.out.println("Button appearance style: " + actualStyle);
    }

    /**
     * /**
     *  * Open Google Chrome
     *  * Navigate to [<a href="https://www.selenium.dev/selenium/web/web-form.html">selenium Web form</a>]
     *  * fill the form field [Text input] with value [Adel]
     *  * fill the form field [Password] with value [123456]
     *  * fill the form field [Text area] with value [Hello world]
     *  * select the form field [Dropdown (select)] with value [Three]
     *  * send keys to the form field [Dropdown (select)] with value [New York]
     *  * check the form field [Checkbox] with value [Checked]
     *  * Use click action on the button  [submit]
     *  *
     *  *
     *  *
     */

@Test
 public void myTestTask9() {
    driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    By textInputLocator = By.xpath("//input[@name='my-text']");
    By passwordLocator = By.xpath("//input[@name='my-password']");
    By textAreaLocator = By.xpath("//textarea[@name='my-textarea']");
    By dropdownLocator = By.xpath("//select[@name='my-select']");
    By datalistLocator = By.xpath("//input[@name='my-datalist']");
    By checkboxLocator = By.xpath("//input[@name='my-check']");
    By submitButtonLocator = By.xpath("//button[@type='submit']");
    driver.findElement(textInputLocator).sendKeys("Adel");
    driver.findElement(passwordLocator).sendKeys("123456");
    driver.findElement(textAreaLocator).sendKeys("Hello world");
    driver.findElement(dropdownLocator).sendKeys("Three");
    driver.findElement(datalistLocator).sendKeys("New York");
    driver.findElement(checkboxLocator).click();
    driver.findElement(submitButtonLocator).click();
    By messageLocator = By.xpath("//p[@class='lead']");
    String actualMessage = driver.findElement(messageLocator).getText();
    String expectedMessage = "Received!";
    Assert.assertEquals(actualMessage, expectedMessage, "Form submission message mismatch!");
    System.out.println("Form submission message: " + actualMessage);

    }


/**
 * Createing the same myTestTask9 with tap to send keys
 */
    @Test
public void myTestTask10() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By submitButtonLocator = By.xpath("//button[@type='submit']");
        By textInputLocator = By.xpath("//input[@name='my-text']");
        driver.findElement(textInputLocator).sendKeys("Adel",
                "\t",
                "123456",
                "\t",
                "Hello world",
                "\t",
                "Three",
                "\t",
                "New York",
                "\t",
                " ",
                "\t",
                "\n");
        driver.findElement(submitButtonLocator).click();
        By messageLocator = By.xpath("//p[@class='lead']");
        String actualMessage = driver.findElement(messageLocator).getText();
        String expectedMessage = "Received!";
        Assert.assertEquals(actualMessage, expectedMessage, "Form submission message mismatch!");
        System.out.println("Form submission message: " + actualMessage);

    }

    @Test
    public void myTestTask11 () {
        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");
        By revealButtonLocator = By.xpath("//input[@id='reveal']");
        driver.findElement(revealButtonLocator).click();
        By hiddenInputLocator = By.xpath("//input[@id='revealed']");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class);
        wait.until(d -> {
            d.findElement(hiddenInputLocator).sendKeys("You found me!");
            return true;
                });

        String inputValue = driver.findElement(hiddenInputLocator).getDomProperty("value");
        String expectedValue = "You found me!";
        Assert.assertEquals(inputValue, expectedValue, "Hidden input value mismatch!");
        System.out.println("Hidden input value: " + inputValue);

    }


        @BeforeMethod
    public void setUp() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

