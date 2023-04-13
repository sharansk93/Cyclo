package com.Cyclo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;

	public void browserlaunch(String def) {
		if(def.equals("chrome")) {			
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-mazimized");
		driver=new ChromeDriver(options);
			}
	}
	
	public void click(WebElement e) {
		e.click();
		
	}
	
	public void sendkeys(WebElement e,String s) {
		e.sendKeys(s);
	}
	
}
