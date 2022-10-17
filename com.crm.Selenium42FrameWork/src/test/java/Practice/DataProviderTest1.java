package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1
{
	@Test (dataProvider="dataprovider_test")
	public void ContactDetails(String First_name,String Department, String Email) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys(First_name);
		driver.findElement(By.id("department")).sendKeys(Department);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.quit();
		Thread.sleep(2000);
	}
	
		@DataProvider
		public Object[][] dataprovider_test()
		{
			Object[][] objarr=new Object[3][3];
			
			objarr[0][0]="A1";
			objarr[0][1]="HR";
			objarr[0][2]="abc@gmail.com";
			
			objarr[1][0]="B1";
			objarr[1][1]="FINANCE";
			objarr[01][2]="finance@gmail.com";
			
			objarr[2][0]="c1";
			objarr[2][1]="TRAINING";
			objarr[2][2]="trainers@gmail.com";
			
			return objarr;
			
		}	
	}