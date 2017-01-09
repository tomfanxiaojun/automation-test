package com.epam.cnta.webdriver.demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GitHubSimpleDemo {

    public static void main(String[] args) {
    	
        //initialize WebDriver for Firefox (Firefox driver)
    	WebDriver driver = new FirefoxDriver();
        
        //Open web page for moving through demo steps
        driver.get("https://github.com/");
        
        //Maximize browser window 
        driver.manage().window().maximize();
        
        //Find the "button" input element by link text
        driver.findElement(By.linkText("Sign in")).click();
        
        //Find the text input element by "id" attribute with a certain value and type the user name there
        driver.findElement(By.id("login_field")).sendKeys("testautomationuser");
        
        //Find the text input element by xpath expression and type the password there
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Time4Death!");
     
        //Now submit the form. WebDriver will find the form for us from the element
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        
        //Print out the title of the last opened page
        System.out.println("Page title is: " + driver.getTitle());

        //Close all browser windows and terminate WebDriver
        driver.quit();
    }
}