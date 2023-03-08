package hms.emc.patient;


import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



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
import hms.eMedCure.ObjectRepository.Doctor.AppointmentHistoryPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorDashboardPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorDashboardTabNames;
import hms.eMedCure.ObjectRepository.Doctor.DoctorLoginPage;
import hms.eMedCure.ObjectRepository.User.BookAppointmentPage;
import hms.eMedCure.ObjectRepository.User.PatientRegistrationPage;
import hms.eMedCure.ObjectRepository.User.UserLoginPage;
import hms.eMedCure.ObjectRepository.User.UserLogoutPage;
import hms.eMedCure.ObjectRepository.User.userDashboardPage;
import hms.eMedCure.ObjectRepository.User.userDashboardTabnames;



public class UserRegistrationBookingAppointmentDoctorCancellingAppointmentTest {

	public static void main(String[] args) throws IOException 
	{

		PropertyUtility propertyutility = new PropertyUtility(FrameworkConstant.TEST_PROPERTY_FILE_PATH);
		Excelutility excelutility = new Excelutility(FrameworkConstant.TEST_EXCEL_FILE_PATH);
		SeleniumUtility seleniumutility = new SeleniumUtility();
		VerificationUtility verificationutility = new VerificationUtility();
		DropdownUtility dropdown = new DropdownUtility();
		JavaUtility javautility = new JavaUtility();


		//common data
		String browser = propertyutility.getPropertyData(PropertyKeys.BROWSER);
		long timeout = Long.parseLong(propertyutility.getPropertyData(PropertyKeys.TIMEUNIT));
		String url = propertyutility.getPropertyData(PropertyKeys.URL);
		String userusername = propertyutility.getPropertyData(PropertyKeys.USERUSERNAME);
		String userpassword = propertyutility.getPropertyData(PropertyKeys.USERPASSWORD);
		String doctorusername = propertyutility.getPropertyData(PropertyKeys.DOCTORUSERNAME);
		String doctorpassword = propertyutility.getPropertyData(PropertyKeys.DOCTORPASSWORD);


		//launching application and passing url
		WebDriver driver = seleniumutility.launchBrowser(browser);
		seleniumutility.maximizeBrowser();
		WaitUtility wu = new WaitUtility(driver, timeout);
		wu.WaitForElementTOLoad(driver, timeout);
		seleniumutility.applicationUrl(url);
		
		
		
		HomePage homepage = new HomePage(driver);
		UserLoginPage userloginpage = new UserLoginPage(driver);
		PatientRegistrationPage patientregistrationpage = new PatientRegistrationPage(driver);
		PopupUtility popuputility = new PopupUtility();
		BookAppointmentPage bookappointment = new BookAppointmentPage(driver);
		UserLogoutPage userlogoutpage = new UserLogoutPage(driver);
		DoctorLoginPage doctorloginpage = new DoctorLoginPage(driver);
		DoctorDashboardPage doctordashboardpage = new DoctorDashboardPage(driver);
		AppointmentHistoryPage appointmenthistorypage = new AppointmentHistoryPage(driver);
		userDashboardPage userdashboardpage = new userDashboardPage(driver);
		
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "UserBookingAppointmentDoctorCancellingAppointmentTest1");
		//application homepage
		String homepagename = driver.findElement(By.xpath("//a[. = 'Hospital Management system']")).getText();
		verificationutility.exactVerify(homepagename, map.get("homePageName"));
		
		
		
		
		homepage.userLoginClick();
		userloginpage.createAnAccountAction();
		String usermailid = map.get("email")+javautility.getRandomNumber(100)+"@gmail.com";
		patientregistrationpage.patientRegistrationAction(excelutility.getData("TestData", "UserBookingAppointmentDoctorCancellingAppointmentTest"), usermailid);
		popuputility.acceptAlert(driver);
		patientregistrationpage.patientLogin();
		userloginpage.userLoginAction(userusername, userpassword);
		userdashboardpage.clickUserDashboardTab(userDashboardTabnames.BOOKAPPOINTMENT);
		bookappointment.BookAppointmentAction(dropdown, map.get("doctorSpecialisation"), 1);
		popuputility.acceptAlert(driver);
		userlogoutpage.UserLogoutAction();
		homepage.doctorLoginClick();
		doctorloginpage.DoctorLoginAction(doctorusername, doctorpassword);		
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.APPOINTMENTHISTORY);
		appointmenthistorypage.cancelAppointmentAction();
		popuputility.acceptAlert(driver);
		seleniumutility.closeBrowser();
		
	}
}
