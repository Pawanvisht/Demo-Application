package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithActionClass {
	
	static WebDriver driver;

	@Test
	public void verifyLoginWithEnterKey() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		
		driver.findElement(By.id("username")).sendKeys("username");
		WebElement login = driver.findElement(By.id("password"));
		login.sendKeys("password");
		login.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
}
	
	
	
}
