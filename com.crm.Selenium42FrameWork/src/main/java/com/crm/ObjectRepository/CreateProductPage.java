package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage
{
	//Initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement proAddbtn;
	
	@FindBy(name = "productname")
	private WebElement proTextfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement proSavebtn;
	
	@FindBy (xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement DelProduct;

	

	//Getters method
	public WebElement getProAddbtn() {
		return proAddbtn;
	}

	public WebElement getProTextfield() {
		return proTextfield;
	}

	public WebElement getProSavebtn() {
		return proSavebtn;
	}
	
	public WebElement getDelProduct() {
		return DelProduct;
	}
	
	
	//Business logic
	
	public void ProductAddbtn()
	{
		proAddbtn.click();
	}
	
	public void ProductTextfield(String data)
	{
		proTextfield.sendKeys(data);
	}
	
	public void ProductSavebtn()
	{
		proSavebtn.click();
	}
	public void DeleteProduct()
	{
		DelProduct.click();
	}
}
