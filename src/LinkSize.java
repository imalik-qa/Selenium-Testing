import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkSize {
    public static void main(String[] args) {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.calculator.net/");

        System.out.println(driver.findElements(By.tagName("a")).size());
    }
}
