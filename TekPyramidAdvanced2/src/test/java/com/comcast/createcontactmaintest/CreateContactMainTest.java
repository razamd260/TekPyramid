package com.comcast.createcontactmaintest;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility1.Baseclass;
import com.comcast.crm.createcontactobjectrepository.ContactInfoPage;
import com.comcast.crm.createcontactobjectrepository.ContactPage;
import com.comcast.crm.createcontactobjectrepository.CreateContactWithSupportDate;
import com.comcast.crm.createcontactobjectrepository.HomePage;

public class CreateContactMainTest extends Baseclass {
	@Test(enabled = false)
	public void createContactTest() throws Exception
	{
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactImg().click();

		String lastName = excel.readDataFromExcel("Sheet1", 4, 1) + java.getRandomNumber();

		cp.getContactLastNameEdt().sendKeys(lastName);

		cp.getContactSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actContactHeaderInfo = cip.getContactHeaderInfo().getText();

		if (actContactHeaderInfo.contains(lastName)) {
			System.out.println(lastName + " is  verified");
		} else {
			System.err.println(lastName + " mismatching");
		}
		
}

	@Test
	public void CreateContactWithSupportDateTest() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactImg().click();
		String lastName = excel.readDataFromExcel("Sheet1", 4, 1) + java.getRandomNumber();
		CreateContactWithSupportDate cwsd = new CreateContactWithSupportDate(driver);
		cp.getContactLastNameEdt().sendKeys(lastName);
		//cwsd.contactWithDate();
		cp.getContactSaveBtn().click();
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actHeaderInfo = cip.getContactHeaderInfo().getText();
		if (actHeaderInfo.contains(lastName)) {
			System.out.println(lastName + " verified successfully");
		} else {
			System.err.println(lastName + " verification failed");
		}
	}

}
