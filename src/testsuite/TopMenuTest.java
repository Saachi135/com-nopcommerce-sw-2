package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("http://demo.nopcommerce.com/");
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on the ‘Computers’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        //Verify computer text
        String expectedMessage = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Computers not displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //click on electronic tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile' ]//a[text()='Electronics ']")).click();
        //verify the text electronics tab
        String expectedMessage = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Electronics']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Electronics not displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        // click on Apparel tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']")).click();

        // verify Apparel text
        String expectedMessage = "Apparel";

        //find element and store variable
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Apparel not displayed", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //click on digital download tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Digital downloads ')]")).click();
        //verify the text Digital downloads
        String expectedMessage = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Digital downloads not displayed",expectedMessage,actualMessage);

    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        // click on Books Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[starts-with(text(),'Books ')]")).click();
        //verify the text 'Books'
        String expectedMessage = "Books";
        WebElement actualElement=driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Books not displayed",expectedMessage,actualMessage);
    }
@Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //click on Jewelry tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry ')]")).click();
        //verify the test Jewelery
        String expectedMessage = "Jewelry";
        WebElement actualElement=driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Jewelry not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //Click on Gift card Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Gift Cards ')]")).click();
        // verify the text Gift Card
        String expectedMessage = "Gift Cards";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(" Gift Cards not displayed",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

