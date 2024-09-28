package Utility;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;


import com.google.common.base.Function;

public class WaitingMethods<V> extends SettingUpWebDriver{
	
	
	public void implicitWait(Duration duration) {
		
		getDriver().manage().timeouts().implicitlyWait(duration);
	}
	
	
	public void explicitWait(Duration duration, Function<? super WebDriver,V> condition) {
		
		WebDriverWait driverWait = new WebDriverWait(getDriver(), duration);
		driverWait.until(condition);
	}
	
	
	
}
