package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithMultipleSetofData {
	
	static WebDriver driver;
	
	@Test(dataProvider ="credentials")
	public void verifyLoginCredentials(String senerio, String user_name, String password) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		
		WebElement Username = driver.findElement(By.id("username"));
		// Check UserName Box is Visible and Click
		if(Username.isDisplayed() && Username.isEnabled()){
		Username.sendKeys(user_name);
		}
		WebElement Password = driver.findElement(By.id("password"));
		// Check Password Box is Visible and Click 
		if( Password.isDisplayed() && Password.isEnabled()) {
		Password.sendKeys(password);
		}
		WebElement log_in = driver.findElement(By.id("log-in"));
		//click on login button
		if(log_in.isDisplayed() && log_in.isEnabled()) {
			log_in.click();
		}
		Thread.sleep(1000);
		
			if(senerio.equals("bothcorrect")) {
				WebElement account = driver.findElement(By.xpath("//div[@id='logged-user-name']"));
				String expt_msg = "John Doe";
				String actual_msg = account.getText();
				
				//Check Point
				Assert.assertTrue(expt_msg.equals(actual_msg));
				System.out.println("LogIn is Succesful");
			}
			else if(senerio.equals("onlyGmail")) {
				
				WebElement errorMessage =driver.findElement(By.xpath("//div[text()='Password must be present']"));
				String expt_msg = "Password must be present";
				String actual_msg = errorMessage.getText();
				
				//check point 				
				Assert.assertTrue(expt_msg.equals(actual_msg));
				System.out.println("Password must be present");
			}
			else if(senerio.equals("OnlyPassword")) {
				
				WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Username must be present']"));
				String expt_msg = "Username must be present";
				String actual_msg = errorMessage.getText();

				//check point
				Assert.assertTrue(expt_msg.equals(actual_msg));
				System.out.println("Username must be present");
			
			}
			else if(senerio.equals("withOutAnyCredentials")) {
				
				WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Both Username and Password must be present ']"));
				String expt_msg = "Both Username and Password must be present";
				String actual_msg = errorMessage.getText();

				//check point
				Assert.assertTrue(expt_msg.equals(actual_msg));
				System.out.println("Both Username and Password must be present");
			
			}
		  		
			driver.quit();
				
	}
	
	
	//different Test case of login page 
	
	@DataProvider(name="credentials")
	public Object[][]getData(){
		return new Object[][] {
			{"bothcorrect","vistpawan376@gmail.com","password"},
			{"onlyGmail","vistpawan376@gmail.com",""},
			{"OnlyPassword","","password"},
			{"withOutAnyCredentials","",""}
		};
	}
	
	@Test
	public void verifyLoginWithEnterKey() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		
		driver.findElement(By.id("username")).sendKeys("username");
		WebElement login = driver.findElement(By.id("password"));
		login.sendKeys("password");
		login.sendKeys(Keys.ENTER);
		System.out.println("Login By Enter Key");
		driver.quit();
		
}
	
	
	
	
	
	

}
