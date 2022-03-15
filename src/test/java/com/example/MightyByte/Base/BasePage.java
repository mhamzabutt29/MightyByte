package com.example.MightyByte.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    protected WebDriverWait wait;
    public BasePage(){
    }
    public void setWait(WebDriver driver){wait = new WebDriverWait(driver, 30);}
    public WebDriverWait getWait(){return wait;}
}
