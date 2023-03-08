package hms.emc.admin;





import java.util.Map;
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
import hms.eMedCure.ObjectRepository.AdminDasboardTabNames;
import hms.eMedCure.ObjectRepository.Admin.AddDoctor;
import hms.eMedCure.ObjectRepository.Admin.AddDoctorSpecialization;
import hms.eMedCure.ObjectRepository.Admin.AdminDashboard;
import hms.eMedCure.ObjectRepository.Admin.AdminLogin;
import hms.eMedCure.ObjectRepository.Admin.AdminLogoutPage;
import hms.eMedCure.ObjectRepository.Admin.EditDoctor;
import hms.eMedCure.ObjectRepository.Admin.ManageDoctorPage;



public class AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest {

	public static void main(String[] args) {
		PropertyUtility propertyutility = new PropertyUtility(FrameworkConstant.TEST_PROPERTY_FILE_PATH);
		Excelutility excelutility = new Excelutility(FrameworkConstant.TEST_EXCEL_FILE_PATH);
		SeleniumUtility seleniumutility = new SeleniumUtility();
		JavaUtility javautility = new JavaUtility();
		VerificationUtility verificationutility = new VerificationUtility();
		DropdownUtility dropdown = new DropdownUtility();
		PopupUtility poputility = new PopupUtility();
		
		
		//common data
		String browser = propertyutility.getPropertyData(PropertyKeys.BROWSER);
		long timeout = Long.parseLong(propertyutility.getPropertyData(PropertyKeys.TIMEUNIT));
		String url = propertyutility.getPropertyData(PropertyKeys.URL);
		String adminusername = javautility.decode(propertyutility.getPropertyData(PropertyKeys.ADMINUSERNAME));
		String adminpassword = javautility.decode(propertyutility.getPropertyData(PropertyKeys.ADMINPASSWORD));
		
		
		
		//to fetch data from excel
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest");
		
		
		//launching application and passing url
		WebDriver driver = seleniumutility.launchBrowser(browser);
		AddDoctorSpecialization adddoctorspecialization = new AddDoctorSpecialization(driver);
		AdminLogin adminLogin = new AdminLogin(driver);
		WaitUtility waitutility = new WaitUtility(driver, timeout);
		
		
		HomePage homepage = new HomePage(driver);
		AdminDashboard admindashboard = new AdminDashboard(driver);
		AddDoctorSpecialization adddoctorspecialisation = new AddDoctorSpecialization(driver);
		AddDoctor adddoctor = new AddDoctor(driver);
		EditDoctor editdoctor = new EditDoctor(driver);
		ManageDoctorPage managedoctorpage = new ManageDoctorPage(driver);
		AdminLogoutPage adminlogoutpage = new AdminLogoutPage(driver);
		
		
		seleniumutility.maximizeBrowser();
		waitutility.WaitForElementTOLoad(driver, timeout);
		seleniumutility.applicationUrl(url);
		
		
		
		//application homepage
//		String homepageName = homepage.homePage("homepagename");
//		verificationutility.exactVerify(homepageName, homepagenametextverify);
		homepage.adminLoginClick();
		
		//admin login page
		adminLogin.AdminLoginAction(adminusername, adminpassword);
		
		
		
//		//click on Doctor
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORSPECIALIZATION);
		adddoctorspecialisation.AddDoctorSpecialization(map.get("doctorSpecialisation"));

	
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.ADDDOCTOR);
		String doctoremail = map.get("doctorEmail")+javautility.getRandomNumber(100)+"@gmail.com";
		adddoctor.AddDoctorAction(dropdown, map.get("doctorSpecialisation"), map.get("doctorName"), map.get("doctorAddress"), map.get("doctorFees"), map.get("doctorContact"), doctoremail, map.get("doctorPassword"), map.get("doctorConfirmPassword"));	
		poputility.acceptAlert(driver);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.MANAGEDOCTORS);
		managedoctorpage.editDoctorAction();
		editdoctor.EditDoctorAction(map.get("editDoctorName"), map.get("editDoctorFees"), map.get("editDoctorAddress"), map.get("editDoctorContact"));
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.MANAGEDOCTORS);
		managedoctorpage.deleteDoctorAction();
		poputility.acceptAlert(driver);
		adminlogoutpage.AdminLogoutAction();
	}
		
}
