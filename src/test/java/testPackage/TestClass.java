package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void test (){
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        System.out.println("Test method executed");
        driver.navigate();
        String s = ("https://www.google.com/");
        driver.get(s);
    driver.quit();
    }
}
