package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogin 
{
	//declartion
	@FindBy(name = "username") private WebElement adminUsernameTextfield;
	@FindBy(name = "password") private WebElement adminPasswordTextfield;
	@FindBy(name = "submit") private WebElement adminLoginButton;
	
	//initialization
	public AdminLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void AdminLoginAction(String username, String password)
	{
		adminUsernameTextfield.sendKeys(username);
		adminPasswordTextfield.sendKeys(password);
		adminLoginButton.click();
	}
}
