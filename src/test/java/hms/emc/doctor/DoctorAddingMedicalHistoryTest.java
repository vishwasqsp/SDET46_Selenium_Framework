package hms.emc.doctor;

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
import com.tyss.genericUtilities.WebActions.JavaScriptUtility;
import com.tyss.genericUtilities.WebActions.PopupUtility;
import com.tyss.genericUtilities.WebActions.SeleniumUtility;
import com.tyss.genericUtilities.WebActions.SwitchWindowUtility;
import com.tyss.genericUtilities.WebActions.WaitUtility;
import com.tyss.genericUtilities.externalFileUtility.Excelutility;
import com.tyss.genericUtilities.externalFileUtility.PropertyUtility;

import HomePage.HomePage;
import hms.eMedCure.ObjectRepository.Doctor.AddMedicalHistoryPage;
import hms.eMedCure.ObjectRepository.Doctor.AddPatientPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorDashboardPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorDashboardTabNames;
import hms.eMedCure.ObjectRepository.Doctor.DoctorLoginPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorLogoutPage;
import hms.eMedCure.ObjectRepository.Doctor.ManagePatientPage;



public class DoctorAddingMedicalHistoryTest {

	public static void main(String[] args) throws IOException {
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
		String doctorusername = propertyutility.getPropertyData(PropertyKeys.DOCTORUSERNAME);
		String doctorpassword = propertyutility.getPropertyData(PropertyKeys.DOCTORPASSWORD);

		//test data
		String expecteduser = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "ExpectedUser");
		String patientname = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "patientName");
		String patientcontact = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "patientContact");
		//String patientemail = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "patientEmail");
		String patientaddress = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "patientAddress");
		String patientage = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "patientAge");
		String medicalhistory = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "medicalHistory");
		String bp = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "bp");
		String sugar = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "sugar");
		String weight = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "weight");
		String temperature = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "temperature");
		String prescription = excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest", "prescription");



		//verification data
		String homepagenametextverify = excelutility.getData("Verification", "DoctorAddingMedicalHistoryTest", "homePageName");
		String doctorloginpageverify = excelutility.getData("Verification", "DoctorAddingMedicalHistoryTest", "doctorLoginPage");
		String doctordashboardverify = excelutility.getData("Verification", "DoctorAddingMedicalHistoryTest", "doctorDashboard");
		String doctorappointmenthistorypageverify = excelutility.getData("Verification", "DoctorAddingMedicalHistoryTest", "doctorAppointmentHistotry");
		String appointmentstatusconfirmationverify = excelutility.getData("Verification", "DoctorAddingMedicalHistoryTest", "status");
		String addpatientpageverify = excelutility.getData("Verification", "DoctorAddingMedicalHistoryTest", "addPatientPage");
		String managepatientpageverify = excelutility.getData("Verification", "DoctorAddingMedicalHistoryTest", "managePatientPage");

		//launching application and passing url
		WebDriver driver = seleniumutility.launchBrowser(browser);
		seleniumutility.maximizeBrowser();
		WaitUtility waitutility = new WaitUtility(driver, timeout);
		waitutility.WaitForElementTOLoad(driver, timeout);
		seleniumutility.applicationUrl(url);
		PopupUtility poputility = new PopupUtility();
		DoctorLogoutPage doctorlogoutpage = new DoctorLogoutPage(driver);
		JavaScriptUtility javascriptutility = new JavaScriptUtility(driver);
		
		HomePage homepage = new HomePage(driver);
		DoctorLoginPage doctorloginpage = new DoctorLoginPage(driver);
		DoctorDashboardPage doctordashboardpage = new DoctorDashboardPage(driver);
		AddPatientPage addpatientpage = new AddPatientPage(driver);
		ManagePatientPage managepatientpage = new ManagePatientPage(driver);
		AddMedicalHistoryPage addmedicalhistorypage = new AddMedicalHistoryPage(driver);
		SwitchWindowUtility switchwindowutility = new SwitchWindowUtility();
		
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest");
		
		
		
		homepage.doctorLoginClick();
		doctorloginpage.DoctorLoginAction(doctorusername, doctorpassword);
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.APPOINTMENTHISTORY);
		String name = driver.findElement(By.xpath("//td[. = 'harshitha']")).getText();
		String ExpectedUser = expecteduser;
		if(name.contains(ExpectedUser))
		{
			System.out.println("User Booked an Appointment");
		}
		else
		{
			System.out.println("User not Booked an Appointment");
		}
		
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.PATIENTS);
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.ADDPATIENT);
		String patientemail = map.get("patemail")+javautility.getRandomNumber(100)+"@gmail.com";
		addpatientpage.addPatientAction(excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest1"), patientemail);
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.PATIENTS);
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.MANAGEPATIENTS);
		managepatientpage.viewPatientAction();
		managepatientpage.addMedicalHistoryAction();
		addmedicalhistorypage.addMedicalHistoryAction(excelutility.getData("TestData", "PatientMedicalHistory"));
		poputility.acceptAlert(driver);
		doctorlogoutpage.doctorLogoutAction();
	

		seleniumutility.closeBrowser();


	}

}
