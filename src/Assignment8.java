import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement searchBar = driver.findElement(By.id("autocomplete"));
        WebElement suggestions = driver.findElement(By.id("ui-id-1"));

        searchBar.click();
        searchBar.sendKeys("Uni");

        wait.until(ExpectedConditions.visibilityOf(suggestions));
        List<WebElement> options = suggestions.findElements(By.tagName("li"));
        String country = "United States (USA)";

        for(WebElement option : options) {
            if(option.getText().equalsIgnoreCase(country))
                option.click();
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
