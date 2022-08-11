import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class InterActions {
    public static void main(String[] args) {
        //set location of chrome driver
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        //create new webdriver object
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //navigate to url
        driver.get("https://www.google.com");

        Actions a = new Actions(driver);

        a.moveToElement(driver.findElement(By.name("q"))).keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
    }
}
