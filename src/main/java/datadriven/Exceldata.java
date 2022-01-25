package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//How to read a excel what are that are in the excel that are printed in the console.these is only for one data 
public class Exceldata {
	public static void main(String[] args) throws IOException {
		//create a object for file
		File f= new File("C:\\Users\\Hp\\eclipse-workspace\\datadriven\\excel\\mani1.xlsx");
		//to read a data
		FileInputStream stream = new FileInputStream(f);
		//to create object for workbook
		Workbook w= new XSSFWorkbook(stream);
		//to get sheet from the sheet
		Sheet sheet = w.getSheet("sheet1");
		//to get row from the sheet
		Row row = sheet.getRow(0);
		//to get the cell from row
		Cell cell = row.getCell(0);
		//to get the data from the cell
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
	
	}

}
