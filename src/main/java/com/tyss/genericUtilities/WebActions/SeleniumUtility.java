package com.tyss.genericUtilities.WebActions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tyss.genericUtilities.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to handle webdriver methods
 * @author User
 *
 */
public class SeleniumUtility {
	/**
	 * This method is used to specify the browser
	 */
	private WebDriver driver;
	public WebDriver launchBrowser(String browser)
	{
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Enter proper key");
			break;
		}
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to pass the url
	 * @param url
	 */
	public void applicationUrl(String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to resize the browser
	 * @param width
	 * @param height
	 */
	public void resizeBrowser(int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width, height));
	}
	/**
	 * This method is used to close the browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	/**
	 * This method is used to close the tab
	 */
	public void closeTab()
	{
		driver.close();
	}
	/**
	 * This method is used to get current url
	 * @return
	 */
	public String currentURL()
	{
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}
	/**
	 * This method is used to get page source
	 * @return
	 */
	public String pageSource()
	{
		String pagesource = driver.getPageSource();
		return pagesource;
	}
	/**
	 * This method is used to get title of the page
	 * @return
	 */
	public String title()
	{
		String title = driver.getTitle();
		return title;
	}
	/**
	 * This method is used to take screenshot of an element
	 * @param element
	 * @param elementName
	 * @param javautility
	 * @return
	 */
	public String takeScreenShotOfAnElement(WebElement element, String elementName, JavaUtility javautility)
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/elements/"+elementName+javautility.getCurrentDateTime()+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dst.getAbsolutePath();

	}
	/**
	 * This method is used to take screenshot of an application
	 * @param driver
	 * @param pageName
	 * @param javautility
	 */
	public void takeScreenshotOfPage(WebDriver driver, String pageName, JavaUtility javautility)
	{
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/pages/"+pageName+javautility.getCurrentDateTime()+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
