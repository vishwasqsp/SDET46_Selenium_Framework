package com.tyss.genericUtilities.WebActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * This class is for handling Dropdown
 * @author User
 *
 */
public class DropdownUtility 
{
	/**
	 * This method is for selecting Dropdown using visibletext 
	 * @param element
	 * @param visibletext
	 */
	public void selectBYVisibleText(WebElement element, String visibletext)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibletext);
	}
	/**
	 * This method is for selecting Dropdown using value 
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is for selecting Dropdown using index 
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is for deselecting Dropdown using index 
	 * @param element
	 * @param index
	 */
	public void deselectByIndex(WebElement element, int index)
	{
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	/**
	 * This method is for deselecting Dropdown using value 
	 * @param element
	 * @param value
	 */
	public void deselectByValue(WebElement element, String value)
	{
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	/**
	 * This method is for deselecting Dropdown using visibletext
	 * @param element
	 * @param visibletext
	 */
	public void deselectBYVisibleText(WebElement element, String visibletext)
	{
		Select s = new Select(element);
		s.deselectByVisibleText(visibletext);
	}
	/**
	 * This method is for deselecting all the options in Dropdown
	 * @param element
	 */
	public void deselectAll(WebElement element)
	{
		Select s = new Select(element);
		s.deselectAll();
	}
}
