package org.datadriven;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;





public class Base{
	
	
	WebDriver driver;
	public void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
	}
	
	public WebElement elementLocator(String LocatorType,String Value) {
	if(LocatorType.equals("id")) {
		WebElement findElement = driver.findElement(By.id(Value));
		return findElement;
		
	}
	else if (LocatorType.equals("name")) {
		WebElement findElement = driver.findElement(By.name(Value));
		return findElement;
	}
	else {
		WebElement findElement = driver.findElement(By.xpath(Value));
		return findElement;	
	}
	}
	public void enterText(WebElement element,String text) {
		element.sendKeys(text);
	
	}
	public String enterRead(String path,String Sheet1,int rowno,int cellno) throws IOException {
		File f = new File("C:\\Users\\Hp\\eclipse-workspace\\datadriven\\excel\\mani1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w= new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(Sheet1);
		Row row=sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int cellType = cell.getCellType();
		if (cellType==1) {
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat a= new SimpleDateFormat("mm/dd/yyyy");
			String format = a.format(dateCellValue);
			return format;	
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l=(long) numericCellValue;
			String valueOf = String.valueOf(1);
			return valueOf;
		}
	}
	public void excelwrite(String path,String Sheet1,int rowno,int cellno,String value) throws IOException {
			File f = new File("C:\\Users\\Hp\\eclipse-workspace\\datadriven\\excel\\mani1.xlsx");
			Workbook w= new XSSFWorkbook();
			Sheet createSheet = w.createSheet(Sheet1);
			Row createRow = createSheet.createRow(rowno);
			Cell createCell = createRow.createCell(cellno);
			createCell.setCellValue(value);
			FileOutputStream stream =new FileOutputStream(f);
			w.write(stream);
			
			
	}
	
	
	
	
	
	
	
	
}

