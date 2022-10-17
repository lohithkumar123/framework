package com.crm.Campaign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utililty;
import com.crm.Generic_Utilities.Webdriver_Utility;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass
{
	@Test(groups = {"smokeTest","regressionTest"})
	public  void createCampaignTest() throws Throwable
	
	{
		File_Utility flib=new File_Utility();
		Java_Utililty jlib=new Java_Utililty();
		Excel_utility elib=new Excel_utility();
		Webdriver_Utility wlib=new Webdriver_Utility();
		
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\acer\\\\Desktop\\\\softwares\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();*/
		/*String BROWSER = flib.getpropertyKeyValue1("browser");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
		wlib.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*
		String url = flib.getpropertyKeyValue1("url");
		String username = flib.getpropertyKeyValue1("un");
		String password = flib.getpropertyKeyValue1("pwd");
		*/
	
		/*FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		String un = pro.getProperty("un");
		String pwd = pro.getProperty("pwd");*/
		/*
		driver.get(url);
		
		LoginPage log=new LoginPage(driver);
		log.login(username, password);*/
		//driver.findElement(By.name("user_name")).sendKeys(username);
		//driver.findElement(By.name("user_password")).sendKeys(password);
		//driver.findElement(By.id("submitButton")).click();
		
		HomePage hpage=new HomePage(driver);
		WebElement ele = hpage.getMorelink();
		wlib.moveToElement(driver, ele);
		
		//WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		//wlib.moveToElement(driver, ele);
		
		//Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		
		hpage.campaign();
		//driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		
		CampaignPage cPage=new CampaignPage(driver);
		cPage.CampaignAddbtn();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		int num = jlib.getRanDomNum();
		
		/*Random ran=new Random();
		int num = ran.nextInt(100);*/
		
		String data = elib.getDatafromExcel("Campaign", 0, 0)+num;
		
		/*FileInputStream fis1=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Campaign");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String data = cel.getStringCellValue()+num;*/
		
		cPage.CampaignTextfield(data);
		//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(data);
		
		cPage.CampaignSavebtn();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		WebElement ele1 = hpage.getAdmlink();
		wlib.moveToElement(driver, ele1);
		//WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wlib.moveToElement(driver, ele1);
		
		//act.moveToElement(ele1).perform();
		
		hpage.signout();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
	}

}
