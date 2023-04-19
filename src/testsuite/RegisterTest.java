package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("http://demo.nopcommerce.com/");
    }

    @Test

    public void UserShouldNavigateToRegisterPageSuccessfully() {
        // find register link and click
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        // verify the register text
        String expectedMessage = "Register";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Register not displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // click on Register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        //select gender ratio button
        driver.findElement(By.id("gender-female"));
        //Enter first name
        driver.findElement(By.id("FirstName")).sendKeys("Gaurang");
        //Enter last name
        driver.findElement(By.name("LastName")).sendKeys("Panch");
        //Enter email address
        driver.findElement(By.id("Email")).sendKeys("gptesting@gmail.com");
        //Enter password
        driver.findElement(By.name("Password")).sendKeys("abc1234");
        //Enter confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("abc1234");
        // click register button
        driver.findElement(By.id("register-button")).click();
        //Verify display test
        String expectedMessage = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.className("result"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Your registration completed not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
