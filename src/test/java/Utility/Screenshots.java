package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comp_login.LoginPageWebElement;

public class Screenshots extends SettingUpWebDriver {
	
	
	public void captureScreenshot(WebDriver driver, String testClassName, String testMethodName) {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//define the directory path based on class and method names
		String directoryPath = "./Screenshots" + testClassName;
		//check the directory path created
		System.out.println("The directory path is:" + directoryPath);
		
		//creating our target directory to store the screenshot files
		File targetDirectory = new File(directoryPath);
		if(!targetDirectory.exists()) {
			boolean bool = targetDirectory.mkdirs(); //CREATING FILE OR FOLDER?
			//check if the file is made successfully
			System.out.println("Does the target directory is created successfully?:" + bool);
		}
		//Giving the screenshot file its name based on class and method name
		File targetFile = new File(targetDirectory, testClassName+"_"+testMethodName+".png");//CLASS NAME DUPLICATED?
		//copy the source file to our target file in our target directory
		try {
			FileUtils.copyFile(srcFile, targetFile);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void captureElementScreenshot(WebElement element, String testClassName, String testMethodName) {
		
		File srcFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		
		//define the directory path based on class and method names
		String directoryPath = "./Screenshots" + testClassName;
		//check the directory path created
		System.out.println("The directory path is:" + directoryPath);
		
		//creating our target directory to store the screenshot files
		File targetDirectory = new File(directoryPath);
		if(!targetDirectory.exists()) {
			boolean bool = targetDirectory.mkdirs(); //CREATING FILE OR FOLDER?
			//check if the file is made successfully
			System.out.println("Does the target directory is created successfully?:" + bool);
		}
		//Giving the screenshot file its name based on class and method name
		File targetFile = new File(targetDirectory, testClassName+"_"+testMethodName+".png");//CLASS NAME DUPLICATED?
		//copy the source file to our target file in our target directory
		try {
			FileUtils.copyFile(srcFile, targetFile);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
