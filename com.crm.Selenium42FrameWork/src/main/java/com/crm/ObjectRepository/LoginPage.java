package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement usernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	
	//Getter methods
	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
	/*
	 * business logic
	 * this method is used to login to the app
	 * @author Lohith
	 */
	public void login(String username, String password)
	{
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		submitButton.click();
	}
	
}
	

	