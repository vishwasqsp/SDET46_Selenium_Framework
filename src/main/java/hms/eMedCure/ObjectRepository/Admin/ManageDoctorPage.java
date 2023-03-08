package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtilities.WebActions.DropdownUtility;

public class ManageDoctorPage 
{
	//declartion
			@FindBy(xpath = "(//i[@class = 'fa fa-times fa fa-white'])[last()]") private WebElement deleteDoctorIcon;
			@FindBy(xpath = "(//i[@class = 'fa fa-pencil'])[last()]") private WebElement editDoctorIcon;
			
			
			//initialization
			public ManageDoctorPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//utilization
			public void deleteDoctorAction()
			{
				deleteDoctorIcon.click();
			}
			public void editDoctorAction()
			{
				editDoctorIcon.click();
			}
}
