import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        SoftAssert sa = new SoftAssert();

        driver.manage().window().maximize();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> footerLinks = driver.findElements(By.cssSelector("#gf-BIG a"));

        for (WebElement footerLink : footerLinks) {
            //get link url
            String currentUrl = footerLink.getAttribute("href");

            //define the url to connect to
            URL url = new URL(currentUrl);

            //open connection to url and connect
           HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setRequestMethod("GET");
            urlcon.connect();

            //get response code
            int responseCode = urlcon.getResponseCode();
            System.out.println(responseCode);

            sa.assertTrue(responseCode < 400, "The link " + currentUrl + " is a broken link");

        }

        sa.assertAll();
        driver.quit();
    }
}
