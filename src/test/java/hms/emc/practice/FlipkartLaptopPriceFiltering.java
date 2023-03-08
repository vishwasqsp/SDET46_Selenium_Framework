package hms.emc.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartLaptopPriceFiltering {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[. = '✕']")).click();
		driver.findElement(By.xpath("//input[@class = '_3704LK']")).sendKeys("laptop");
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();
		List<WebElement> element = driver.findElements(By.xpath("//div[@class = '_30jeq3 _1_WHN1'][not(number(translate(., '₹,', ''))>50000)]"));
		for (WebElement price : element) 
		{
			System.out.println(price.getText());
		}
	}

}
