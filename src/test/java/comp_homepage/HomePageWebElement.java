package comp_homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class HomePageWebElement extends FindingElements{
    
	public WebElement getAddToCartBtn(){return findElementByClassName("btn_primary");}
	public List<WebElement> getListOfAddToCartBtns(){return findElementsByClassName("btn_primary");}

	public WebElement getRemoveBtn(){return findElementByClassName("btn_secondary");}
	public List<WebElement> getListOfRemoveBtns(){return findElementsByClassName("btn_secondary");}
	
	public WebElement getShoppingCartNumber(){return findElementByClassName("shopping_cart_badge");}
	
	public WebElement getItemImg(int imgOrder){
		String imgXpath = "";
		switch (imgOrder) {
		
		case 1:
			imgXpath = "//img[@alt=\"Sauce Labs Backpack\"]";
			break;

		case 2:
			imgXpath = "//img[@alt=\"Sauce Labs Bike Light\"]";
			break;
		
		case 3:
			imgXpath = "//img[@alt=\"Sauce Labs Bolt T-Shirt\"]";
			break;
		
		case 4:
			imgXpath = "//img[@alt=\\\"Sauce Labs Fleece Jacket\\\"]";
			break;
		
		case 5:
			imgXpath = "//img[@alt=\\\"Sauce Labs Onesie\\\"]";
			break;
		
		case 6:
			imgXpath = "//img[@alt=\"Test.allTheThings() T-Shirt (Red)\"]";
			break;

		default:
			System.out.println("Please pass to 'getItemImg' method a number from 1 to 6");
			break;
		}
		return findElementByXpath(imgXpath);}
	public List<WebElement> getListOfItemImg(){return findElementsByClassName("inventory_item_img");}
	
	public WebElement getItemName(int nameOrder) throws IndexOutOfBoundsException{
		List<WebElement> namesList = findElementsByXpath("//div[@data-test=\"inventory-item-name\"]");
		WebElement itemName = namesList.get(nameOrder-1);//"nameOrder-1" because the first name order acc. to the user is 1, while it's 0 acc. to java.
		return itemName;
	}


}
