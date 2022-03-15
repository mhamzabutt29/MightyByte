package com.example.MightyByte.Browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Browser {
    Logger logger = LoggerFactory.getLogger(Browser.class);

    private WebDriver driver;
    private String browser;
    private String url;

    public String getBrowser() {return browser;}
    public void setBrowser(String browser){this.browser=browser;}

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setDriver() {
        logger.info("Selected Browser: " + browser);
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\com\\example\\MightyByte\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
            this.driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver(){return driver;}



    public String closeDriver(){
        try{
        this.driver.close();
        this.driver.quit();
        } catch (NullPointerException e){
            e.getStackTrace();
            return e.toString();
        }
        return "Driver closed and quit";
    }

    public void openUrl(){

        this.driver.get(this.getUrl());
    }
}
