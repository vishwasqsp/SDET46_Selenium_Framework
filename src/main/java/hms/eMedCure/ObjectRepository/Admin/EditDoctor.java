package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDoctor 
{

	//declartion
		@FindBy(name = "docname") private WebElement doctorNameTextfield;
		@FindBy(name = "clinicaddress") private WebElement doctorClicnicAddressTextfield;
		@FindBy(name = "docfees") private WebElement doctorFeesTextfield;
		@FindBy(name = "doccontact") private WebElement doctorContactTextfield;
//		@FindBy(name = "docname") private WebElement doctorSpecializationTextfield;
//		@FindBy(name = "docname") private WebElement doctorSpecializationTextfield;
		@FindBy(name = "submit") private WebElement editDoctorSubmitButton;
		
		
		//initialization
		public EditDoctor(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void EditDoctorAction(String doctorName, String doctorClicnicAddress, String doctorFees, String doctorContact)
		{
			doctorNameTextfield.clear();
			doctorNameTextfield.sendKeys(doctorName);
			doctorClicnicAddressTextfield.clear();
			doctorClicnicAddressTextfield.sendKeys(doctorClicnicAddress);
			doctorFeesTextfield.clear();
			doctorFeesTextfield.sendKeys(doctorFees);
			doctorContactTextfield.clear();
			doctorContactTextfield.sendKeys(doctorContact);
			editDoctorSubmitButton.click();
		}
}
