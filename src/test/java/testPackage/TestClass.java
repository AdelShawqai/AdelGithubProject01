package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class TestClass {
    @Test
    public void test (){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        System.out.println(driver);
        System.out.println("Test method executed");
        String Gtitle = driver.getTitle();
        System.out.println(Gtitle);
        driver.get("https://www.facebook.com");
        String Ftitle = driver.getTitle();
        System.out.println(Ftitle);
        driver.navigate().back();
        String GGtitle = driver.getTitle();
        System.out.println(GGtitle);


    driver.quit();
    }
}
