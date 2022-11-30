package itec220.labs;

public class Employee implements Comparable<Employee>{
	
	private String firstName;
	private String lastName;
	private EmployeeType title;
	private String ID;
	private String level;
	public static final String IDformatter = "%010d";
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return title.text;
	}
	public EmployeeType getType() {
		return title;
	}

	public String getID() {
		return ID;
	}

	public String getLevel() {
		return level;
	}

	public Employee(String firstName, String lastName, String title, String iD, String level) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = EmployeeType.getType(title);
		ID = iD;
		this.level = level;
	}

	@Override
	public String toString() {
		return   String.format("%-15s %-15s %-40s %5s %5s ", firstName ,lastName, title.text, level, ID);
	}

	@Override
	public int compareTo(Employee o) {
		
		return this.ID.compareTo(o.ID);
	}

	
	
	

}
