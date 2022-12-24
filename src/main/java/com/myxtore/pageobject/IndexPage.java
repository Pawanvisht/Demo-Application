package com.myxtore.pageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
	WebElement serchBox;
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
	WebElement serchbtn;
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
	WebElement login;
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
	WebElement registration;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	public LoginPage clickOnSigIn() throws Throwable{
		Action.click(driver, login);
		return new LoginPage();
	}
	
	
	
}
