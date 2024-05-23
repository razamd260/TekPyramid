package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public WebDriver launchbrowser(String value,WebDriver driver) {
		switch(value) {
			case "chrome" :driver=new ChromeDriver();
			break;
			case "edge" :driver=new EdgeDriver();
			break;
			case "firfox" : driver=new FirefoxDriver();
			break;
			default : System.out.println("Sorry use Correct supportable Browser");
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	
      
	public void implicitwait(WebDriver driver,long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void ElementToBeClickable(WebDriver d,WebElement element){
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void visiblitiof(WebDriver d,WebElement element){
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnUrlwithcondition(WebDriver driver,String partialTitle) {
		Set<String> url=driver.getWindowHandles();
		for(String s:url) {
			String actTitle=driver.getTitle();
			if(actTitle.equals(partialTitle)) {
				driver.switchTo().window(s);
			}
			
		}
	}
	
	public void switchToFrame(WebDriver d ,int index)
	{
		d.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver d ,String nameID)
	{
		d.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver d ,WebElement element)
	{
		d.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver d)
	{
		d.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver d)
	{
		d.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String name)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(name);
	}
	public void select(WebElement element,int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectbyvalue(WebElement element,String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	 public void moveMouseOnElement(WebDriver d,WebElement element)
		{
			Actions a = new Actions(d);
			a.moveToElement(element).perform();
		}
	 public void doubleClick(WebDriver d,WebElement element)
		{
			Actions a = new Actions(d);
			a.doubleClick().perform();
		}
	 
	 public void ContextClick(WebDriver d,WebElement element)
		{
			Actions a = new Actions(d);
			a.contextClick().perform();
		}
	 
	 public void dargAnddrop(WebDriver d,WebElement drag,WebElement drop)
		{
			Actions a = new Actions(d);
			a.dragAndDrop(drag, drop).perform();
		}
	
	 
}
