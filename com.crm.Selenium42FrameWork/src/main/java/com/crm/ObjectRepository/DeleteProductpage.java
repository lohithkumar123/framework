package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductpage
{
	//Initialization
	public DeleteProductpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy (xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement DelProduct;
	
	//Getter method
	public WebElement getDeleteProduct() {
		return DelProduct;
	}
	
	//Business logic
	public void DeleteProduct()
	{
		DelProduct.click();
	}
}
