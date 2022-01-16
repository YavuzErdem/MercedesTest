package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.Map;

public class MercedesTest {
    @Test
    public void testWithoutMethod() throws InterruptedException {

        //driver set-up (must be handled in before method in TestBase later
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mercedes-benz.co.uk/passengercars.html?group=all&subgroup=all.BODYTYPE.hatchback&view=BODYTYPE");
        Thread.sleep(1000);

        //locate the parent of first shadow-root element
        WebElement shadow_host = driver.findElement(By.cssSelector("cmm-cookie-banner:nth-of-type(1)"));

        //the next 5 lines can be turned into a method later
        Object shadowRoot = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host);
        String id = (String) ((Map<String, Object>) shadowRoot).get("shadow-6066-11e4-a52e-4f735466cecf");
        RemoteWebElement shadowRootElement = new RemoteWebElement();
        shadowRootElement.setParent((RemoteWebDriver) driver);
        shadowRootElement.setId(id);

        //locate agree all button
        WebElement agreeAllBtn = shadowRootElement.findElement(By.cssSelector("button[type='button']:nth-of-type(2)"));
        Thread.sleep(1000);
        agreeAllBtn.click();

        //locate the parent of second shadow-root element
        WebElement shadow_host2 = driver.findElement(By.cssSelector("owc-header.webcomponent"));
        //the next 5 lines can be turned into a method later
        Object shadowRoot2 = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host2);
        String id2 = (String) ((Map<String, Object>) shadowRoot2).get("shadow-6066-11e4-a52e-4f735466cecf");
        RemoteWebElement shadowRootElement2 = new RemoteWebElement();
        shadowRootElement2.setParent((RemoteWebDriver) driver);
        shadowRootElement2.setId(id2);

        //locate ourCars button
        WebElement ourCars = shadowRootElement2.findElement(By.cssSelector("button.owc-header-navigation-topic__button"));
        Thread.sleep(1000);
        ourCars.click();

        //locate hatcback button (ourCars and hatchback buttons are under the same shadow root element)
        WebElement hatchback = shadowRootElement2.findElement(By.cssSelector("li:nth-of-type(4) a"));
        Thread.sleep(1000);
        hatchback.click();

        WebElement shadow_host3 = driver.findElement(By.cssSelector("dh-io-vmos#first-web-component > div"));

        Object shadowRoot3 = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host3);
        String id3 = (String) ((Map<String, Object>) shadowRoot3).get("shadow-6066-11e4-a52e-4f735466cecf");
        RemoteWebElement shadowRootElement3 = new RemoteWebElement();
        shadowRootElement3.setParent((RemoteWebDriver) driver);
        shadowRootElement3.setId(id3);

        WebElement carImage = shadowRootElement3.findElement(By.cssSelector("img.dh-io-vmos_2p2ii.dh-io-vmos_1qzBt "));
        new Actions(driver).moveToElement(carImage).pause(300).build().perform();




        WebElement buildCar = shadowRootElement3.findElement(By.cssSelector("a.dh-io-vmos_3HxTq.undefined"));
        Thread.sleep(1000);
        buildCar.click();


        WebElement shadow_host4 = driver.findElement(By.cssSelector("owcc-car-configurator"));

        Object shadowRoot4 = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host4);
        String id4 = (String) ((Map<String, Object>) shadowRoot4).get("shadow-6066-11e4-a52e-4f735466cecf");
        RemoteWebElement shadowRootElement4 = new RemoteWebElement();
        shadowRootElement4.setParent((RemoteWebDriver) driver);
        shadowRootElement4.setId(id4);


        WebElement DieselTickButton = shadowRootElement4.findElement(By.cssSelector("wb-icon.hydrated"));
        Thread.sleep(1000);
        DieselTickButton.click();


    }
    }

