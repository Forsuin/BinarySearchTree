package itec220.labs;

import java.util.HashMap;

public enum EmployeeType {
	DATA_OPERATIONS_DIRECTOR("Data Operations Director"),
	INFORMATION_TECHNOLOGY_DIRECTOR("Information Technology Director"),
	CORPORATE_ATTORNEY("Corporate Attorney"),
	JUNIOR_SOFTWARE_DEVELOPER("Junior Software Developer"),
	MAINFRAME_PROGRAMMER("Mainframe Programmer"),
	CHIEF_TECHNOLOGY_OFFICER("Chief Technology Officer"),
	DATABASE_SECURITY_ADMINISTRATOR("Database Security Administrator"),
	INFORMATION_TECHNOLOGY_SYSTEMS_DIRECTOR("Information Technology Systems Director"),
	DATABASE_ADMINISTRATION_MANAGER("Database Administration Manager"),
	INFORMATION_SYSTEMS_DIRECTOR("Information Systems Director"),
	APPLICATION_DEVELOPMENT_DIRECTOR("Application Development Director"),
	DATABASE_MANAGEMENT_SYSTEM_SPECIALIST("Database Management System Specialist"),
	APPLICATIONS_PROGRAMMER("Applications Programmer"),
	DATABASE_COORDINATOR("Database Coordinator"),
	DATA_PROCESSING_MANAGER("Data Processing Manager"),
	CORPORATE_COUNSELOR("Corporate Counselor"),
	MIS_DIRECTOR("MIS Director"),
	DBMS_SPECIALIST("DBMS Specialist"),
	COMPUTER_PROGRAMMER("Computer Programmer"),
	INFORMATION_SYSTEMS_MANAGER("Information Systems Manager"),
	SYSTEMS_PROGRAMMER("Systems Programmer"),
	COMPUTER_OPERATIONS_MANAGER("Computer Operations Manager"),
	COMPUTER_LANGUAGE_CODER("Computer Language Coder"),
	CORPORATE_COUNSEL("Corporate Counsel"),
	COMPUTER_SECURITY_MANAGER("Computer Security Manager"),
	MANAGEMENT_INFORMATION_SYSTEMS_DIRECTOR("Management Information Systems Director"),
	INTERNET_TECHNOLOGY_MANAGER("Internet Technology Manager"),
	QUALITY_CONTROL_EXPERT("Quality Control Expert");
	
	public final String text; 
	EmployeeType(String name) {
		this.text = name;
		
	}
	private static HashMap<String, EmployeeType> types =  initializeMapping();
	
	private static HashMap<String, EmployeeType> initializeMapping() {
		HashMap<String, EmployeeType> map = new HashMap<String, EmployeeType>();
	    for (EmployeeType s : EmployeeType.values()) {
	        map.put(s.text, s);
	    }
	    return map;
	}
	public static EmployeeType getType(String name)
	{
		return types.get(name);
	}


}
