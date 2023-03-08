package com.tyss.genericUtilities.WebActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class is used to achieve synchronization
 * @author User
 *
 */
public class WaitUtility {
	private WebDriverWait wait;
	private WebDriver driver;


	public WaitUtility(WebDriver driver, long timeout)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}
	/**
	 * This method is used to pause a application 
	 * @param millisecond
	 */
	public void pause(long millisecond)
	{
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is to wait till the element loads
	 * @param driver
	 * @param timeout
	 */
	public void WaitForElementTOLoad(WebDriver driver, long timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	/**
	 * This method is to wait till the text is visible
	 * @param element
	 * @param driver
	 */
	public void WaitTillVisibleText(String xpath)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}
	/**
	 * This method is to wait till it is clickable
	 * @param element
	 * @param driver
	 */
	public void WaitTillClickable(String xpath)
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	/**
	 * This method is to wait till the text is invisible
	 * @param element
	 * @param driver
	 */
	public void WaitTillInvisibleOfText(String xpath)
	{
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}
	public void waitTillClick(long pollingTime, int duration, WebElement element)
	{
		int count = 0;
		while(count<duration)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count=count+((int)pollingTime/1000);
			}
		}
	}
}
