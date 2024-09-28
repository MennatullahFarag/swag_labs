package Utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;

public class DataUtils {
	
	public static String Login_Data_Jason_Path = "./Resources/";	
	
	public static String getExcelData(String excelFilePath, String excelFileName, String sheetName, int rowNum, int columnNum) {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		String cellData;
		
		try {
			//load the excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFileName);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			
			//get the data from the specified cell
			cellData = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
			
			workbook.close();
			return cellData;
		}
		catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
			return null;
		}
	}

	
	public static String getJsonValue(String JsonFilename, String field) {
		try {
			// reading the json file
			FileReader reader = new FileReader(Login_Data_Jason_Path + JsonFilename + ".json");
			//parsing the json file content into a generic object
			Object jsonData = new Gson().fromJson(reader, Object.class);
			//using json path to extract the value of the specified field from the json object
			return JsonPath.read(jsonData, "$." + field);
			
		} catch (Exception e) {
			return "";
		}
	}
}
