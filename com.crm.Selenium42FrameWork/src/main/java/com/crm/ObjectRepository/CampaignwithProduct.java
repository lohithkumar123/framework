package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignwithProduct 
{
	//Initialization
	public CampaignwithProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productAddbtn;
	
	@FindBy(xpath = "productname")
	private WebElement productTextfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement productSavebtn;
	
	
	
	
	
	
	
	
	
	
	
	
}

