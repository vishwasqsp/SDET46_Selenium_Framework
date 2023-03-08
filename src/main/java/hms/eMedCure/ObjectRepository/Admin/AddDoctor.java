package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tyss.genericUtilities.WebActions.DropdownUtility;

public class AddDoctor 
{
	
	
	//declartion
	    @FindBy(name = "Doctorspecialization") private WebElement doctorspecializationDropdown;
		@FindBy(name = "docname") private WebElement doctorNameTextfield;
		@FindBy(name = "clinicaddress") private WebElement doctorAddressTextfield;
		@FindBy(name = "docfees") private WebElement doctorFeesTextfield;
		@FindBy(name = "doccontact") private WebElement doctorContactTextfield;
		@FindBy(name = "docemail") private WebElement doctorEmailTextfield;
		@FindBy(name = "npass") private WebElement doctorPasswordTextfield;
		@FindBy(name = "cfpass") private WebElement doctorConfirmPasswordTextfield;
		@FindBy(name = "submit") private WebElement addDoctorSubmitButton;
	
		//initialization
		public AddDoctor(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void AddDoctorAction(DropdownUtility dropdownUtility, String doctorSpecialisation, String doctorName, String doctorAddress, String doctorFees, String doctorContact, String doctorEmail, String doctorPassword, String doctorConfirmPassword)
		{
			dropdownUtility.selectByValue(doctorspecializationDropdown, doctorSpecialisation);
			
			doctorspecializationDropdown.click();
			doctorNameTextfield.sendKeys(doctorName);
			doctorAddressTextfield.sendKeys(doctorAddress);
			doctorFeesTextfield.sendKeys(doctorFees);
			doctorContactTextfield.sendKeys(doctorContact);
			doctorEmailTextfield.sendKeys(doctorEmail);
			doctorPasswordTextfield.sendKeys(doctorPassword);
			doctorConfirmPasswordTextfield.sendKeys(doctorConfirmPassword);
			addDoctorSubmitButton.click();
		}
		
}
