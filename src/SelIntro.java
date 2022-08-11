import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;


public class SelIntro {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "E://Documents//Selenium Java Course//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //explicit wait object
        WebDriverWait w = new WebDriverWait(driver, 5);

        //implicit wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //array of items to search
        String[] veggies = {"Cucumber", "Brocolli"};

        addToCart(driver, veggies);

        //click on cart icon
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();

        //proceed to checkout page
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        //explicit wait unitl promo text box is displayed
        w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));

        //enter promo code
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");

        //apply promo code
        driver.findElement(By.className("promoBtn")).click();

        //explicit wait for promoInfo class to be visible
        w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));

        //get validation text for promo
        System.out.println(driver.findElement(By.className("promoInfo")).getText());

    }

    //Search for and add items to cart
    public static void addToCart(WebDriver driver, String [] veggies) throws InterruptedException {
        //iterator to keep track of total items to search
        int j = 0;

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            //convert veggies array to list
            List<String> veggiesList = Arrays.asList(veggies);

            if (veggiesList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j == veggies.length)
                    break;
            }
        }
    }
}
