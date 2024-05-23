package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	WebDriver driver;

	public OrganisationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgImg;

	public WebElement getCreateNewOrgImg() {
		return createNewOrgImg;
	}
	
	

}
