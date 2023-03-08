package com.tyss.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tyss.genericUtilities.WebActions.SeleniumUtility;

/**
 * This class is used for verification purpose 
 * @author User
 *
 */
public class VerificationUtility {

	/**
	 * This method is used for exact verification
	 * @param actual
	 * @param expected
	 */
	public void exactVerify(String actual, String expected)
	{


		if(actual.equals(expected))
		{
			System.out.println(expected+" page is dislpayed");
		}
		else
		{


			System.out.println(expected+" page is not dislpayed");
		}
	}
	/**
	 * This method is used for partial verification
	 * @param actual
	 * @param expected
	 */
	public void partialVerify(String actual, String expected)
	{
		if(actual.contains(expected))
		{
			System.out.println(expected+" page is dislpayed");
		}
		else
		{
			System.out.println(expected+" page is not dislpayed");
		}
	}
}
