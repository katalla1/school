package testingtheGUI;

import java.util.LinkedList;

public class Task implements java.io.Serializable{
	boolean associated;
	String name;
	String description;
	String uniqueID;
	String task_completion_percentage;
	String actual_effort;
	String expected_duration;
	String actual_duration;
	String expected_effort;
	String effortCompleted;
	String expected_start;
	String expected_end;
	String actual_start;
	String actual_end;
	LinkedList<String> associated_issues;
	LinkedList<String> resources_assigned;
	LinkedList<String> predessesor_tasks;
	LinkedList<String> successor_tasks;
	public boolean isAssociated() {
		return associated;
	}
	public void setAssociated(boolean associated) {
		this.associated = associated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getActual_effort() {
		return actual_effort;
	}
	public void setActual_effort(String actual_effort) {
		this.actual_effort = actual_effort;
	}
	public String getExpected_duration() {
		return expected_duration;
	}
	public void setExpected_duration(String expected_duration) {
		this.expected_duration = expected_duration;
	}
	public String getActual_duration() {
		return actual_duration;
	}
	public void setActual_duration(String actual_duration) {
		this.actual_duration = actual_duration;
	}
	public String getExpected_effort() {
		return expected_effort;
	}
	public void setExpected_effort(String expected_effort) {
		this.expected_effort = expected_effort;
	}
	public String getExpected_start() {
		return expected_start;
	}
	public void setExpected_start(String expected_start) {
		this.expected_start = expected_start;
	}
	public String getExpected_end() {
		return expected_end;
	}
	public void setExpected_end(String expected_end) {
		this.expected_end = expected_end;
	}
	public String getActual_start() {
		return actual_start;
	}
	public void setActual_start(String actual_start) {
		this.actual_start = actual_start;
	}
	public String getActual_end() {
		return actual_end;
	}
	public void setActual_end(String actual_end) {
		this.actual_end = actual_end;
	}
	@Override
	public String toString() {
		return "Task " + uniqueID + " Name: " + name +  ", Percent Complete: " + task_completion_percentage + "%, " + " Expected End Date: " + expected_end;
	}
		
}
