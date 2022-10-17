package com.crm.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utililty;
import com.crm.Generic_Utilities.Webdriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass

{
	//@Test(retryAnalyzer = com.crm.Generic_Utilities.RetryAnalyzer.class)
	@Test(groups = {"smokeTest"})
	public void createOrganizationTest() throws Throwable 
	{
		
		File_Utility flib=new File_Utility();
		Java_Utililty jlib=new Java_Utililty();
		Excel_utility elib=new Excel_utility();
		Webdriver_Utility wlib=new Webdriver_Utility();
		
		
		
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		*/
		
		wlib.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
	
		/*FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String url=pro.getProperty("url");
		String un=pro.getProperty("un");
		String pwd = pro.getProperty("pwd");*/
		
		
		//driver.findElement(By.name("user_name")).sendKeys(username);
		//driver.findElement(By.name("user_password")).sendKeys(password);
		//driver.findElement(By.id("submitButton")).click();
		
		HomePage hpage=new HomePage(driver);
		hpage.organization();
		//driver.findElement(By.xpath("//a[.='Organizations']")).click();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.OrganizationAddbtn();
		
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		int num = jlib.getRanDomNum();
		
		/*Random ran=new Random();
		int num = ran.nextInt(100);*/
		
		String data = elib.getDatafromExcel("Organization", 0, 0)+num;
		
		
		/*FileInputStream fis2=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sh = book.getSheet("Organization");
		Row row = sh.getRow(0);
		Cell cel = row .getCell(0);
		String data = cel.getStringCellValue()+num;*/
		
		orgPage.OrganizationTextfield(data);
		//driver.findElement(By.name("accountname")).sendKeys(data);
		
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals("A", "B");
		
		orgPage.OrganizationSavebtn();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Thread.sleep(2000);
		
		ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
		validate.organizationValidation(driver, data);
		/*String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		
		if (actdata.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		*/
		
		//WebElement ele = hpage.getAdmlink();
		//wlib.moveToElement(driver, ele);
		//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		//Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		//wlib.moveToElement(driver, ele);
		
		//Assert.assertEquals(true, false);
		//hpage.signout();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//soft.assertAll();
	}
	@Test
	public void modifyOrg()
	{
		System.out.println("modified");
		System.out.println("modified second time");
	}
}
