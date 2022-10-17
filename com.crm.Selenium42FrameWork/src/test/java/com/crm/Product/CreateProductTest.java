package com.crm.Product;

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
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass
{
	@Test(groups = {"regressionTest"})
	public void createProductTest() throws Throwable
	{
		File_Utility flib=new File_Utility();
		Java_Utililty jlib=new Java_Utililty();
		Excel_utility elib=new Excel_utility();
		Webdriver_Utility wlib=new Webdriver_Utility();
		
		
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\softwares\\chromedriver.exe");
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
		
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.ProductAddbtn();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
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
		String data = cel.getStringCellValue()+num;
		*/
		
		cpp.ProductTextfield(data);
		//driver.findElement(By.name("productname")).sendKeys(data);
		cpp.ProductSavebtn();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		if (actdata.contains(data))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}
		//Actions act=new Actions(driver);
		
		WebElement ele = hpage.getAdmlink();
		wlib.moveToElement(driver, ele);
		//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//act.moveToElement(ele).perform();
		
		//wlib.moveToElement(driver, ele);
		hpage.signout();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}
