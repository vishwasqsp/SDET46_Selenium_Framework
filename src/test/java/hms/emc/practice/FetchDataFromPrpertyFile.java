package hms.emc.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromPrpertyFile 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData/commonData.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String url = prop.getProperty("url");
		String userusername = prop.getProperty("userUsername");
		String userPassword = prop.getProperty("userPassword");
		String docusername = prop.getProperty("docUsername");
		String docpassword = prop.getProperty("docPassword");
		String adminusername = prop.getProperty("adminUsername");
		String adminpassword = prop.getProperty("adminPassword");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//a[@href ='hms/user-login.php']")).click();
		driver.findElement(By.name("username")).sendKeys(userusername);
		driver.findElement(By.name("password")).sendKeys(userPassword);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[. = ' Book Appointment ']")).click();
		WebElement ele = driver.findElement(By.name("Doctorspecialization"));
		Select s = new Select(ele);
		s.selectByVisibleText("Dermatologist");
		WebElement ele1 = driver.findElement(By.name("doctor"));
		Select s1 = new Select(ele1);
		s1.selectByIndex(1);
		driver.findElement(By.name("appdate")).click();
		driver.findElement(By.xpath("//td[. = '28']")).click();
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//span[. = ' Appointment History ']")).click();
		driver.findElement(By.xpath("(//a[@title = 'Cancel Appointment'])[last()]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//span[@class = 'username']")).click();
		driver.findElement(By.xpath("//a[contains(text() , 'Log Out')]")).click();
		driver.quit();
		
		fis.close();
	}

}
