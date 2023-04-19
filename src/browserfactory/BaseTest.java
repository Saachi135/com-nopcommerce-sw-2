package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    // assign variable to web-driver
    public static WebDriver driver;
    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        // assign base url
        driver.get(baseUrl);
    }
    public void closeBrowser() {
        driver.quit();
    }
}

