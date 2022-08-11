import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //navigate to url
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //get table element
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
        List<WebElement> tableCols = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));

        System.out.println("Table Rows: " + tableRows.size());
        System.out.println("Table Columns: " + tableCols.size());

        System.out.println("Second Row Content: " + tableRows.get(2).getText());

        driver.quit();
    }
}
