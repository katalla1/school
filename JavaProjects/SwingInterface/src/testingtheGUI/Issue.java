package testingtheGUI;

import java.util.LinkedList;

public class Issue {
	
	String unique_ID;
	String description;
	int priority;
	int severity;
	String date_raised;
	String date_assigned;
	String expected_end_date;
	String actual_end_date;
	boolean status;
	String status_description;
	String update_date;
	LinkedList<String> associated_actionitems;
	public String getUnique_ID() {
		return unique_ID;
	}
	public void setUnique_ID(String unique_ID) {
		this.unique_ID = unique_ID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_raised() {
		return date_raised;
	}
	public void setDate_raised(String date_raised) {
		this.date_raised = date_raised;
	}
	public String getDate_assigned() {
		return date_assigned;
	}
	public void setDate_assigned(String date_assigned) {
		this.date_assigned = date_assigned;
	}
	public String getExpected_end_date() {
		return expected_end_date;
	}
	public void setExpected_end_date(String expected_end_date) {
		this.expected_end_date = expected_end_date;
	}
	public String getActual_end_date() {
		return actual_end_date;
	}
	public void setActual_end_date(String actual_end_date) {
		this.actual_end_date = actual_end_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
}
