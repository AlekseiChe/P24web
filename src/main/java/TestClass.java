import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleksei on 19.08.2016.
 */
public class TestClass {
public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void getDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void login () {
        driver.get("https://www.privat24.ua/#login");
        driver.findElement(By.cssSelector("[name='login']")).clear();
        driver.findElement(By.cssSelector("[name='login']")).sendKeys("+380664441122");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("zzz000");
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }

    @Test
    public void testP24() {
        driver.findElement(By.cssSelector("[data-id='statements']")).click();
    }

    @Test
    public void Exit() {
        driver.findElement(By.cssSelector("[data-name='exitButton']")).click();
    }









    
}
