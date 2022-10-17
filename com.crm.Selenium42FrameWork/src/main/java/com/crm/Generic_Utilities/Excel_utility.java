package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility 
{
	/**
	 * this method is used to get the data from excel
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * author Lohith
	 */
	public String getDatafromExcel(String sheetName, int RowNum, int cellNum) throws Throwable
	{
		FileInputStream fis2=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(0);
		Cell cel = row .getCell(0);
		String data = cel.getStringCellValue();
		return data;
	}
}
