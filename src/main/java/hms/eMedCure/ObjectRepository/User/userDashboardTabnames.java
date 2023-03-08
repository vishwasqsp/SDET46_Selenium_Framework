package hms.eMedCure.ObjectRepository.User;

public enum userDashboardTabnames 
{
	DASHBOARD(" Dashboard "),
	BOOKAPPOINTMENT(" Book Appointment "),
	APPOINTMENTHISTORY(" Appointment History "),
	MEDICALHISTORY(" Medical History ");
	
	private String tabNames;
	
	private userDashboardTabnames(String tabName) {
		this.tabNames=tabName;
	}
	
	public String getTab()
	{
		return tabNames;
	}
}
