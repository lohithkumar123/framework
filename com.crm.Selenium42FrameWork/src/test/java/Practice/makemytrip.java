package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class makemytrip {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\acer\\\\Desktop\\\\softwares\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./makemytrip_properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		
		driver.get(url);
		driver.findElement(By.id("fromCity")).click();

		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5']")).click();


		
		/*FileInputStream fis1=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("From");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String data = cel.getStringCellValue();*/
		
		String srccity = "Bengaluru, India";
		
		WebElement src = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		src.sendKeys("'"+srccity+"'");
		//driver.findElement(By.xpath("//p[text()='"+srccity+"']")).click();
		
		
		
		//driver.findElement(By.xpath("//span[.='To']")).click();
		
		
		/*FileInputStream fis2=new FileInputStream("./Book1.xlsx");
		Workbook book1 = WorkbookFactory.create(fis2);
		Sheet sh1 = book1.getSheet("To");
		Row row1 = sh1.getRow(0);
		Cell cel1 = row1.getCell(0);
		String data1 = cel1.getStringCellValue();
		
		driver.findElement(By.name("react-autosuggest__input react-autosuggest__input--open")).sendKeys(data1);
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();*/
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
