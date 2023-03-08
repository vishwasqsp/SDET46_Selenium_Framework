package hms.eMedCure.ObjectRepository.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class userDashboardPage 
{
	private WebDriver driver;
	//declartion
	private String userDashboardPartialXpath = "//span[. = '%s']";
	
		
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
		
		//initialization
		public userDashboardPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void clickUserDashboardTab(userDashboardTabnames tabNames)
		{
			convertToWebElement(userDashboardPartialXpath, tabNames.getTab()).click();
		}
}
