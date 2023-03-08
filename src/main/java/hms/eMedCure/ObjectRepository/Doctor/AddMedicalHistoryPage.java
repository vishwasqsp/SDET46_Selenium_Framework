package hms.eMedCure.ObjectRepository.Doctor;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtilities.WebActions.JavaScriptUtility;
import com.tyss.genericUtilities.WebActions.SwitchWindowUtility;

public class AddMedicalHistoryPage 
{
	private WebDriver driver;
	//declartion
	private String addMedicalHistoryPartialXpath = "//*[@name = '%s']";
	
	@FindBy(xpath = "//button[@type = 'submit']") private WebElement addMedicalHistoryButton;
	
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
		
		//initialization
		public AddMedicalHistoryPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void addMedicalHistoryAction(Map<String, String> medicalHistoryDetails)
		{
			for(Entry<String, String> details : medicalHistoryDetails.entrySet())
			{
				convertToWebElement(addMedicalHistoryPartialXpath, details.getKey()).sendKeys(details.getValue());
			}
			addMedicalHistoryButton.click();
		}
}
