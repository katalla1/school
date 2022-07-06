package testingtheGUI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Project {
	
	static LinkedList<Deliverable> deliverables = new LinkedList<>() ; 
	static LinkedList<Task> tasks = new LinkedList<>();
	static LinkedList<ActionItem> actionItems = new LinkedList<>();
	static LinkedList<Issue> issues = new LinkedList<>();
	static LinkedList<Resource> resources = new LinkedList<>();
	
	public static void load() throws ClassNotFoundException {
		try {
	         FileInputStream fileIn = new FileInputStream("projectdata.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Integer delivarablecount = (Integer) in.readObject();
	         for(int i = 0; i < delivarablecount;i++ ) {
	        	 deliverables.add((Deliverable) in.readObject());
	         }
	         Integer taskcount = (Integer) in.readObject();
	         for(int i = 0; i < taskcount;i++ ) {
	        	 tasks.add((Task) in.readObject());
	         }
	         Integer resourcecount = (Integer) in.readObject();
	         for(int i = 0; i < resourcecount;i++ ) {
	        	 resources.add((Resource) in.readObject());
	         }          
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      }
		
		
		
	}
	public static void save() {
		
		 try {
	         FileOutputStream fileOut = new FileOutputStream("projectdata.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         Integer delivarablecount = deliverables.size();
	         Integer taskcount = tasks.size();   
	         Integer resourcecount = resources.size();
	         out.writeObject(delivarablecount);	         
	         for(int i = 0; i < delivarablecount;i++ ) {
	        	 out.writeObject(deliverables.get(i));
	         }
	         out.writeObject(taskcount);	 
	         for(int i = 0; i < taskcount;i++ ) {
	        	 out.writeObject(tasks.get(i));
	         }
	         out.writeObject(resourcecount);
	         for(int i = 0; i < resourcecount;i++ ) {
	        	 out.writeObject(resources.get(i));
	         }
	         
	         
	         out.close();
	         fileOut.close();
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	// use this as the master database
	//save and write to file methods can go here 
	//retrieve from file should here as well, use the linked list to store all the data
		
}
