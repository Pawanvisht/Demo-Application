package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig() {
//		ExtentManager.setExtent();
//		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: "+ driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
//			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
//			driver.set(new InternetExplorerDriver());
		}
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
//		getDriver().manage().timeouts().implicitlyWait
//		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		//PageLoad TimeOuts
//		getDriver().manage().timeouts().pageLoadTimeout
//		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

	private static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
//		ExtentManager.endReport();
	}

}
