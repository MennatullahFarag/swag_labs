package test_loginPage;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.ConfigerLoader;
import Utility.SettingUpWebDriver;
import comp_login.LoginPageComp;

public class LoginPageCompTest extends LoginPageComp {
	//31-8-2024 session
	@BeforeMethod
    public void OpenBrowser() throws Exception{
		ConfigerLoader loader = new ConfigerLoader();
		SetUpTheDriver(loader.getConfigValue("config", "SwagLabsURL"));
    }
	
	
	@Test
	public void CheckLoginPageOpened() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.CheckLoginPageOpened();
	}
	
	
	@Test
	public void CheckUserLoginWithValidData() {
		LoginPageComp loginPageComp = new LoginPageComp();
		//check if login page opened
		loginPageComp.CheckLoginPageOpened();
		loginPageComp.CheckUserLoginWithValidData();
	}
	
	@Test
	public void CheckInvalidData() {
		
	}

	@Test
	public void CheckLoginDataWithExcelFile() throws IOException{
		EnterLoginDataWithExcelFile();
	}
	
	@Test
	public void CheckLoginWithConfig() throws InterruptedException {
		LoginWithConfig();
	}
	@Test
	public void TestUserLoginWithValidDataByJson() throws IOException, InterruptedException{
		CheckUserLoginWithValidDataByJson();
	}
	
	@Test
	public void TestUserLoginWithJavaFaker() {
		CheckUserLoginWithJavaFaker();
	}
	
	@AfterMethod
    public void CloseBrowser() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();

    }

}
