package hms.eMedCure.ObjectRepository.Doctor;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage 
{
	private WebDriver driver;
	//declartion
	private String addPatientPartialXpath = "//*[@name = '%s']";
	
	@FindBy(xpath = "//label[@for = 'rg-male']") private WebElement genderRadioButton;
	@FindBy(name = "submit") private WebElement addPatientButton;
	@FindBy(name = "patemail") private WebElement patientEmailTextfield;
	
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
		
		//initialization
		public AddPatientPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void addPatientAction(Map<String, String> patientDetails, String patientemail)
		{
			for(Entry<String, String> details : patientDetails.entrySet())
			{
				convertToWebElement(addPatientPartialXpath, details.getKey()).sendKeys(details.getValue());
			}
			patientEmailTextfield.sendKeys(patientemail);
			genderRadioButton.click();
			addPatientButton.click();
		}
}
