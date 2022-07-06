package testingtheGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Resources_popup {

	JFrame frame;
	private JTextField resourceID;
	private JTextField resourceName;
	private JTextField resourceRate;
	private JTextField dateavailable;
	private JTextField jobTitle;
	private String rID;
	private JTextField rskills;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resources_popup window = new Resources_popup();
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
	public Resources_popup() {
		this.rID = "new";
		initialize();
		
	}
	public Resources_popup(String ID) {
		this.rID = ID;
		initialize();		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1040, 720);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateditResources = new JLabel("Creat/Edit Resources");
		lblCreateditResources.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCreateditResources.setForeground(Color.CYAN);
		lblCreateditResources.setBounds(409, 13, 180, 43);
		frame.getContentPane().add(lblCreateditResources);	
		
		JLabel lblResourceId = new JLabel("Resource ID");
		lblResourceId.setForeground(Color.CYAN);
		lblResourceId.setBounds(24, 40, 110, 16);
		frame.getContentPane().add(lblResourceId);
		
		resourceID = new JTextField();
		resourceID.setBounds(24, 63, 116, 22);
		frame.getContentPane().add(resourceID);
		resourceID.setColumns(10);
		
		JLabel lblResourceName = new JLabel("Resource Name");
		lblResourceName.setForeground(Color.CYAN);
		lblResourceName.setBounds(24, 105, 151, 25);
		frame.getContentPane().add(lblResourceName);
		
		resourceName = new JTextField();
		resourceName.setBounds(24, 130, 284, 32);
		frame.getContentPane().add(resourceName);
		resourceName.setColumns(10);
		
		JLabel lblResourceRate = new JLabel("Resource Rate");
		lblResourceRate.setForeground(Color.CYAN);
		lblResourceRate.setBounds(24, 185, 97, 16);
		frame.getContentPane().add(lblResourceRate);
		
		resourceRate = new JTextField();
		resourceRate.setBounds(23, 210, 207, 32);
		frame.getContentPane().add(resourceRate);
		resourceRate.setColumns(10);
		
		JLabel lblDatesAvailable = new JLabel("Dates Available");
		lblDatesAvailable.setForeground(Color.CYAN);
		lblDatesAvailable.setBounds(24, 266, 133, 16);
		frame.getContentPane().add(lblDatesAvailable);
		
		dateavailable = new JTextField();
		dateavailable.setBounds(24, 295, 284, 32);
		frame.getContentPane().add(dateavailable);
		dateavailable.setColumns(10);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setForeground(Color.CYAN);
		lblJobTitle.setBounds(409, 109, 56, 16);
		frame.getContentPane().add(lblJobTitle);
		
		jobTitle = new JTextField();
		jobTitle.setBounds(409, 130, 180, 32);
		frame.getContentPane().add(jobTitle);
		jobTitle.setColumns(10);
		
		JLabel lblSkills = new JLabel("Skills");
		lblSkills.setForeground(Color.CYAN);
		lblSkills.setBounds(24, 340, 56, 16);
		frame.getContentPane().add(lblSkills);
		
		rskills = new JTextField();
		rskills.setBounds(24, 369, 284, 43);
		frame.getContentPane().add(rskills);
		rskills.setColumns(10);
			
		JButton btnSave = new JButton("save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				if(rID.equals("new")) {
					Resource createdresource = new Resource();
					createdresource.unique_ID = resourceID.getText();
					createdresource.resource_name = resourceName.getText();
					createdresource.hourly_rate = resourceRate.getText();
					createdresource.dates_available = dateavailable.getText();
					createdresource.job_title = jobTitle.getText();			
					createdresource.skills = rskills.getText();
					Project.resources.add(createdresource);
					Mainpage.modelR.addElement(createdresource);
					frame.dispose();
				}else {
					Project.resources.get(Integer.parseInt(rID)-1).unique_ID = resourceID.getText();
					Project.resources.get(Integer.parseInt(rID)-1).resource_name = resourceName.getText();
					Project.resources.get(Integer.parseInt(rID)-1).hourly_rate = resourceRate.getText();
					Project.resources.get(Integer.parseInt(rID)-1).dates_available = dateavailable.getText();
					Project.resources.get(Integer.parseInt(rID)-1).job_title = jobTitle.getText();	
					Project.resources.get(Integer.parseInt(rID)-1).skills = rskills.getText();
					frame.dispose();
				}
						
			}
		});
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(863, 601, 97, 25);
		frame.getContentPane().add(btnSave);
		
			
		JButton delete = new JButton("Delete");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(rID.equals("new")) {
					
				}else {
					Project.resources.remove(Integer.parseInt(rID)-1);
					Mainpage.modelR.removeElementAt(Integer.parseInt(rID)-1);
					frame.dispose();
				}
							
			}
		});
		delete.setBackground(Color.RED);
		delete.setBounds(724, 601, 97, 25);
		frame.getContentPane().add(delete);
		
		if(rID.equals("new")) {///****************************if new item do this 
			
			resourceID.setText(Integer.toString(Project.resources.size()+1));
				
			}else {
		
				resourceID.setText(Project.resources.get(Integer.parseInt(rID)-1).unique_ID);
				resourceName.setText(Project.resources.get(Integer.parseInt(rID)-1).resource_name);
				resourceRate.setText(Project.resources.get(Integer.parseInt(rID)-1).hourly_rate);
				dateavailable.setText(Project.resources.get(Integer.parseInt(rID)-1).dates_available);
				jobTitle.setText(Project.resources.get(Integer.parseInt(rID)-1).job_title);
				rskills.setText(Project.resources.get(Integer.parseInt(rID)-1).skills);
		
			}
		
	}
}
