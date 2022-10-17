package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage
{
	public ValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span.dvHeaderText")
	private WebElement actualOrganizationData;

	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}
	
	//Business logic
	public void organizationValidation(WebDriver driver, String data)
	{
		String actData = actualOrganizationData.getText();
		
		if(actData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
}
