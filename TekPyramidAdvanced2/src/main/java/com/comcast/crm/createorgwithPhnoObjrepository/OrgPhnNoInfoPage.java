package com.comcast.crm.createorgwithPhnoObjrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPhnNoInfoPage {

	WebDriver driver;
	public OrgPhnNoInfoPage(WebDriver driver)
	{
	this.driver= driver;
	PageFactory.initElements(driver,this);
	}
    

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderInfo;
	
	
	@FindBy(xpath="//td[@id='mouseArea_Phone']")
	private WebElement phnCheckInfo;
	
	
	public WebElement getPhnCheckInfo() {
		return phnCheckInfo;
	}


	public WebElement getOrgHeaderInfo() {
		return orgHeaderInfo;
	}
	
	
	

}
