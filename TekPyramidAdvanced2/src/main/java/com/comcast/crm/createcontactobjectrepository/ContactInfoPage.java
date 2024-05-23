package com.comcast.crm.createcontactobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;

	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactHeaderInfo() {
		return contactHeaderInfo;
	}
	
	

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderInfo;
	
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	public WebElement contactTextChk;

	public WebElement getContactTextChk() {
		return contactTextChk;
	}
	
	
	

}
