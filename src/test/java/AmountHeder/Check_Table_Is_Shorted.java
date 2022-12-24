package AmountHeder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import WebElementDemo.webElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_Table_Is_Shorted {
	static WebDriver driver ;
	@Test
	public void verifyLogin() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		
		driver.findElement(By.id("username")).sendKeys("vistpawan376@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pawan123");
		driver.findElement(By.id("log-in")).click();
		Thread.sleep(1000);

		
	}
	
//	Check Description is Sorted
	@Test(dependsOnMethods= {"verifyLogin"})
	public void sorted_Description() {
		ArrayList<String> obtainedList = new ArrayList<>(); 
		List<WebElement> elementList= driver.findElements(By.xpath("//*[@id=\"transactionsTable\"]/tbody/tr/td[3]"));
		for(WebElement we:elementList){
		   obtainedList.add(we.getText());
		   
		}
		Collections.sort(obtainedList);
		
//		Click on Description Header
		driver.findElement(By.id("description")).click();
		
		List<String> tempList = new ArrayList<>();
		List<WebElement> sortedList= driver.findElements(By.xpath("//*[@id=\"transactionsTable\"]/tbody/tr/td[3]"));
		for(WebElement se:sortedList){
			tempList.add(se.getText());		   
		
		}
				
		System.out.println(obtainedList);
		
        System.out.println(tempList);
		
		
		Assert.assertTrue(tempList.equals(obtainedList));
		
		}
	
	//Check Amount is Sorted
	@Test(dependsOnMethods= {"verifyLogin"})
	public void sorted_Amount() {
		ArrayList<String> obtainedList = new ArrayList<>(); 
		List<WebElement> elementList= driver.findElements(By.xpath("//*[@id=\"transactionsTable\"]/tbody/tr/td[5]/span"));
		for(WebElement we:elementList){
		   obtainedList.add(we.getText());
		   
		}
		Collections.sort(obtainedList);
		
//		Click on Amount Header
		driver.findElement(By.id("amount")).click();
		
		List<String> tempList = new ArrayList<>();
		List<WebElement> sortedList= driver.findElements(By.xpath("//*[@id=\"transactionsTable\"]/tbody/tr/td[5]"));
		for(WebElement se:sortedList){
			tempList.add(se.getText());		   
		
		}
		System.out.println(obtainedList);
        System.out.println(tempList);
		
		
		Assert.assertTrue(tempList.equals(obtainedList));
		
		}
	
	

	
	@Test(dependsOnMethods= {"verifyLogin","sorted_Amount"})
	public void closeWindow(){
		driver.quit();
		
	}
		
	}
		


