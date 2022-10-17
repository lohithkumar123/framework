package com.crm.Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility 
{
	public void waitForPageLoad(WebDriver driver)
	
	/**
	 * used for page to load before identifying any synchronized element in DOM
	 * @author Lohith 
	 */
	{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * after every action it will wait for next action to perform
	 * @author Lohith
	 */
	
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
	}
	
	/**
	 * used to wait for the element to be clickable in GUI and check for specific element for every 500 milliseconds
	 * @author Lohith
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element, int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param PartialWindowTitle
	 * author Lohith
	 */
	
	public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
			{
				String wid = it.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains(PartialWindowTitle))
				{
					break;
				}
			}
	}
	
	/**
	 * used to switch to Alert window and Accept(click on ok button)
	 * @param driver
	 */
	
	public void switchToAlertWinidowandAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to switch to Alert window and Dismiss(click on Cancle button)
	 * @param driver
	 * author Lohith
	 */
	public void switchToAlertWindowandDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch frame window based on index
	 * @param driver
	 * @param index
	 * author Lohith
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to switch frame window based on id or name attribute
	 * @param driver
	 * @param id_name_Attribute
	 * author Lohith
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * used to select the value from the dropdown based on index
	 * @param driver
	 * @param index
	 * author Lohith
	 */
	public void select(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropdown based on text
	 * @param driver
	 * @param value
	 * author Lohith
	 */
	
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	
	/**
	 * used to move perform mouse hover action
	 * @param driver
	 * @param element
	 * author Lohith
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();	
	}
	
	/**
	 * used to move perform right click on element
	 * @param element
	 * author Lohith
	 */
	
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * used to move perform right click on element
	 * @param driver
	 * @param element
	 * author Lohith
	 */
	public void doubleClickonElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * used to performmove by offset to the element
	 * @param driver
	 * @param x
	 * @param y
	 * author Lohith
	 */
	public void moveByOffset(WebDriver driver, int x, int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	
	
	
	
}

