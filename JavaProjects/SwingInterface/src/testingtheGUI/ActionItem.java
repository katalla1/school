package testingtheGUI;

import java.util.LinkedList;

public class ActionItem {
	
	String unique_ID;
	String description;
	String date_created;
	String date_assigned;
	LinkedList<String> resources_assigned;
	String expected_completion;
	String actual_complietion_date;
	boolean status;
	String status_description;
	String expected_date;
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
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	public String getDate_assigned() {
		return date_assigned;
	}
	public void setDate_assigned(String date_assigned) {
		this.date_assigned = date_assigned;
	}
	public String getExpected_completion() {
		return expected_completion;
	}
	public void setExpected_completion(String expected_completion) {
		this.expected_completion = expected_completion;
	}
	public String getActual_complietion_date() {
		return actual_complietion_date;
	}
	public void setActual_complietion_date(String actual_complietion_date) {
		this.actual_complietion_date = actual_complietion_date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStatus_description() {
		return status_description;
	}
	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}
	public String getExpected_date() {
		return expected_date;
	}
	public void setExpected_date(String expected_date) {
		this.expected_date = expected_date;
	}
	
}
