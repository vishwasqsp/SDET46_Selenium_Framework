package hms.eMedCure.ObjectRepository.User;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistrationPage 
{
	private WebDriver driver;
	//declartion
	private String patientRegistrationPartialXpath = "//*[@name = '%s']";
	
	
	@FindBy(xpath = "//label[contains(text(),'Male')]") private WebElement genderButton;
	@FindBy(xpath = "//button[@type = 'submit']") private WebElement patientRegistrationSubmitButton;
	@FindBy(name = "email") private WebElement patientEmailTextfield;
	@FindBy(xpath = "//a[@href = 'user-login.php']") private WebElement logInButton;
	
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
		
		//initialization
		public PatientRegistrationPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void patientRegistrationAction(Map<String, String> patientDetails, String userEmail)
		{
			for(Entry<String, String> details : patientDetails.entrySet())
			{
				convertToWebElement(patientRegistrationPartialXpath, details.getKey()).sendKeys(details.getValue());
			}
			patientEmailTextfield.sendKeys(userEmail);
			genderButton.click();
			patientRegistrationSubmitButton.click();
		}
		public void patientLogin()
		{
			logInButton.click();
		}
}
