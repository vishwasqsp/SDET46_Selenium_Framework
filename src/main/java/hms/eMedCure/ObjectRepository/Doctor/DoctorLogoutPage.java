package hms.eMedCure.ObjectRepository.Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLogoutPage 
{
	//declartion
			@FindBy(xpath = "//span[@class = 'username']") private WebElement doctorProfileIcon;
			@FindBy(xpath = "//a[@href = 'logout.php']") private WebElement logoutButton;


			//initialization
			public DoctorLogoutPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//utilization
			public void doctorLogoutAction()
			{
				doctorProfileIcon.click();
				logoutButton.click();
			}
}
