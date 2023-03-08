package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtilities.VerificationUtility;

import hms.eMedCure.ObjectRepository.AdminDasboardTabNames;


public class AdminDashboard 
{
	private WebDriver driver;
	//declartion
	private String adminDashboardPartialXpath = "//span[. = '%s']";
	
	@FindBy(xpath = "//h1[. = 'Admin | Dashboard']") private WebElement adminDashboard;
		
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
		
		//initialization
		public AdminDashboard(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void clickAdminDashboardTab(AdminDasboardTabNames tabName)
		{
			convertToWebElement(adminDashboardPartialXpath, tabName.getTab()).click();
		}
		public String adminDashboardVerification()
		{
			String text = adminDashboard.getText();
			return text;
		}
}
