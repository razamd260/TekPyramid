package com.comcast.crm.baseutility1;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.ObejectRepo.LoginPage;

import com.comcast.crm.createcontactobjectrepository.HomePage;
import com.comcast.crm.fileutility.ExcelUtility;
import com.comcast.crm.fileutility.FileUtility;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.javautility.JavaUtility;



public class Baseclass {

	public JavaUtility java = new JavaUtility();
	public WebDriverUtility web = new WebDriverUtility();
	public DatabaseUtility db = new DatabaseUtility();
	public ExcelUtility excel = new ExcelUtility();
	public FileUtility file = new FileUtility();
	public WebDriver driver;
	public LoginPage login;
	public HomePage home;

	@BeforeSuite
	public void configBS() throws Exception {
		System.out.println("Connect to db");
		db.getDBConnection();

	}

	@BeforeClass
	public void configBC() throws Exception {
		System.out.println("Connect to browser");
		String BROWSER = file.getDataFromProperties("browser");
		WebDriver rdriver=web.launchbrowser(BROWSER, driver);
	    driver=rdriver;
		

	}

	@BeforeMethod
	public void configBM() throws Exception {
//		driver.manage().window().maximize();
//		web.implicitwait(driver,Long.parseLong(file.getDataFromProperties("time")));
		String URL = file.getDataFromProperties("url");
		System.out.println(URL);
		driver.get(URL);
		login = new LoginPage(driver);
		login.getUsernameedt().sendKeys(file.getDataFromProperties("user"));
		login.getpasswordEdt().sendKeys(file.getDataFromProperties("pass"));
		login.getloginBtn().click();

	}
	
	@AfterMethod
	public void configAM()
	{
		
	   home=new HomePage(driver);
       web.moveMouseOnElement(driver,home.getAdminImg());
       home.getSignOutLnk().click();
	}
	
	@AfterClass
	public void configAC()
	{
	System.out.println("Close the browser");
	driver.quit();
	}
	
	@AfterSuite
	public void configAS() throws Exception {
		System.out.println("close db connection");
		db.closeDbConnection();
	}

	
	


	
}
