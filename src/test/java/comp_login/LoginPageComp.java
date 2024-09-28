package comp_login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utility.ConfigerLoader;
import Utility.DataUtils;
import Utility.ExcelUtils;


public class LoginPageComp  extends LoginPageWebElement {
    
	
	
	public void CheckLoginPageOpened() {
		 //URL
		 String URL = driver.getCurrentUrl();
		 Assert.assertEquals(URL, "https://www.saucedemo.com/");
	     
		 //Container
	     WebElement Container = getContainer();
	     Assert.assertNotNull(Container);
	     
	     //logo
	     WebElement Logo = getLogo();
	     String LogoName = Logo.getText();
	     Assert.assertEquals(LogoName,"Swag Labs");
	}
	
	
	public void CheckUserLoginWithValidData() {
		
		//check Uname, pass, error msg and login btn fields are found
		 WebElement UserNameField = getUserNameField();
		 Assert.assertNotNull(UserNameField);
		 
		 WebElement PassField = getPasswordField();
		 Assert.assertNotNull(PassField);
		 
		 WebElement ErrorMsg = getErrorMsg();
		 Assert.assertNotNull(ErrorMsg);
		 
	     WebElement LoginBtn = getLoginBtn();
	     Assert.assertNotNull(LoginBtn);

	     //user login with valid data
	     UserNameField.sendKeys("standard_user");
	     PassField.sendKeys("secret_sauce");
	     LoginBtn.click();//we can use submit also to click submit even if there's no submit button in the page
	     Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	
	}

	public void EnterLoginDataWithExcelFile() throws IOException{
		// Path to the Excel file
        String excelFilePath = "./Resources/session 12 sept 2024.xlsx";
 
        // Create instance of ExcelUtils to read login data
        ExcelUtils excelUtils = new ExcelUtils(excelFilePath);
 
        // Get login data (sheet name is "Sheet1")
        String[][] loginData = excelUtils.getLoginData("Sheet1");
 
        // Loop through the login data and perform login
        for (int i = 0; i < loginData.length; i++) {
        	System.out.println(loginData.length);
            String username = loginData[i][0];
            String password = loginData[i][1];
 
            System.out.println("Logging in with Username: " + username + " and Password: " + password);
            
            WebElement userNameField= getUserNameField();
            WebElement passwordField = getPasswordField();
            WebElement loginButton = getLoginBtn();
            
            userNameField.clear();
            userNameField.sendKeys(username);
            passwordField.clear();
            passwordField.sendKeys(password);
            loginButton.click();
            
            CheckIfContains(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
            
            driver.navigate().back();
            
	}
        excelUtils.workbook.close();
	}

	public void LoginWithConfig() throws InterruptedException{
		
		logger.debug("Login with config data");
		
		ConfigerLoader loader = new ConfigerLoader();
		System.out.println("The name is: "+loader.getConfigValue("config", "UserName"));
		
		//WaitingMethods wait = new WaitingMethods();
		
		
		WebElement UserNameField = getUserNameField();
		WebElement passwordField = getPasswordField();
        WebElement loginButton = getLoginBtn();
        
        UserNameField.sendKeys(loader.getConfigValue("config", "UserName"));
        passwordField.sendKeys(loader.getConfigValue("config", "password"));
        loginButton.click();
	}

	public void CheckUserLoginWithValidDataByJson() throws IOException, InterruptedException{
		logger.debug("Check login with valid data by Json");
		WebElement UserNameField = getUserNameField();
		CheckIfNotNull(UserNameField, "user name field");
        UserNameField.sendKeys(DataUtils.getJsonValue("LoginData", "UserLogin.UserName"));
        logger.info("Username: " + UserNameField.getAttribute("value"));
        
		WebElement passwordField = getPasswordField();
		CheckIfNotNull(passwordField, "password field");
		passwordField.sendKeys(DataUtils.getJsonValue("LoginData", "UserLogin.Password"));
        logger.info("Password: " + passwordField.getAttribute("value"));
		
        WebElement loginButton = getLoginBtn();
		CheckIfNotNull(loginButton, "login button");
        loginButton.click();
	}
	
	public void CheckUserLoginWithJavaFaker() {
		logger.debug("Check login with Java faker");
		
		Faker faker = new Faker();
		String randomUserName = faker.name().username();
		String randomPassword = faker.internet().password();
		
		WebElement UserNameField = getUserNameField();
		CheckIfNotNull(UserNameField, "user name field");
        UserNameField.sendKeys(randomUserName);
        logger.info("Username: " + randomUserName);
        
        WebElement passwordField = getPasswordField();
		CheckIfNotNull(passwordField, "password field");
		passwordField.sendKeys(randomPassword);
        logger.info("Password: " + randomPassword);
        
        WebElement loginButton = getLoginBtn();
		CheckIfNotNull(loginButton, "login button");
        loginButton.click();
		
        CheckIfActualEqualsExpected(driver.getCurrentUrl(), "https://www.saucedemo.com/");

	}









}