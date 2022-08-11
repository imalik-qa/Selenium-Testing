import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class SeleniumStreams {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        /*
        * Step 1: Click on column to sort names
        * Step 2: capture all web elements into list
        * Step 3: get text of all web elements into new list -> original list
        * Step 4: sort the list from previous list -> sorted list
        * Step 5: compare original list to sorted list to verify it was sorted
        */

        //Step 1:
        WebElement nameCol = driver.findElement(By.xpath("//th[contains(@aria-label, 'Veg/fruit name')]"));
        nameCol.click();

        //Step 2:
        List<WebElement> namesList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        //Step 3:
        List<String> namesOriginal = namesList.stream().map(WebElement::getText).toList();

        //Step 4:
        List<String> namesSorted = namesOriginal.stream().sorted().toList();

        //Step 5:
        Assert.assertEquals(namesOriginal, namesSorted);

        driver.quit();
    }
}
