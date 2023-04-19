package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();
        // Verifying text
        String expectedMessage = "Welcome, Please Sign In!";
        // finding element for the display text
        WebElement actualText = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        String actualMessage = actualText.getText();
        //Junit function to compare two variables
        Assert.assertEquals("Displayed Message not matching", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // window to wait till it loads
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        // finding login button element and clicking
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        //finding web element for email field
        driver.findElement(By.id("Email")).sendKeys("gptesting@gmail.com");
        //finding web element for password field
        driver.findElement(By.name("Password")).sendKeys("abc1234");
        // finding element for login button
        driver.findElement(By.xpath("//button[@type='submit' and @class='button-1 login-button']")).click();
        //finding element for log out button
        String expectedLogOutText="Log out";
        WebElement logOutLink=driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualLogOutLinkText=logOutLink.getText();
        Assert.assertEquals("Log out text not displayed",expectedLogOutText,actualLogOutLinkText );


    }

    @Test
    public void verifyTheErrorMessage() {
        //finding login field element
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();
        //finding email field and input data
        driver.findElement(By.id("Email")).sendKeys("gptesting@gmail.com");
        //finding password field and input data
        driver.findElement(By.name("Password")).sendKeys("abcd");
        //finding login button and clicking
        driver.findElement(By.xpath("//button[@type='submit' and @class='button-1 login-button']")).click();
        //finding text display message and comparing actual and expected variables
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualText = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualText.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

