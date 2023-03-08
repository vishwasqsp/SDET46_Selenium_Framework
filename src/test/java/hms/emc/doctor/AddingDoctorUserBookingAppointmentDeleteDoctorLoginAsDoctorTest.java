package hms.emc.doctor;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.cj.conf.PropertyKey;
import com.tyss.genericUtilities.FrameworkConstant;
import com.tyss.genericUtilities.JavaUtility;
import com.tyss.genericUtilities.VerificationUtility;
import com.tyss.genericUtilities.Enums.ExcelSheet;
import com.tyss.genericUtilities.Enums.PropertyKeys;
import com.tyss.genericUtilities.WebActions.DropdownUtility;
import com.tyss.genericUtilities.WebActions.PopupUtility;
import com.tyss.genericUtilities.WebActions.SeleniumUtility;
import com.tyss.genericUtilities.WebActions.WaitUtility;
import com.tyss.genericUtilities.externalFileUtility.Excelutility;
import com.tyss.genericUtilities.externalFileUtility.PropertyUtility;

import HomePage.HomePage;
import hms.eMedCure.ObjectRepository.AdminDasboardTabNames;
import hms.eMedCure.ObjectRepository.Admin.AddDoctor;
import hms.eMedCure.ObjectRepository.Admin.AddDoctorSpecialization;
import hms.eMedCure.ObjectRepository.Admin.AdminDashboard;
import hms.eMedCure.ObjectRepository.Admin.AdminLogin;
import hms.eMedCure.ObjectRepository.Admin.AdminLogoutPage;
import hms.eMedCure.ObjectRepository.Admin.ManageDoctorPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorLoginPage;
import hms.eMedCure.ObjectRepository.User.BookAppointmentPage;
import hms.eMedCure.ObjectRepository.User.UserLoginPage;
import hms.eMedCure.ObjectRepository.User.UserLogoutPage;
import hms.eMedCure.ObjectRepository.User.userDashboardPage;
import hms.eMedCure.ObjectRepository.User.userDashboardTabnames;


public class AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest {

	public static void main(String[] args) throws IOException {

		PropertyUtility propertyutility = new PropertyUtility(FrameworkConstant.TEST_PROPERTY_FILE_PATH);
		Excelutility excelutility = new Excelutility(FrameworkConstant.TEST_EXCEL_FILE_PATH);
		SeleniumUtility seleniumutility = new SeleniumUtility();
		JavaUtility javautility = new JavaUtility();
		VerificationUtility verificationutility = new VerificationUtility();
		DropdownUtility dropdown = new DropdownUtility();


		//common data
		String browser = propertyutility.getPropertyData(PropertyKeys.BROWSER);
		long timeout = Long.parseLong(propertyutility.getPropertyData(PropertyKeys.TIMEUNIT));
		String url = propertyutility.getPropertyData(PropertyKeys.URL);
		String adminusername = javautility.decode(propertyutility.getPropertyData(PropertyKeys.ADMINUSERNAME));
		String adminpassword = javautility.decode(propertyutility.getPropertyData(PropertyKeys.ADMINPASSWORD));
		String userusername = propertyutility.getPropertyData(PropertyKeys.USERUSERNAME);
		String userpassword = propertyutility.getPropertyData(PropertyKeys.USERPASSWORD);
		String doctorusername = propertyutility.getPropertyData(PropertyKeys.DOCTORUSERNAME);
		String doctorpassword = propertyutility.getPropertyData(PropertyKeys.DOCTORPASSWORD);



		
		
		
		//verification data
		String homepagenametextverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "homePageName");
		String admindashboardverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "adminDashboard");
		String adddoctorspecialisationverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "addDoctorSpecialisation");
		String specialisationconfirmationverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "addingDoctorSpecialisation");
		String managedoctorspageverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "manageDoctorsPage");
		String userDashBoardverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "userDashBoard");
		String bookappointmentpageverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "bookAppointmentPage");
		String deletedoctormessageverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "deleteDoctorMessage");
		String doctorloginpageverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "doctorLoginPage");
		String doctorloginerrormessageverify = excelutility.getData("Verification", "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest", "loginErrorMessage");
		

		//to fetch data from excel
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest");
		
		
		String sheetNames = ExcelSheet.VERIFICATION.getSheetName();
		Map<String, String> maps = excelutility.getData(sheetNames, "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest");
		
		
		//launching application and passing url
		WebDriver driver = seleniumutility.launchBrowser(browser);
		seleniumutility.maximizeBrowser();
		WaitUtility waitutility = new WaitUtility(driver, timeout);
		waitutility.WaitForElementTOLoad(driver, timeout);
		seleniumutility.applicationUrl(url);
		
		HomePage homepage = new HomePage(driver);
		AdminDashboard admindashboard = new AdminDashboard(driver);
		AddDoctorSpecialization adddoctorspecialisation = new AddDoctorSpecialization(driver);
		AddDoctor adddoctor = new AddDoctor(driver);
		AdminLogin adminlogin = new AdminLogin(driver);
		PopupUtility popuputility = new PopupUtility();
		AdminLogoutPage adminlogoutpage = new AdminLogoutPage(driver);
		UserLoginPage userloginpage = new UserLoginPage(driver);
		userDashboardPage userdashboardpage = new userDashboardPage(driver);
		BookAppointmentPage bookappointmentpage = new BookAppointmentPage(driver);
		UserLogoutPage userlogoutpage = new UserLogoutPage(driver);
		ManageDoctorPage managedoctorpage = new ManageDoctorPage(driver);
		DoctorLoginPage doctorloginpage = new DoctorLoginPage(driver);
		
		
		
		homepage.adminLoginClick();
		
		//admin login page
		adminlogin.AdminLoginAction(adminusername, adminpassword);
		verificationutility.partialVerify(admindashboard.adminDashboardVerification(), maps.get("adminDashboard"));

		
		
		
		//click on Doctor
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORSPECIALIZATION);
		adddoctorspecialisation.AddDoctorSpecialization(map.get("doctorSpecialisation"));

		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.ADDDOCTOR);
		String doctoremail = map.get("doctorEmail")+javautility.getRandomNumber(100)+"@gmail.com";
		adddoctor.AddDoctorAction(dropdown, map.get("doctorSpecialisation"), map.get("doctorName"), map.get("doctorAddress"), map.get("doctorFees"), map.get("doctorContact"), doctoremail, map.get("doctorPassword"), map.get("doctorConfirmPassword"));	
		popuputility.acceptAlert(driver);
		
		adminlogoutpage.AdminLogoutAction();
		
		homepage.userLoginClick();
		
		userloginpage.userLoginAction(userusername, userpassword);
		userdashboardpage.clickUserDashboardTab(userDashboardTabnames.BOOKAPPOINTMENT);
		
		bookappointmentpage.BookAppointmentAction(dropdown, map.get("doctorSpecialisation"), 1);
		popuputility.acceptAlert(driver);
		
		userlogoutpage.UserLogoutAction();

		homepage.adminLoginClick();
		adminlogin.AdminLoginAction(adminusername, adminpassword);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.MANAGEDOCTORS);
		managedoctorpage.deleteDoctorAction();
		popuputility.acceptAlert(driver);
		
		adminlogoutpage.AdminLogoutAction();
		
		homepage.doctorLoginClick();
		doctorloginpage.DoctorLoginAction(doctoremail, doctorpassword);
		

		String loginerrormessage = driver.findElement(By.xpath("//span[. = 'Invalid username or password']")).getText();

		verificationutility.exactVerify(loginerrormessage, doctorloginerrormessageverify);
		seleniumutility.closeBrowser();
	}

}
