import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
    public static void main(String[] args) {
        //system property driver location
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        //driver object
        WebDriver driver = new ChromeDriver();

        //maximize screen
        driver.manage().window().maximize();

        //navigate to url
        driver.get("https://the-internet.herokuapp.com/");

        //click on nested frame link
        driver.findElement(By.linkText("Nested Frames")).click();

        //switch to first frame
        driver.switchTo().frame(0);

        //switch to middle frame
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));

        //get text of middle frame
        System.out.println(driver.findElement(By.id("content")).getText());

        //close out everything
        driver.quit();
    }
}
