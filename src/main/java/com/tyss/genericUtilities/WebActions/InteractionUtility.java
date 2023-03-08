package com.tyss.genericUtilities.WebActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * This class is used for multiple actions on the application
 * @author User
 *
 */
public class InteractionUtility {
	private Actions act;
	/**
	 * This method is used for creating object for actions class
	 * @param driver
	 */
	public InteractionUtility(WebDriver driver)
	{
		act = new Actions(driver);
	}
	/**
	 * This method is used for mousehover action on the web element
	 * @param element
	 */
	public void mouseHoverAction(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	/**
	 * This method is used for doubleclick action on the web element
	 * @param element
	 */
	public void doubleClickAction(WebElement element)
	{
		act.doubleClick(element).perform();
	}
	/**
	 * This method is used for doubleclick action on the application
	 */
	public void doubleClickAction()
	{
		act.doubleClick().perform();
	}
	/**
	 * This method is used for rightclick action on the web element
	 * @param element
	 */
	public void rightClickAction(WebElement element)
	{
		act.contextClick(element).perform();
	}
	/**
	 * This method is used for rightclick action on the application
	 */
	public void rightClickAction()
	{
		act.contextClick().perform();
	}
	/**
	 * This method is used for drag and drop
	 * @param sourceElement
	 * @param targetElement
	 */
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement)
	{
		act.dragAndDrop(sourceElement, targetElement);
	}
	/**
	 * This method is used to perform enter key option 
	 */
	public void enter()
	{
		act.keyDown(Keys.ENTER).perform();
	}
}
