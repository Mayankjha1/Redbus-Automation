package Mac;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Rebus_Search_Automate {
    @Test
    public void Search_Functionality(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        // Use Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(1));

        // Action Class
        Actions Action_Class = new Actions(driver);
        // Opening Chrome and maximize
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();

        // Wait for the Website to load
       // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class=\"srcDest___1cb25f\"])[1]")));

        // Automate From
        WebElement From_box =wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"label___ef3ba6 \"])[1]")));
        Action_Class.moveToElement(From_box).click()
                .pause(Duration.ofMillis(500))
                .sendKeys("Patna")
                .pause(Duration.ofMillis(2000))
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        // Automate To
        WebElement To_box =wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"label___ef3ba6 \"])[1]")));
        Action_Class.moveToElement(To_box).click()
                .pause(Duration.ofMillis(500))
                .sendKeys("Delhi")
                .pause(Duration.ofMillis(2000))
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        // Select Date
        WebElement Date_Box = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"dateInputWrapper___37e8cc\"]")));
        Action_Class.moveToElement(Date_Box).click().build().perform();

        // selecting Date
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button' and @aria-label='Wednesday, July 30, 2025']")));
        date.click();

        // Click on Search
        WebElement Search_Box = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Search buses']")));
        Action_Class.moveToElement(Search_Box).click().build().perform();

        // Print how many buses are found

        WebElement Found_Buses = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"busesFoundText__ind-search-styles-module-scss-PHVGD\"]")));
        //Action_Class.moveToElement(Found).click().build().perform();

        //Print the Found buses
        System.out.println("Found Busus : " + Found_Buses.getText());


        // Print all the Bus Name with Price

        // Bus List with price
        // Wait for presence of all elements (not just one clickable)
        List<WebElement> Bus_Names = wait10.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='busTitleWrap___5722f1']")));
        List<WebElement> Bus_Price = wait10.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"tupleFareItemWrapper___32f567 tupleFare___8e1538\"]")));

        System.out.println("Total Bus Size : " + Bus_Names.size());
        for (int i = 0; i < Bus_Names.size(); i++) {
            String Bus_Name_List = Bus_Names.get(i).getText();
            String Bus_Price_List = Bus_Price.get(i).getText();
            System.out.println("Bus Name " + (i + 1) + ": " + Bus_Name_List + " | Price: " + Bus_Price_List );
        }

        // Close the Driver
        driver.quit();


    }
}
