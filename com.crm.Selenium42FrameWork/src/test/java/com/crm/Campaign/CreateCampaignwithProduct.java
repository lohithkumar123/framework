package com.crm.Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.Generic_Utilities.Excel_utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utililty;
import com.crm.Generic_Utilities.Webdriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProduct
{
	public static void main(String[] args) throws Throwable
	{
		File_Utility flib=new File_Utility();
		Java_Utililty jlib=new Java_Utililty();
		Excel_utility elib=new Excel_utility();
		Webdriver_Utility wlib=new Webdriver_Utility();
		
		String BROWSER = flib.getpropertyKeyValue1("browser");
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
		}
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();*/
		
		wlib.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String url = flib.getpropertyKeyValue1("url");
		String username = flib.getpropertyKeyValue1("un");
		String password = flib.getpropertyKeyValue1("pwd");
		
		
		/*
		FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String url=pro.getProperty("url");
		String un=pro.getProperty("un");
		String pwd = pro.getProperty("pwd");*/
		
		driver.get(url);
		
		LoginPage log=new LoginPage(driver);
		log.login(username, password);
		//driver.findElement(By.name("user_name")).sendKeys(username);
		//driver.findElement(By.name("user_password")).sendKeys(password);
		//driver.findElement(By.id("submitButton")).click();
		
		HomePage hpage=new HomePage(driver);
		hpage.products();
		//driver.findElement(By.xpath("//a[.='Products']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		int num = jlib.getRanDomNum();
		
		/*Random ran=new Random();
		int num = ran.nextInt(100);*/
		
		String data = elib.getDatafromExcel("Products", 0, 0)+num;
		/*
		FileInputStream fis2=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sh = book.getSheet("Products");
		Row row = sh.getRow(0);
		Cell cel = row .getCell(0);
		String data = cel.getStringCellValue()+num;*/
		
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = hpage.getMorelink();
		wlib.moveToElement(driver, ele);
		//WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		
		hpage.campaign();
		//driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		String data1 = elib.getDatafromExcel("Campaign", 0, 0)+num;
		
		/*
		FileInputStream fis3=new FileInputStream("./Book1.xlsx");
		Workbook book1 = WorkbookFactory.create(fis3);
		Sheet sh1 = book1.getSheet("Campaign");
		Row row1 = sh1.getRow(0);
		Cell cel1 = row1.getCell(0);
		String data1 = cel1.getStringCellValue()+num;
		*/
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(data1);
		driver.findElement(By.xpath("(//img[@title='Select'])")).click();
		
		wlib.switchToWindow(driver, "Products&action");
		/*
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext())
		{
			String wind = it.next();
			driver.switchTo().window(wind);
			if(driver.getTitle().contains("Products&action"))
			{
				break;
			}
		}	
		*/
		driver.findElement(By.name("search_text")).sendKeys(data);
		driver.findElement(By.name("search")).click();
		
		//dynamic xpath
		driver.findElement(By.xpath("//a[.='"+data+"']")).click();
		
		wlib.switchToWindow(driver, "Campaign&action");
		/*
		Set<String> allid1 = driver.getWindowHandles();
		Iterator<String> it1 = allid1.iterator();
		while(it1.hasNext())
		{
			String wind1 = it1.next();
			driver.switchTo().window(wind1);
			if(driver.getTitle().contains("Campaign&action"))
		{
			break;
		}
		}
		*/
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

		String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(data1))
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
