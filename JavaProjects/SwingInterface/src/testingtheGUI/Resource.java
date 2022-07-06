package testingtheGUI;

public class Resource implements java.io.Serializable{
	
	String unique_ID;
	String resource_name;
	String hourly_rate;
	String skills;
	String dates_available;
	String job_title;
	public String getUnique_ID() {
		return unique_ID;
	}
	public void setUnique_ID(String unique_ID) {
		this.unique_ID = unique_ID;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getHourly_rate() {
		return hourly_rate;
	}
	public void setHourly_rate(String hourly_rate) {
		this.hourly_rate = hourly_rate;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getDates_available() {
		return dates_available;
	}
	public void setDates_available(String dates_available) {
		this.dates_available = dates_available;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	@Override
	public String toString() {
		return "Resource: " + unique_ID + ", Name: " + resource_name + ", Job Title: " + job_title;
				
	}
	
}
