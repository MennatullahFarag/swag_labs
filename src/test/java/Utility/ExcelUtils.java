package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	//full excel file
	public Workbook workbook;
	
	//constructor to load the excel file
	public ExcelUtils(String excelFilePath) throws IOException{
		
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
	}
	
	//method to read login data
	public String[][] getLoginData(String sheetName) throws IOException{
		Sheet sheet = workbook.getSheet(sheetName);
		int totalNumOfRows = sheet.getLastRowNum();
		int totalNumOfColumns = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[totalNumOfRows][totalNumOfColumns];
		
		for(int i=1 ; i<=totalNumOfRows ; i++) { //start from 1 to skip the header (A, B, C, ...)
			Row row = sheet.getRow(i);
			data[i-1][0] = row.getCell(0).getStringCellValue();
			data[i-1][1] = row.getCell(1).getStringCellValue();		
		}
		workbook.close();
		
		return data;
	}
	
}
