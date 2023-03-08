package com.tyss.genericUtilities.WebActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author User
 *
 */
public class JavaScriptUtility 
{
	JavascriptExecutor js;
	public JavaScriptUtility(WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
	}
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
	}
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView", element);
	}
	public void sendKeys(WebElement element, String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	public void launchApplication(String url)
	{
		js.executeScript("window.location=argument[0]", url);
	}
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	public void highlightWebElement(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style' , 'border:5px dotted red;');", element);
	}
}
