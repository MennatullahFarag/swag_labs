package Utility;

import org.openqa.selenium.WebElement;
import comp_homepage.*;

public class TestingMethod extends WaitingMethods {
	
	//Assert not Null
		public void CheckIfNotNull(WebElement element, String elementName) {
			
			if(element == null) {
				String ErrMessage = String.format("Expected "+elementName+"To be not null, but it's found null.");
				//System.out.println(ErrMessage);
				throw new AssertionError(ErrMessage);
			}
		}
	
	//Assert Null
	public void CheckIfNull(WebElement element, String elementName) {
		
		if(!(element == null)) {
			String ErrMessage = String.format("Expected "+elementName+"To be null, but it's found not null.");
			//System.out.println(ErrMessage);
			throw new AssertionError(ErrMessage);
		}
	}
	
	//Assert Equals
	public void CheckIfActualEqualsExpected(String actual, String expected) {
		if(actual != expected) {
			String ErrMessage = String.format("Expected: '"+expected+"' to be found, but actually: '"+actual+"' is found.");
			throw new AssertionError(ErrMessage);
					
		}
	}
	
	//Assert contain
	public void CheckIfContains(String containerName, String contentName) {
		
		if(!(containerName.contains(contentName))) {
			String ErrMessage = String.format(contentName +" is not contained in "+ containerName);
			throw new AssertionError(ErrMessage);
			}
		}
	
	//Assert IsDisplayed
	public void CheckIfDisplayed(WebElement element, String elementName) {
		
		if(!(element.isDisplayed())){
			String ErrMessage = String.format(elementName+" is not displayed.");
			throw new AssertionError(ErrMessage);
		}
	}
	
	
	//Assert IsEnabled
	public void CheckIfEnabled(WebElement element, String elementName) {
			
			if(!(element.isEnabled())){
				String ErrMessage = String.format(elementName+" is disabled.");
				throw new AssertionError(ErrMessage);
			}
		}
}
