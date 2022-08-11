import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        //set location of chrome driver
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        //create new webdriver object
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //navigate to url
        driver.get("https://the-internet.herokuapp.com/");

        //click on multiple windows link
        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();

        //open the new window by clicking link
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

        //get all window ids
        Set<String> windows = driver.getWindowHandles();

        //create iterator to traverse window ids
        Iterator<String> it = windows.iterator();

        //store the first window id as parent window
        String parentWindowId = it.next();

        //store the second window id as child window
        String childWindowId = it.next();

        //switch to child window
        driver.switchTo().window(childWindowId);

        //get text from child window
        String newWinText = driver.findElement(By.tagName("h3")).getText();

        //print text to console
        System.out.println(newWinText);

        //switch to parent window
        driver.switchTo().window(parentWindowId);

        //get text from parent window
        String parentWinText = driver.findElement(By.cssSelector(".example h3")).getText();
        System.out.println(parentWinText);

        //close everything out
        driver.quit();
    }
}
