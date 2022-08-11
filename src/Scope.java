import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scope {
    public static void main(String[] args) {
        //driver location system property
        System.setProperty("webdriver.chrome.driver", "C:/Dev_Tools/chromedriver_win32/chromedriver.exe");

        //driver object
        WebDriver driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        //implicitly wait for loading
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //navigate to url
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //get number of links on page
        System.out.println("Total links: " + driver.findElements(By.tagName("a")).size());

        //footer driver set to footer element
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

        //find all links in footer element
        int footerLinkSize = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("Footer links: " + footerLinkSize);

        //find all links under 1st footer section
        WebElement firstSectionLinks = footerDriver.findElement(By.cssSelector("table tr td ul"));

        int footerFirstSectionLinkSize = firstSectionLinks.findElements(By.tagName("a")).size();
        System.out.println(footerFirstSectionLinkSize);


        //verify footer fist section element link integrity
        for (int i = 1; i < footerFirstSectionLinkSize; i++) {
            //create keyboard event and store in var
            String openNewTabKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);
            //click on every link
            firstSectionLinks.findElements(By.tagName("a")).get(i).sendKeys(openNewTabKeys);
        }

        //------get links title------//
        //get all open windows
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        //while there is a open window switch and get title
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }


        //close out everything
        driver.quit();
    }
}
