package comp_homepage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.Assert;

import Utility.ExcelUtils;
import Utility.TestingMethod;


public class HomePageComp extends HomePageWebElement{
	
	
	public void ClickAddToCartBtn() {
			logger.debug("Click Add To Cart");
			
			WebElement AddToCartBtn = getAddToCartBtn();
			assertNotNull(AddToCartBtn);
			//check text of the btn
			String TextAddToCartBtn = AddToCartBtn.getText();
			assertTrue(TextAddToCartBtn.contains("Add to cart"));
			//check if the btn is clickable
			assertTrue(AddToCartBtn.isEnabled());
			AddToCartBtn.click();
		}
	public void CheckTheCartBadgeIsDisplayed() {
		WebElement ShoppingCartNumber = getShoppingCartNumber();
		assertNotNull(ShoppingCartNumber);
		CheckIfActualEqualsExpected(ShoppingCartNumber.getText(), "1");
	}
	public void CheckColorAndTxtForRemoveBtn() {
	WebElement RemoveBtn = getRemoveBtn();
	assertNotNull(RemoveBtn);
	//check color
	String RemoveBtnColor = RemoveBtn.getCssValue("color");
	System.out.println(RemoveBtnColor);
	//check btn text
	String TextRemoveBtn = RemoveBtn.getText();
	assertTrue(TextRemoveBtn.contains("Remove"));
}

	public void ClickRemoveBtn() {
		
		WebElement RemoveBtn = getRemoveBtn();
		assertNotNull(RemoveBtn);
		//check text of the btn
		String TextRemoveBtn = RemoveBtn.getText();
		assertTrue(TextRemoveBtn.contains("Remove"));
		//check if the btn is clickable
		assertTrue(RemoveBtn.isEnabled());
		RemoveBtn.click();
	}
	public void CheckTheCartBadgeIsRemoved() {
		try {
			WebElement ShoppingCartNumber = getShoppingCartNumber();
		} catch (NoSuchElementException e) {
			System.out.println("The cart badge is not displayed");
		}
		
		//assertNull(ShoppingCartNumber);
		
	}
	public void CheckColorAndTxtForAddToCartBtn() {
		WebElement AddBtn = getAddToCartBtn();
		assertNotNull(AddBtn);
		//check color
		String AddBtnColor = AddBtn.getCssValue("color");
		System.out.println(AddBtnColor);
		//check btn text
		String TextAddBtn = AddBtn.getText();
		assertTrue(TextAddBtn.contains("Add to cart"));
	}

	
	public void AddTheSixInventoryItemsToTheCart() {
		//add all "add to cart" buttons to a list
		List<WebElement> TheSixAddToCartBtns = getListOfAddToCartBtns();
		//check this list contains all the elements which are 6
		assertEquals(TheSixAddToCartBtns.size(), 6);
		
		int counter = 0;
		for(WebElement EachAddToCartBtn : TheSixAddToCartBtns) {
			String Text_EachAddToCartBtn = EachAddToCartBtn.getText();
			assertTrue(Text_EachAddToCartBtn.contains("Add to cart"));
			//check if the btn is clickable
			assertTrue(EachAddToCartBtn.isEnabled());
			EachAddToCartBtn.click();
			counter+=1;
			//pass the number displayed after each addition to the number check method
			CheckNumberIsDisplayedOnTheCartIcon(counter);
		}
	}
	public void CheckNumberIsDisplayedOnTheCartIcon(int displayedNumber) {
		WebElement ShoppingCartNumber = getShoppingCartNumber();
		assertNotNull(ShoppingCartNumber);
		String displayedNumberAsString = Integer.toString(displayedNumber);
		assertEquals(ShoppingCartNumber.getText(), displayedNumberAsString);
		System.out.println("The number that is displayed on the shopping cart icon is: " + ShoppingCartNumber.getText());
	}
	public void RemoveTheSixInventoryItemsFromTheCart() {
		//add all "remove" buttons to a list
		List<WebElement> TheSixRemoveBtns = getListOfRemoveBtns();
		//check this list contains all the elements which are 6
		assertEquals(TheSixRemoveBtns.size(), 6);
		
		int counter = 6;
		for(WebElement EachRemoveBtn : TheSixRemoveBtns) {
			String Text_EachRemoveBtn = EachRemoveBtn.getText();
			assertTrue(Text_EachRemoveBtn.contains("Remove"));
			//check if the btn is clickable
			assertTrue(EachRemoveBtn.isEnabled());
			//pass the number displayed, after each addition, to the number checking method 
			//(except for number 6, it's passed before clicking the first remove)
			CheckNumberIsDisplayedOnTheCartIcon(counter);
			EachRemoveBtn.click();
			counter-=1;
		}
	}

	//check every item's components
	//Item 1
		//Image
		public void CheckFirstItemImageIsDisplayed() {
			WebElement img1 = getItemImg(1);//pass to "getItemImg" the number of the image according to its order in the page(the order of left images is always odd number).
			CheckIfDisplayed(img1, "Sauce Labs Backpack image");
		}
		//Name
		public void CheckFirstItemNameIsDisplayed() throws IndexOutOfBoundsException{
			WebElement name1 = getItemName(1);//pass to "getItemName" the number of the name according to its order in the page(the order of left names is always odd number).
			CheckIfDisplayed(name1, "Sauce Labs Backpack item name");
		}
		//Description
		
		//Price
		
		//Button
		
		//Item 2
		public void CheckSecondItemImageIsDisplayed() {
			WebElement img2 = getItemImg(2);
			CheckIfDisplayed(img2, "Sauce Labs Bike Light");
		}
		//Item 3
		public void CheckThirdItemImageIsDisplayed() {
			WebElement img3 = getItemImg(3);
			CheckIfDisplayed(img3, "Sauce Labs Bolt T-Shirt");
		}
		//Item 4
		public void CheckForthItemImageIsDisplayed() {
			WebElement img4 = getItemImg(4);
			CheckIfDisplayed(img4, "Sauce Labs Bike Light");
		}
		//Item 5
		public void CheckFifthItemImageIsDisplayed() {
			WebElement img5 = getItemImg(5);
			CheckIfDisplayed(img5, "Sauce Labs Bike Light");
		}
		//Item 6
		public void CheckSixthItemImageIsDisplayed() {
			WebElement img6 = getItemImg(6);
			CheckIfDisplayed(img6, "Sauce Labs Bike Light");
		}
}
