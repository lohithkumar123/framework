package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	//initializaton
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy (xpath="//img[@title='Create Organization...']")
	private WebElement Orgbtn;
	
	@FindBy (name="accountname")
	private WebElement OrgTextfield;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;

	//getters method
	public WebElement getOrgbtn() {
		return Orgbtn;
	}

	public WebElement getOrgTextfield() {
		return OrgTextfield;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}
	
	//Business logic
	
	public void OrganizationAddbtn()
	{
		Orgbtn.click();
	}
	
	public void OrganizationTextfield(String data )
	{
		OrgTextfield.sendKeys(data);
	}
	
	public void OrganizationSavebtn()
	{
		Savebtn.click();
	}
	
	
}
