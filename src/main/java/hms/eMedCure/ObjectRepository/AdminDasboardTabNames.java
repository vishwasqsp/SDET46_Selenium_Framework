package hms.eMedCure.ObjectRepository;

public enum AdminDasboardTabNames 
{
	DASHBOARD(" Dashboard "),
	DOCTORS(" Doctors "),
	DOCTORSPECIALIZATION(" Doctor Specialization "),
	ADDDOCTOR(" Add Doctor"),
	MANAGEDOCTORS(" Manage Doctors "),
	USERS(" Users "),
	MANAGEUSERS(" Manage Users "),
	PATIENTS(" Patients "),
	MANAGEPATIENTS(" Manage Patients "),
	APPOINTMENTHISTORY(" Appointment History "),
	MANAGEQUERIES(" Conatctus Queries "),
	READQUERIES(" Read Query "),
	UNREADQUERIES(" Unread Query "),
	DOCTORSESSIONLOGS(" Doctor Session Logs "),
	USERSESSIONLOGS(" User Session Logs "),
	REPORTS(" Reports "),
	BETWEENDATEREPORTS("B/w dates reports "),
	PATIENTSEARCH(" Patient Search ");
	
	
	private String tabName;
	
	private AdminDasboardTabNames(String tabName) {
		this.tabName=tabName;
	}
	
	public String getTab()
	{
		return tabName;
	}
}
