package hms.emc.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.tyss.genericUtilities.FrameworkConstant;
import com.tyss.genericUtilities.JavaUtility;
import com.tyss.genericUtilities.VerificationUtility;
import com.tyss.genericUtilities.Enums.PropertyKeys;
import com.tyss.genericUtilities.WebActions.DropdownUtility;
import com.tyss.genericUtilities.WebActions.JavaScriptUtility;
import com.tyss.genericUtilities.WebActions.SeleniumUtility;
import com.tyss.genericUtilities.WebActions.WaitUtility;
import com.tyss.genericUtilities.externalFileUtility.Excelutility;
import com.tyss.genericUtilities.externalFileUtility.PropertyUtility;

import hms.eMedCure.ObjectRepository.Admin.AdminLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	
	public static void main(String[] args) {
		
		PropertyUtility pu = new PropertyUtility(FrameworkConstant.TEST_PROPERTY_FILE_PATH);
		Excelutility excelutility = new Excelutility(FrameworkConstant.TEST_EXCEL_FILE_PATH);
		SeleniumUtility su = new SeleniumUtility();
		JavaUtility javautility = new JavaUtility();
		VerificationUtility verificationutility = new VerificationUtility();
		DropdownUtility dropdown = new DropdownUtility();
		
		//common data
		String browser = pu.getPropertyData(PropertyKeys.BROWSER);
		long timeout = Long.parseLong(pu.getPropertyData(PropertyKeys.TIMEUNIT));
		String url = pu.getPropertyData(PropertyKeys.URL);
		String adminusername = javautility.decode(pu.getPropertyData(PropertyKeys.ADMINUSERNAME));
		String adminpassword = javautility.decode(pu.getPropertyData(PropertyKeys.ADMINPASSWORD));
		
		
		//launching application and passing url
//				WebDriver driver = su.launchBrowser(browser);
//				WaitUtility wu = new WaitUtility(driver, timeout);
//				su.maximizeBrowser();
//				wu.WaitForElementTOLoad(driver, timeout);
//				su.applicationUrl(url);
//				JavaScriptUtility js = new JavaScriptUtility(driver);
//				WebElement element = driver.findElement(By.xpath("//a[. = 'Hospital Management system']"));
//				js.highlightWebElement(element);
//				
//				String homepagename = driver.findElement(
//				WebElement element = driver.findElement(By.xpath("//a[. = 'Hospital Management system']"));By.xpath("//a[. = 'Hospital Management system']")).getText();
//				verificationutility.exactVerify(homepagename, adminusername);
//				if(homepagename.equals(adminusername))
//				{
//				su.takeScreenShotOfAnElement(element, "hospital", javautility);
//				su.takeScreenshotOfPage(driver, "homepage", javautility);
//				}
//				String homepagename = driver.findElement(By.xpath("//a[. = 'Hospital Management system']")).getText();
//				verificationutility.exactVerify(homepagename, browser);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/hms/admin/");
		AdminLogin login = new AdminLogin(driver);
		login.AdminLoginAction(adminusername, adminpassword);
		
}
}
