package comp_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class LoginPageWebElement extends FindingElements{

    public WebElement getContainer(){return getDriver().findElement(By.className("login_container"));}
    public WebElement getLogo(){return getDriver().findElement(By.className("login_logo"));}
    public WebElement getUserNameField(){return getDriver().findElement(By.id("user-name"));}
    public WebElement getPasswordField(){return getDriver().findElement(By.id("password"));}
    public WebElement getLoginBtn(){return getDriver().findElement(By.id("login-button"));}
    public WebElement getErrorMsg(){return getDriver().findElement(By.className("error-message-container"));}

}
