package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindingElements extends TestingMethod{
	
	//Finding web element
	public WebElement findElementById(String ID) {
		WebElement element = getDriver().findElement(By.id(ID));
		return element;
	}
	
	public WebElement findElementByClassName(String className) {
		WebElement element = getDriver().findElement(By.className(className));
		return element;
	}
	
	public WebElement findElementBycssSelector(String cssSelector) {
		WebElement element = getDriver().findElement(By.cssSelector(cssSelector));
		return element;
	}
	
	public WebElement findElementByLinkText(String linkText) {
		WebElement element = getDriver().findElement(By.linkText(linkText));
		return element;
	}
	
	public WebElement findElementByName(String name) {
		WebElement element = getDriver().findElement(By.name(name));
		return element;
	}
	
	public WebElement findElementByPartialLinkText(String partialLinkTxt) {
		WebElement element = getDriver().findElement(By.partialLinkText(partialLinkTxt));
		return element;
	}
	
	public WebElement findElementByTagName(String tagName) {
		WebElement element = getDriver().findElement(By.tagName(tagName));
		return element;
	}
	
	public WebElement findElementByXpath(String xpath) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		return element;
	}


	//Finding list of web elements
	public List<WebElement> findElementsByClassName(String className){
		List<WebElement> element = getDriver().findElements(By.className(className));
		return element;
	}

	public List<WebElement> findElementsBycssSelector(String cssSelector){
		List<WebElement> element = getDriver().findElements(By.cssSelector(cssSelector));
		return element;
	}
	
	public List<WebElement> findElementsByLinkText(String linkText){
		List<WebElement> element = getDriver().findElements(By.linkText(linkText));
		return element;
	}
	
	public List<WebElement> findElementsByName(String name){
		List<WebElement> element = getDriver().findElements(By.name(name));
		return element;
	}
	
	public List<WebElement> findElementsByPartialLinkText(String partialLinkTxt){
		List<WebElement> element = getDriver().findElements(By.partialLinkText(partialLinkTxt));
		return element;
	}
	
	public List<WebElement> findElementsByTagName(String tagName){
		List<WebElement> element = getDriver().findElements(By.tagName(tagName));
		return element;
	}
	
	public List<WebElement> findElementsByXpath(String xpath){
		List<WebElement> element = getDriver().findElements(By.xpath(xpath));
		return element;
	}

}
