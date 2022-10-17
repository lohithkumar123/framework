package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy (xpath="//a[.='Organizations']")
	private WebElement orglink;
	
	@FindBy (xpath="//a[.='Products']")
	private WebElement prodlink;
	
	@FindBy (xpath="//a[.='More']")
	private WebElement morelink;

	@FindBy (xpath="//a[.='Campaigns']")
	private WebElement camplink;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admlink;
	
	@FindBy (xpath="//a[.='Sign Out']")
	private WebElement signoutlink;
	
	//Getters
		
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getProdlink() {
		return prodlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCamplink() {
		return camplink;
	}

	public WebElement getAdmlink() {
		return admlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	//Business logic
	public void organization()
	{
		orglink.click();
	}
	
	public void products()
	{
		prodlink.click();
	}
	
	public void more()
	{
		morelink.click();
	}
	
	public void campaign()
	{
		camplink.click();
	}
	
	public void signout()
	{
		signoutlink.click();
	}
}