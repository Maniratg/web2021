package org.datadriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {
	WebDriver driver;
	public void browseLaunch (String url) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(url);
}

	
}

