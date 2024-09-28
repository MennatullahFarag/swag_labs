package test_homepage;

import comp_homepage.HomePageComp;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.devtools.v125.v125CdpInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.ScreenRecord;
import comp_login.LoginPageComp;
//import comp_homepage.HomePageComp;
//import Utility.SettingUpWebDriver;

public class HomePageCompTest extends HomePageComp{
	@BeforeMethod
    public void OpenBrowser() throws Exception{
		//ScreenRecorder myScreenRecord = ScreenRecord.startRecording("ScreenRecordedVideo.mp4");
       SetUpTheDriver("https://www.saucedemo.com/");
	}
	
	
	
	@Test
	public void CheckBadgeNumberIsDisplayedAfterPressingAddToCart() {
		LoginPageComp loginPageComp = new LoginPageComp();
		//check if logged in successfully
		loginPageComp.CheckUserLoginWithValidData();
		
		
		ClickAddToCartBtn();
//		CheckTheCartBadgeIsDisplayed();
//		CheckColorAndTxtForRemoveBtn();
//		ClickRemoveBtn();
//		CheckTheCartBadgeIsRemoved();
//		CheckColorAndTxtForAddToCartBtn();
	}
	
	@Test
	public void CheckNumberIsDisplayedOnCartIconAfterAddingEachItemToTheCart() {
		
		LoginPageComp loginPageComp = new LoginPageComp();
		//check if logged in successfully
		loginPageComp.CheckUserLoginWithValidData();
		
		AddTheSixInventoryItemsToTheCart();
		System.out.println("Now we'll remove the 6 items");
		RemoveTheSixInventoryItemsFromTheCart();
	}

	
	
	
	
	@AfterMethod
    public void CloseBrowser() throws InterruptedException{
		//ScreenRecord.stopRecording(myScreenRecord);
        Thread.sleep(3000);
        driver.quit();

    }
}



	
	
	