package testingtheGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tasks_popup {

	JFrame frame;
	private JTextField taskName;
	private JTextField taskID;
	private JTextField effortCompleted;
	private JTextField actualEffort;
	private JTextField taskCompletion;
	private JTextField actualDuration;
	private JTextField expectedStart;
	private JTextField expectedEnd;
	private JTextField expectedDuration;
	private JTextField expectedEffort;
	private JTextField actualStart;
	private JTextField actualEnd;
	private String ttID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tasks_popup window = new Tasks_popup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tasks_popup() {
		this.ttID = "new";
		initialize();
		
	}
	public Tasks_popup(String tID) {
		this.ttID = tID;
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.CYAN);
		frame.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 16));
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1040, 720);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTextArea taskDescription = new JTextArea();
		taskDescription.setBounds(39, 205, 314, 124);
		frame.getContentPane().add(taskDescription);
		//***************************************************************************************************BeginLabels
		JLabel lblCreateeditTasks = new JLabel("Create/Edit Tasks");
		lblCreateeditTasks.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCreateeditTasks.setForeground(Color.CYAN);
		lblCreateeditTasks.setBounds(413, 13, 162, 31);
		frame.getContentPane().add(lblCreateeditTasks);
		
		JLabel lblTaskName = new JLabel("Task Name");
		lblTaskName.setForeground(Color.CYAN);
		lblTaskName.setBounds(39, 117, 154, 31);
		frame.getContentPane().add(lblTaskName);
		
		JLabel lblTaskDescription = new JLabel("Task Description");
		lblTaskDescription.setForeground(Color.CYAN);
		lblTaskDescription.setBounds(39, 174, 154, 31);
		frame.getContentPane().add(lblTaskDescription);
		
		JLabel lblResourceAssigned = new JLabel("Resource Assigned");
		lblResourceAssigned.setForeground(Color.CYAN);
		lblResourceAssigned.setBounds(39, 323, 178, 39);
		frame.getContentPane().add(lblResourceAssigned);
		
		JLabel lblTaskId = new JLabel("Task ID");
		lblTaskId.setForeground(Color.CYAN);
		lblTaskId.setBounds(39, 63, 56, 16);
		frame.getContentPane().add(lblTaskId);
		
		JLabel lblEffortCompleted = new JLabel("Effort Completed");
		lblEffortCompleted.setForeground(Color.CYAN);
		lblEffortCompleted.setBounds(471, 63, 127, 31);
		frame.getContentPane().add(lblEffortCompleted);
		
		JLabel lblActualEffort = new JLabel("Actual Effort");
		lblActualEffort.setForeground(Color.CYAN);
		lblActualEffort.setBounds(651, 64, 97, 29);
		frame.getContentPane().add(lblActualEffort);
		
		JLabel lblTaskCompletion = new JLabel("Task Completion %");
		lblTaskCompletion.setForeground(Color.CYAN);
		lblTaskCompletion.setBounds(471, 142, 127, 16);
		frame.getContentPane().add(lblTaskCompletion);
		
		JLabel lblPredecessorTasks = new JLabel("Predecessor Tasks");
		lblPredecessorTasks.setForeground(Color.CYAN);
		lblPredecessorTasks.setBounds(471, 212, 127, 16);
		frame.getContentPane().add(lblPredecessorTasks);
		
		JLabel lblSuccessorTasks = new JLabel("Successor Tasks");
		lblSuccessorTasks.setForeground(Color.CYAN);
		lblSuccessorTasks.setBounds(471, 334, 127, 16);
		frame.getContentPane().add(lblSuccessorTasks);
		
		JLabel lblListOfIssues = new JLabel("List of Issues");
		lblListOfIssues.setForeground(Color.CYAN);
		lblListOfIssues.setBounds(471, 456, 104, 16);
		frame.getContentPane().add(lblListOfIssues);
		
		JLabel lblExpectedStartDate = new JLabel("Expected Start Date");
		lblExpectedStartDate.setForeground(Color.CYAN);
		lblExpectedStartDate.setBounds(39, 381, 139, 16);
		frame.getContentPane().add(lblExpectedStartDate);
		
		JLabel lblExpectedEffort = new JLabel("Expected Effort");
		lblExpectedEffort.setForeground(Color.CYAN);
		lblExpectedEffort.setBounds(190, 445, 148, 16);
		frame.getContentPane().add(lblExpectedEffort);
		
		JLabel lblExpectedDuration = new JLabel("Expected Duration");
		lblExpectedDuration.setForeground(Color.CYAN);
		lblExpectedDuration.setBounds(39, 445, 139, 16);
		frame.getContentPane().add(lblExpectedDuration);
		
		JLabel lblExpectedEndDate = new JLabel("Expected End Date");
		lblExpectedEndDate.setForeground(Color.CYAN);
		lblExpectedEndDate.setBounds(190, 381, 148, 16);
		frame.getContentPane().add(lblExpectedEndDate);
		
		JLabel lblActualStartDate = new JLabel("Actual Start Date");
		lblActualStartDate.setForeground(Color.CYAN);
		lblActualStartDate.setBounds(39, 515, 139, 16);
		frame.getContentPane().add(lblActualStartDate);
		
		JLabel lblActualEndDate = new JLabel("Actual End Date");
		lblActualEndDate.setForeground(Color.CYAN);
		lblActualEndDate.setBounds(190, 515, 148, 16);
		frame.getContentPane().add(lblActualEndDate);
		
		JLabel lblActualDuration = new JLabel("Actual Duration");
		lblActualDuration.setForeground(Color.CYAN);
		lblActualDuration.setBounds(39, 589, 154, 16);
		frame.getContentPane().add(lblActualDuration);
		//**********************************************************************************************************End Labels
		taskName = new JTextField();
		taskName.setBounds(39, 142, 314, 31);
		frame.getContentPane().add(taskName);
		taskName.setColumns(10);
		
		taskID = new JTextField();
		taskID.setBounds(39, 84, 139, 31);
		frame.getContentPane().add(taskID);
		taskID.setColumns(10);
		
		effortCompleted = new JTextField();
		effortCompleted.setBounds(471, 87, 116, 25);
		frame.getContentPane().add(effortCompleted);
		effortCompleted.setColumns(10);
		
		actualEffort = new JTextField();
		actualEffort.setColumns(10);
		actualEffort.setBounds(651, 88, 116, 25);
		frame.getContentPane().add(actualEffort);
			
		taskCompletion = new JTextField();
		taskCompletion.setBounds(471, 178, 296, 22);
		frame.getContentPane().add(taskCompletion);
		taskCompletion.setColumns(10);
		
		actualDuration = new JTextField();
		actualDuration.setBounds(39, 616, 314, 22);
		frame.getContentPane().add(actualDuration);
		actualDuration.setColumns(10);
		
		expectedStart = new JTextField();
		expectedStart.setBounds(39, 411, 116, 22);
		frame.getContentPane().add(expectedStart);
		expectedStart.setColumns(10);
		
		expectedEnd = new JTextField();
		expectedEnd.setColumns(10);
		expectedEnd.setBounds(190, 411, 116, 22);
		frame.getContentPane().add(expectedEnd);
		
		expectedDuration = new JTextField();
		expectedDuration.setColumns(10);
		expectedDuration.setBounds(39, 473, 116, 22);
		frame.getContentPane().add(expectedDuration);
		
		expectedEffort = new JTextField();
		expectedEffort.setColumns(10);
		expectedEffort.setBounds(190, 473, 116, 22);
		frame.getContentPane().add(expectedEffort);
		
		actualStart = new JTextField();
		actualStart.setColumns(10);
		actualStart.setBounds(39, 543, 116, 22);
		frame.getContentPane().add(actualStart);
		
		actualEnd = new JTextField();
		actualEnd.setColumns(10);
		actualEnd.setBounds(190, 543, 116, 22);
		frame.getContentPane().add(actualEnd);
		
		JCheckBox associated = new JCheckBox("Associated");
		associated.setForeground(Color.CYAN);
		associated.setBackground(Color.DARK_GRAY);
		associated.setBounds(208, 87, 113, 25);
		frame.getContentPane().add(associated);
		
		
			
		if(ttID.equals("new")) {///****************************if new item do this 
			
			taskID.setText(Integer.toString(Project.tasks.size()+1));
				
			}else { // else read item fields from linkedlist in main project
				
				taskDescription.setText(Project.tasks.get(Integer.parseInt(ttID)-1).description);
				taskName.setText(Project.tasks.get(Integer.parseInt(ttID)-1).name);
				taskID.setText(Project.tasks.get(Integer.parseInt(ttID)-1).uniqueID);
				effortCompleted.setText(Project.tasks.get(Integer.parseInt(ttID)-1).effortCompleted);
				actualEffort.setText(Project.tasks.get(Integer.parseInt(ttID)-1).actual_effort);
				taskCompletion.setText( Project.tasks.get(Integer.parseInt(ttID)-1).task_completion_percentage);
				actualDuration.setText(Project.tasks.get(Integer.parseInt(ttID)-1).actual_duration);
				expectedStart.setText(Project.tasks.get(Integer.parseInt(ttID)-1).expected_start);
				expectedEnd.setText(Project.tasks.get(Integer.parseInt(ttID)-1).expected_end);
				expectedDuration.setText(Project.tasks.get(Integer.parseInt(ttID)-1).expected_duration);
				expectedEffort.setText(Project.tasks.get(Integer.parseInt(ttID)-1).expected_effort);
				actualStart.setText(Project.tasks.get(Integer.parseInt(ttID)-1).actual_start);
				actualEnd.setText(Project.tasks.get(Integer.parseInt(ttID)-1).actual_end);					
				associated.setSelected(Project.tasks.get(Integer.parseInt(ttID)-1).associated);
											
			}
		
		//****************************************************************************************Begin buttons
		JButton btnSave = new JButton("save");
		btnSave.setBackground(Color.GREEN);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(ttID.equals("new")) {
					Task createdTask = new Task();
					createdTask.description = taskDescription.getText() ;
					createdTask.name = taskName.getText() ;
					createdTask.uniqueID = taskID.getText() ;
					createdTask.effortCompleted = effortCompleted.getText() ;
					createdTask.actual_effort = actualEffort.getText() ;
					if(expectedEffort.getText().equals("")||effortCompleted.getText().equals("")||expectedEffort.getText().equals(" ")||effortCompleted.getText().equals(" ")) {
						createdTask.task_completion_percentage = taskCompletion.getText() ;			
					}else {
						createdTask.task_completion_percentage = Integer.toString(100 * Integer.valueOf(effortCompleted.getText())/Integer.valueOf(expectedEffort.getText()));
					}
					createdTask.actual_duration = actualDuration.getText() ;
					createdTask.expected_start = expectedStart.getText() ;
					createdTask.expected_end = expectedEnd.getText() ;
					createdTask.expected_duration = expectedDuration.getText() ;
					createdTask.expected_effort = expectedEffort.getText() ;
					createdTask.actual_start = actualStart.getText() ;
					createdTask.actual_end = actualEnd.getText() ;
					createdTask.associated = associated.isSelected();									
					Project.tasks.add(createdTask);
					Mainpage.modelT.addElement(createdTask);
					
					frame.dispose();
				}else {
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).description = taskDescription.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).name = taskName.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).uniqueID = taskID.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).effortCompleted = effortCompleted.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).actual_effort = actualEffort.getText() ;
					
					if(expectedEffort.getText().equals("")||effortCompleted.getText().equals("")||expectedEffort.getText().equals(" ")||effortCompleted.getText().equals(" ")) {
						Project.tasks.get(Integer.parseInt(taskID.getText())-1).task_completion_percentage = taskCompletion.getText();					
					}else {
						Project.tasks.get(Integer.parseInt(taskID.getText())-1).task_completion_percentage = Integer.toString(100 * Integer.valueOf(effortCompleted.getText())/Integer.valueOf(expectedEffort.getText()));
					}
							
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).actual_duration = actualDuration.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).expected_start = expectedStart.getText()  ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).expected_end = expectedEnd.getText()  ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).expected_duration = expectedDuration.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).expected_effort = expectedEffort.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).actual_start = actualStart.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).actual_end = actualEnd.getText() ;
					Project.tasks.get(Integer.parseInt(taskID.getText())-1).associated = associated.isSelected();				
					
					
					
					frame.dispose();
				}				
			}
		});
		btnSave.setBounds(796, 585, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					if(ttID.equals("new")) {
					
				}else {
					Project.tasks.remove(Integer.parseInt(ttID)-1);
					Mainpage.modelT.removeElementAt(Integer.parseInt(ttID)-1);
					frame.dispose();
				}
				
				
				
			}
		});
		btnDelete.setBounds(661, 585, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JList list = new JList();
		list.setBounds(471, 239, 240, 90);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(471, 363, 240, 82);
		frame.getContentPane().add(list_1);
		
		JList list_1_1 = new JList();
		list_1_1.setBounds(471, 485, 240, 70);
		frame.getContentPane().add(list_1_1);
		
		JLabel availablepre = new JLabel("Available Predecessors");
		availablepre.setForeground(Color.CYAN);
		availablepre.setBounds(759, 208, 148, 16);
		frame.getContentPane().add(availablepre);
		
		JList list_2 = new JList();
		list_2.setBounds(756, 239, 240, 90);
		frame.getContentPane().add(list_2);
		
		JList list_1_2 = new JList();
		list_1_2.setBounds(756, 363, 240, 82);
		frame.getContentPane().add(list_1_2);
		
		JLabel lblAvailableSuccessors = new JLabel("Available Successors");
		lblAvailableSuccessors.setForeground(Color.CYAN);
		lblAvailableSuccessors.setBounds(759, 334, 148, 16);
		frame.getContentPane().add(lblAvailableSuccessors);
		
		
		
		//******************************************************************************************End Buttons
	}
}
