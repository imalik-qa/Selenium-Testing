import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) {
        //where to find the driver
        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");

        //products to search for
        String [] productList = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};

        //driver object
        WebDriver driver = new ChromeDriver();

        //explicit exception to wait for modal button
        WebDriverWait w = new WebDriverWait(driver, 5);

        test(driver, w, productList);

    }

    public static void test(WebDriver driver, WebDriverWait w, String[] productList) {

        //Resize current window to the set dimension
        driver.manage().window().maximize();

        //navigate to url
        driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");

        //enter username
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

        //enter password
        driver.findElement(By.name("password")).sendKeys("learning");

        //click user radio button
        driver.findElement(By.xpath("//input[@value='user']")).click();

        //explicit wait for modal to show
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        //click ok to close modal
        driver.findElement(By.id("okayBtn")).click();

        //select Consultant option from dropdown
        Select drpTitle = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
        drpTitle.selectByValue("consult");

        //agree to terms and conditions
        driver.findElement(By.id("terms")).click();

        //click signin Button
        driver.findElement(By.name("signin")).click();

        //wait explicitly unitl protocommerce home is displayed
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//a[contains(text(),'ProtoCommerce Home')]")));

        //create a list to hold all products
        List<WebElement> products = driver.findElements(By.cssSelector(".card-title a"));

        //add listed items to card
        for(int i = 0; i < products.size(); i++)
        {
            List<String> list = Arrays.asList(productList);
            if(list.contains(products.get(i).getText()))
            {
                driver.findElements(By.className("btn-info")).get(i).click();
            }
        }

        //click on checkout button
        driver.findElement(By.className("btn-primary")).click();
    }
}
