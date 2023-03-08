package hms.eMedCure.ObjectRepository.Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientPage 
{
	//declartion
	@FindBy(xpath = "(//i[@class = 'fa fa-edit'])[last()]") private WebElement editPatientIcon;
	@FindBy(xpath = "(//i[@class = 'fa fa-eye'])[last()]") private WebElement viewPatientIcon;
	@FindBy(xpath = "//button[. = 'Add Medical History']") private WebElement addMedicalHistoryButton;
	
	//initialization
	public ManagePatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void MPatientAction()
	{
		editPatientIcon.click();
	}
	public void viewPatientAction()
	{
		viewPatientIcon.click();
	}
	public void addMedicalHistoryAction()
	{
		addMedicalHistoryButton.click();
	}
}
