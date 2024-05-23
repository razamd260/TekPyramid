package com.comcast.crm.createcontactobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.javautility.JavaUtility;

public class CreateContactWithSupportDate {
	WebDriver driver;

	public CreateContactWithSupportDate(WebDriver d) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactLastNameEdt;

	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement supportStartDateEdt;

	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement supportEndDateEdt;

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}

	public void contactWithDate() throws InterruptedException {
		JavaUtility java = new JavaUtility();
	
		supportStartDateEdt.clear();
		String startDate = java.getSystemDate();
		supportStartDateEdt.sendKeys(startDate);
		supportEndDateEdt.clear();
		String reqDate = java.getRequiredDate(30);
		supportEndDateEdt.sendKeys(reqDate);
	}

}
