package com.mnewtours;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewtoursTest {
    public WebDriver WebDriver;
    @Before
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver = new ChromeDriver();
    }

    @Test
    public void test1() {
        WebDriver.get("http://newtours.demoaut.com");

        WebElement element = WebDriver.findElement(By.xpath("//input[@type = 'text'][@name = 'userName']"));
        element.sendKeys("test1");

        element = WebDriver.findElement(By.xpath("//input[@type = 'password'][@name = 'password']"));
        element.sendKeys("test1");

        element = WebDriver.findElement(By.xpath("//input[@type = 'image'][@name = 'login']"));
        element.click();

        MatcherAssert.assertThat("Ощибка перехода на FLIGHT FINDER", WebDriver.getTitle().contains("Find a Flight"));

        element = WebDriver.findElement(By.xpath("//input[@type = 'radio'][@value= 'oneway']"));
        element.click();

        element = WebDriver.findElement(By.xpath("//select[@name='passCount']"));
        Select select = new Select(element);
        select.selectByValue("2");

        element = WebDriver.findElement(By.xpath("//select[@name='fromPort']"));
        select = new Select(element);
        select.selectByValue("Paris");

        element = WebDriver.findElement(By.xpath("//select[@name='fromMonth']"));
        select = new Select(element);
        select.selectByValue("11");

        element = WebDriver.findElement(By.xpath("//select[@name='fromDay']"));
        select = new Select(element);
        select.selectByValue("20");

        element = WebDriver.findElement(By.xpath("//select[@name='toPort']"));
        select = new Select(element);
        select.selectByValue("Seattle");

        element = WebDriver.findElement(By.xpath("//select[@name='toMonth']"));
        select = new Select(element);
        select.selectByValue("12");

        element = WebDriver.findElement(By.xpath("//select[@name='toDay']"));
        select = new Select(element);
        select.selectByValue("19");

        element = WebDriver.findElement(By.xpath("//input[@type = 'radio'][@value='Business']"));
        element.click();

        element = WebDriver.findElement(By.xpath("//select[@name='airline']"));
        select = new Select(element);
        select.selectByVisibleText("Pangea Airlines");

        element = WebDriver.findElement(By.xpath("//input[@name='findFlights']"));
        element.click();

        MatcherAssert.assertThat("Ошибка перехода на Select a Flight", WebDriver.getTitle().contains("Select a Flight"));

        element = WebDriver.findElement(By.xpath("(//td[@class='title']//font[contains(.,'/')])[1]"));
        String s= element.getText();
        MatcherAssert.assertThat("Неверная дата", element.getText().contains("11/20/2018"));


        element = WebDriver.findElement(By.xpath("//input[@name='outFlight'][contains(@value,'Unified Airlines')]"));
        element.click();

        element = WebDriver.findElement(By.xpath("(//td[@class='title']//font[contains(.,'/')])[2]"));
        MatcherAssert.assertThat("Неверная дата", element.getText().contains("12/19/2018"));


        element = WebDriver.findElement(By.xpath("//input[@name='inFlight'][contains(@value,'Blue Skies Airlines$631')]"));
        element.click();

        element = WebDriver.findElement(By.xpath("//input[@name='reserveFlights']"));
        element.click();


    }

    @After
    public void closeWebDriver() {
        //WebDriver.close();
    }

}
