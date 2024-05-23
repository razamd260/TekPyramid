package com.comcast.ObejectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	@FindBy(name="user_name")
    private WebElement usernameEdt;

    @FindBy(name="user_password")
     private WebElement passwordEdt;

    
    @FindBy(id="submitButton")
     private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameedt() {
		return usernameEdt;
	}
	
	public WebElement getpasswordEdt() {
		return passwordEdt;
	}

	public WebElement getloginBtn() {
		return loginBtn;
	}
	
}
