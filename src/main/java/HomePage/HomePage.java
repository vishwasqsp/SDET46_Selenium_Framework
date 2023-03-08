package HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//declartion
		@FindBy(xpath = "//a[@href = 'hms/admin']") private WebElement adminLoginLink;
		@FindBy(xpath = "//a[@href = 'hms/doctor/']") private WebElement doctorLoginLink;
		@FindBy(xpath = "//a[@href ='hms/user-login.php']") private WebElement userLoginLink;
		@FindBy(xpath = "//a[. = 'Hospital Management system']") private WebElement homePageVerification;
		
		//initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void adminLoginClick()
		{
			adminLoginLink.click();
		}
		public void doctorLoginClick()
		{
			doctorLoginLink.click();
		}
		public void userLoginClick()
		{
			userLoginLink.click();
		}
		public String homePage(String name)
		{
			return homePageVerification.getText();
		}
}
