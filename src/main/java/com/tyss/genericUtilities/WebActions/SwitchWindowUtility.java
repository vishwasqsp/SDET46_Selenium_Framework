package com.tyss.genericUtilities.WebActions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This class is used for switching window
 * @author User
 *
 */
public class SwitchWindowUtility 
{
	/**
	 * This method is used to switch window
	 * @param driver
	 * @param strategy
	 * @param VerificationValue
	 */
	public void switchWindow(WebDriver driver, String strategy, String VerificationValue, WebElement element)
	{
		Set<String> windows = driver.getWindowHandles();
		for (String id : windows) 
		{
			driver.switchTo().window(id);
			if(strategy.equalsIgnoreCase("exact_url"))
			{
				if(driver.getCurrentUrl().equalsIgnoreCase(VerificationValue))
				{
					break;
				}

			}
			else if(strategy.equalsIgnoreCase("partial_url"))
			{
				if(driver.getCurrentUrl().contains(VerificationValue))
				{
					break;
				}
			}
			else if(strategy.equalsIgnoreCase("exact_title"))
			{
				if(driver.getTitle().equalsIgnoreCase(VerificationValue))
				{
					break;
				}
			}
			else if(strategy.equalsIgnoreCase("partial_title"))
			{
				if(driver.getTitle().equalsIgnoreCase(VerificationValue))
				{
					break;
				}
			}
			else if(strategy.equalsIgnoreCase("exact_element"))
			{
				if(element.getText().equalsIgnoreCase(VerificationValue))
				{
					break;
				}
			}
		}
	}
}
