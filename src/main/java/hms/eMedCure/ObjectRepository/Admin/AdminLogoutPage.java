package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtilities.WebActions.DropdownUtility;

public class AdminLogoutPage 
{

		//declartion
		@FindBy(xpath = "//span[@class = 'username']") private WebElement adminProfileIcon;
		@FindBy(xpath = "//a[@href = 'logout.php']") private WebElement logoutButton;


		//initialization
		public AdminLogoutPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public void AdminLogoutAction()
		{


			adminProfileIcon.click();
			logoutButton.click();
		}
}
