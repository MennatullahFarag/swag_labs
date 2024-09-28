package Utility;

import org.testng.ITestResult;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;

public class SettingUpWebDriver extends ConfigerLoader{
	
	public static WebDriver driver;
	
	public static WebDriver getBrowser(String browserType) {
		switch (browserType.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();// SafariDriver comes pre-installed with macOS
			break;
		case "chrome-headless":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");// Applicable for Windows
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
			break;
		default:
			System.out.println("Invalid browser type! Please check the input.");
		}
		return driver;
	}
	
	public void SetUpTheDriver(String URL) throws Exception {
		driver = getBrowser("chrome-headless");
        driver.manage().window().maximize();
        driver.navigate().to(URL);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
//	public void setup(ITestResult result) throws Exception {
//		 
//	    // Initialize the WebDriver using the factory
//	    driver = getBrowser("chrome-headless");
//
//	    driver.manage().window().maximize();
//
//	    driver.get("https://www.saucedemo.com/");
//	}
//	public void CloseDriver(ITestResult result) throws Exception{
//		if(!result.isSuccess()) {
//			String testClassName = result.getClass().getName();
//			String testMethodName = result.getMethod().getMethodName();
//			//Screenshots.captureScreenShot(driver, testClassName, testMethodName);
//			ScreenRecord.stopRecording(myScreenRecord);
//		}
//		
//		Thread.sleep(2000);
//		driver.quit();
//	}

}
