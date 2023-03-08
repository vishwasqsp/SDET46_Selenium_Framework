package hms.eMedCure.ObjectRepository.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage 
{
	//declartion
			@FindBy(name = "username") private WebElement userUsernameTextfield;
			@FindBy(name = "password") private WebElement userPasswordTextfield;
			@FindBy(name = "submit") private WebElement userLoginButton;
			@FindBy(xpath = "//a[contains(text(),'Create an account')]") private WebElement createAnAccountLink;
			
			//initialization
			public UserLoginPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//utilization
			public void userLoginAction(String username, String password)
			{
				userUsernameTextfield.sendKeys(username);
				userPasswordTextfield.sendKeys(password);
				userLoginButton.click();
				
			}
			public void createAnAccountAction()
			{
				createAnAccountLink.click();
			}
}
