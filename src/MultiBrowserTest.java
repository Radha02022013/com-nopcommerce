import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button
 * 15. Close the browser.
 */

public class MultiBrowserTest {

    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    //Main method
    public static void main(String[] args) {
        //if else setup multi  browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //Open the URL
        driver.get(baseUrl);
        //We give Implicit wait for driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //print the title of the page
        System.out.println(driver.getTitle());
        //Print the current Url
        System.out.println("The Current Url: " + driver.getCurrentUrl());
        //Print the page source
        System.out.println(driver.getPageSource());
        //Navigate to Url
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        //Print the current url
        System.out.println("The Current Url: " + driver.getCurrentUrl());
        //Navigate Back to home page
        driver.navigate().back();
        //Navigate Back to Login Page
        driver.navigate().forward();
        //Print the current Url
        System.out.println("The current URl : " + driver.getCurrentUrl());
        //Refresh the page
        driver.navigate().refresh();
        //Enter the email field
        driver.findElement(By.id("Email")).sendKeys("Prime123@gmail.com");
        //Enter the password to password field
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        //Click on the Login Button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        //Close the browser
        driver.quit();

    }
}




