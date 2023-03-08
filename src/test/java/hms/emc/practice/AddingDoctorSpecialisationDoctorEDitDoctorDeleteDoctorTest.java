package hms.emc.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest {

	public static void main(String[] args) throws IOException {
		String sheetName = "Sheet1";
		String expectedTestscriptName = "AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest";

		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\testData\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		Map<String, String> map = new HashedMap<>();
		for (int i = 1; i <= rowCount; i++) 
		{
			String testscriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			
			if(testscriptName.equalsIgnoreCase(expectedTestscriptName))
			{
				for(int j = 1; j< sheet.getRow(i).getLastCellNum(); j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/commonData/commonData.properties");

		Properties prop = new Properties();

		prop.load(fis1);

		String url = prop.getProperty("url");
		String userusername = prop.getProperty("userUsername");
		String userPassword = prop.getProperty("userPassword");
		String docusername = prop.getProperty("doctorUsername");
		String docpassword = prop.getProperty("doctorPassword");
		String adminusername = prop.getProperty("adminUsername");
		String adminpassword = prop.getProperty("adminPassword");
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		String homepagename = driver.findElement(By.xpath("//a[. = 'Hospital Management system']")).getText();
		if(homepagename.equals(map.get("homePageName")))
		{
			System.out.println("Homepage is displayed");
		}
		else
		{
			System.out.println("Homepage is not displayed");
		}
		driver.findElement(By.xpath("//a[@href = 'hms/admin']")).click();
		
		
		driver.findElement(By.name("username")).sendKeys(adminusername);
		driver.findElement(By.name("password")).sendKeys(adminpassword);
		driver.findElement(By.name("submit")).click();
		
		String admindashboard = driver.findElement(By.xpath("//h1[. = 'Admin | Dashboard']")).getText();
		if(admindashboard.equals(map.get("adminDashboard")))
		{
			System.out.println("Admin Dashboard is displayed");
		}
		else
		{
			System.out.println("Admin Dashboard is not displayed");
		}
		
		
		driver.findElement(By.xpath("//span[. = ' Doctors ']")).click();
		driver.findElement(By.xpath("//span[. = ' Doctor Specialization ']")).click();
		String adddoctorspecialisation = driver.findElement(By.xpath("//h1[. = 'Admin | Add Doctor Specialization']")).getText();
		if(adddoctorspecialisation.equals(map.get("addDoctorSpecialisation")))
		{
			System.out.println("Add Doctor Specialisation Page is displayed");
		}
		else
		{
			System.out.println("Add Doctor Specialisation Page is not displayed");
		}
		driver.findElement(By.name("doctorspecilization")).sendKeys(map.get("doctorSpecialisation"));
		driver.findElement(By.name("submit")).click();
		String specialisationconfirmation = driver.findElement(By.xpath("//p[. = 'Doctor Specialization added successfully !!								']")).getText();
		if(specialisationconfirmation.equals(map.get("addingDoctorSpecialisation")))
		{
			System.out.println("Add Doctor Specialisation Confirmation Message displayed");
		}
		else
		{
			System.out.println("Add Doctor Specialisation Confirmation Message not displayed");
		}
		driver.findElement(By.xpath("//span[. = ' Doctors ']")).click();
		driver.findElement(By.xpath("//span[. = ' Add Doctor']")).click();
		String adddoctorpage = driver.findElement(By.xpath("//h1[. = 'Admin | Add Doctor']")).getText();
		if(adddoctorpage.equals(map.get("addDoctorPage")))
		{
			System.out.println("Add Doctor Page is displayed");
		}
		else
		{
			System.out.println("Add Doctor Page is not displayed");
		}
		WebElement ele = driver.findElement(By.name("Doctorspecialization"));
		Select s = new Select(ele);
		s.selectByValue("Opthalogist");
		driver.findElement(By.name("docname")).sendKeys(map.get("doctorName"));
		driver.findElement(By.name("clinicaddress")).sendKeys(map.get("doctorAddress"));
		driver.findElement(By.name("docfees")).sendKeys(map.get("doctorFees"));
		driver.findElement(By.name("doccontact")).sendKeys(map.get("doctorContact"));
		String docEmail = map.get("doctorEmail")+new Random().nextInt(100)+"@gmail.com";
		driver.findElement(By.name("docemail")).sendKeys(docEmail);
		driver.findElement(By.name("npass")).sendKeys(map.get("doctorPassword"));
		driver.findElement(By.name("cfpass")).sendKeys(map.get("doctorConfirmPassword"));
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.xpath("//span[. = ' Doctors ']")).click();
		driver.findElement(By.xpath("//span[. = ' Manage Doctors ']")).click();
		String managedoctorspage = driver.findElement(By.xpath("//h1[. = 'Admin | Manage Doctors']")).getText();
		if(managedoctorspage.equals(map.get("manageDoctorsPage")))
		{
			System.out.println("Manage Doctors page is displayed");
		}
		else
		{
			System.out.println("Manage Doctors page is not displayed");
		}
		
		driver.findElement(By.xpath("(//i[@class = 'fa fa-pencil'])[last()]")).click();
		String editdoctordetailspage = driver.findElement(By.xpath("//h1[. = 'Admin | Edit Doctor Details']")).getText();
		if(editdoctordetailspage.equals(map.get("editDoctorDetailsPage")))
		{
			System.out.println("Edit Doctors Details page is displayed");
		}
		else
		{
			System.out.println("Edit Doctors Details page is not displayed");
		}
		
		driver.findElement(By.name("docname")).clear();
		driver.findElement(By.name("docname")).sendKeys(map.get("editDoctorName"));
		driver.findElement(By.name("clinicaddress")).clear();
		driver.findElement(By.name("clinicaddress")).sendKeys(map.get("editDoctorAddress"));
		driver.findElement(By.name("docfees")).clear();
		driver.findElement(By.name("docfees")).sendKeys(map.get("editDoctorFees"));
		driver.findElement(By.name("doccontact")).clear();
		driver.findElement(By.name("doccontact")).sendKeys(map.get("editDoctorContact"));
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[. = ' Doctors ']")).click();
		driver.findElement(By.xpath("//span[. = ' Manage Doctors ']")).click();
		driver.findElement(By.xpath("(//i[@class = 'fa fa-times fa fa-white'])[last()]")).click();
		driver.switchTo().alert().accept();
		String deletedoctormessage = driver.findElement(By.xpath("//p[. = 'data deleted !!								']")).getText();
		if(deletedoctormessage.equals(map.get("deleteDoctorMessage")))
		{
			System.out.println("Doctor Deleted");
		}
		else
		{
			System.out.println("Doctor not Deleted");
		}
		driver.quit();
	}

}
