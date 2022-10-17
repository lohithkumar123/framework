package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{
	//Initialization
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Campbtn;
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement CampTextfield;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;

	//Getters methods
	public WebElement getCampbtn() {
		return Campbtn;
	}

	public WebElement getCampTextfield() {
		return CampTextfield;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}
	
	//Business logic
	
	public void CampaignAddbtn()
	{
		Campbtn.click();
	}
	
	public void CampaignTextfield(String data)
	{
		CampTextfield.sendKeys(data);
	}
	
	public void CampaignSavebtn()
	{
		Savebtn.click();
	}
	
	
	
	
}
