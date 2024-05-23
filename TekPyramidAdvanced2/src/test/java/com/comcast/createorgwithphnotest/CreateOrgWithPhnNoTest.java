package com.comcast.createorgwithphnotest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility1.Baseclass;
import com.comcast.crm.createcontactobjectrepository.HomePage;
import com.comcast.crm.createorgwithPhnoObjrepository.CreateNewOrgWithPhNo;
import com.comcast.crm.createorgwithPhnoObjrepository.OrgPhnNoInfoPage;
import com.comcast.crm.createorgwithdropdownobjectrepository.OrganisationPage;


public class CreateOrgWithPhnNoTest extends Baseclass {
	
	@Test
	public void createOrgWithPhnNoTest() throws Exception
	{
	   
	   HomePage home = new HomePage(driver);
	   home.getOrgLink().click();
	   
	   String orgName=excel.readDataFromExcel("Sheet1", 1, 1)+java.getRandomNumber();
	   
	   OrganisationPage op = new OrganisationPage(driver);
	   op.getCreateNewOrgImg().click();
	   String phnNo = excel.readDataFromExcel("Sheet1", 1, 2);
	 
	   CreateNewOrgWithPhNo cop= new CreateNewOrgWithPhNo(driver);
	   cop.createOrgWithPhn(orgName, "6205860286");
	   cop.getSaveBtn().click();

	   
	  
	   }
	
	
	

}
