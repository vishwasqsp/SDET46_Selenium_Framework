package hms.eMedCure.ObjectRepository.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogoutPage 
{
	//declartion
			@FindBy(xpath = "//span[@class = 'username']") private WebElement userProfileIcon;
			@FindBy(xpath = "//a[contains(text() , 'Log Out')]") private WebElement logoutButton;


			//initialization
			public UserLogoutPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//utilization
			public void UserLogoutAction()
			{


				userProfileIcon.click();
				logoutButton.click();
			}
}
