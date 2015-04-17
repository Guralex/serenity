package com.epam.tests.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Set;

public class SearchPage extends WebDriverPage {

    WebDriverWait wait;
    WebDriver driver;

    public SearchPage(WebDriverProvider driverProvider) {
        super(driverProvider);
        wait = new WebDriverWait(driverProvider.get(), 30);
        PageFactory.initElements(driverProvider.get(), this);
      
    }

    public void open() {
        get("http://www.yahoo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-submit")));

    }

    public void typeSearchParameters(String searchParameters) {
        findElement(By.id("p_13838465-p")).sendKeys(searchParameters);
    }

    public void clickSearchButton() {
    	  
          findElement(By.id("search-submit")).click();
       
    }
    
    public void clickFLink() {
    	
    	
    	
        findElement(By.xpath(".//*[@id='web']/ol/li[1]/div/div[1]/h3/a/b/b")).click();
        
           }
    

    public boolean verifySearchResults() {
        try {
            findElement(By.xpath("//*[@id='left']/ol/li/div/div/span")).isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }

    public boolean verifyEmptySearchMessage() {
        try {
            findElement(By
                .xpath("//p[contains(., 'We did not find results for:')]")).isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }
    
    public boolean verifyFirstLink() {
       
    	
    	try {
        	    findElement(By
                .xpath("//title[contains(., 'Google')]")).isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }
    
    
}
