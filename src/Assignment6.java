import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment6 {
    public static void main(String[] args) {
        //driver location system property
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        //driver object
        WebDriver driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        //navigate to url
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //option 2 WebElement
        String option = driver.findElement(By.cssSelector("#checkbox-example label:nth-child(3)")).getText().trim();

        System.out.println(option);

        //check option 2 checkbox
        driver.findElement(By.xpath("//input[@value='" + option.toLowerCase() +"']")).click();

        //dropdown element
        Select dropDwn = new Select(driver.findElement(By.name("dropdown-class-example")));

        //select the defined
        dropDwn.selectByVisibleText(option);

        //alert input enter text
        driver.findElement(By.id("name")).sendKeys(option);

        //click alert button
        driver.findElement(By.id("alertbtn")).click();

        //alert object
        Alert alert = driver.switchTo().alert();

        //get alert msg
        String msg = alert.getText();

        //close the alert
        alert.accept();

        //verify selected option text is in alert text
        System.out.println(msg.contains(option));

        //close out everything
        driver.quit();
    }
}
