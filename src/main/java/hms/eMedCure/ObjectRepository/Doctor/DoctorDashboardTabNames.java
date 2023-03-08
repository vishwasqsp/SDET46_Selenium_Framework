package hms.eMedCure.ObjectRepository.Doctor;

public enum DoctorDashboardTabNames 
{
	DASHBOARD(" Dashboard "),
	PATIENTS(" Patients "),
	APPOINTMENTHISTORY(" Appointment History "),
	SEARCH(" Search "),
	ADDPATIENT(" Add Patient"),
	MANAGEPATIENTS(" Manage Patient ");
	
	private String tabNames;
	
	private DoctorDashboardTabNames(String tabName) {
		this.tabNames=tabName;
	}
	
	public String getTab()
	{
		return tabNames;
	}
}
