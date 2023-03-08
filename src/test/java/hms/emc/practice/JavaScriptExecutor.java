package hms.emc.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location='http://rmgtestingserver/domain/Hospital_Management_System/hms/user-login.php'");
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement submit = driver.findElement(By.id("submitButton"));
	}

}
