package testingtheGUI;

import java.util.LinkedList;

public class Deliverable implements java.io.Serializable {
	
	String description;
	String name;
	String dueDate;
	String uniqueID;
	LinkedList<String> associated_Tasks = new LinkedList<>();
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public LinkedList<String> getAssociated_Tasks() {
		return associated_Tasks;
	}
	public void setAssociated_Tasks(LinkedList<String> associated_Tasks) {
		this.associated_Tasks = associated_Tasks;
	}
	@Override
	public String toString() {
		return "Deliverable " + uniqueID + ", Name:" + name + ", Due Date: " + dueDate ;
	}
	
		
}
