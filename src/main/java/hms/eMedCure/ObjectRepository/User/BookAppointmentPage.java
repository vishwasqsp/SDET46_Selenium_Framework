package hms.eMedCure.ObjectRepository.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtilities.WebActions.DropdownUtility;

public class BookAppointmentPage 
{
	//declartion
    @FindBy(name = "Doctorspecialization") private WebElement doctorspecializationDropdown;
	@FindBy(name = "doctor") private WebElement doctorNameDropdown;
	@FindBy(name = "appdate") private WebElement calendarWidget;
	@FindBy(xpath = "//td[. = '28']") private WebElement dateSelect;
	@FindBy(name = "submit") private WebElement bookAppointmentSubmitButton;

	//initialization
	public BookAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void BookAppointmentAction(DropdownUtility dropdownUtility, String doctorSpecialisation, int index)
	{
		dropdownUtility.selectBYVisibleText(doctorspecializationDropdown, doctorSpecialisation);
		dropdownUtility.selectByIndex(doctorNameDropdown, index);
		
		doctorspecializationDropdown.click();
		doctorNameDropdown.click();
		calendarWidget.click();
		dateSelect.click();
		bookAppointmentSubmitButton.click();
	}
}
