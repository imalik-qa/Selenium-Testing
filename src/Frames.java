import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
    public static void main(String[] args) {
        //set system location of driver
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        //create new driver object
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //navigate to url
        driver.get("https://jqueryui.com/droppable/");

        //switch to frame within window
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        //store source and destination of drag drop
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions a = new Actions(driver);

        //drag and drop element
        a.dragAndDrop(source, target).build().perform();
    }
}
