package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecialization
{
	//declartion
		@FindBy(name = "doctorspecilization") private WebElement doctorSpecializationTextfield;
		@FindBy(name = "submit") private WebElement doctorspecializationSubmitButton;
		@FindBy(xpath = "//h1[. = 'Admin | Add Doctor Specialization']") private WebElement addDoctorSpecialisationPage;
		
		//initialization
		public AddDoctorSpecialization(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void AddDoctorSpecialization(String doctorspecialisation)
		{
			doctorSpecializationTextfield.sendKeys(doctorspecialisation);
			doctorspecializationSubmitButton.click();
		}
		public String AddDoctorSpecialisationPageVerification(String name)
		{
			return addDoctorSpecialisationPage.getText();
		}
}
