package testingtheGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class Deliverables_popup {

	JFrame frame;
	private JTextField DName;
	private JTextField DID;
	private JTextField DDueDate;
	private String deliverableID;
	private JTextField txtNotCurrentlyFunctional;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deliverables_popup window = new Deliverables_popup();
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
	public Deliverables_popup() {
		this.deliverableID = "new";
		initialize();
		
	}
	public Deliverables_popup(String dID) {
		this.deliverableID = dID;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 13));
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1040, 720);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //******************************do not exit on close
		frame.getContentPane().setLayout(null);
		JTextArea dDescription = new JTextArea();
		dDescription.setBounds(34, 239, 333, 151);
		frame.getContentPane().add(dDescription);
		
		//*****************************************************************************************************************BEGIN LABELS
		JLabel lblCreateeditDeliverables = new JLabel("Create/Edit Deliverables");
		lblCreateeditDeliverables.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCreateeditDeliverables.setForeground(Color.CYAN);
		lblCreateeditDeliverables.setBounds(400, 13, 246, 16);
		frame.getContentPane().add(lblCreateeditDeliverables);
		
		JLabel lblDeliverableName = new JLabel("Deliverable Name");
		lblDeliverableName.setForeground(Color.CYAN);
		lblDeliverableName.setBounds(34, 110, 177, 40);
		frame.getContentPane().add(lblDeliverableName);
		
		JLabel lblDeliverableDescription = new JLabel("Deliverable Description");
		lblDeliverableDescription.setForeground(Color.CYAN);
		lblDeliverableDescription.setBounds(34, 201, 154, 40);
		frame.getContentPane().add(lblDeliverableDescription);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setForeground(Color.CYAN);
		lblDueDate.setBounds(34, 403, 56, 16);
		frame.getContentPane().add(lblDueDate);
		
		JLabel lblDeliverableid = new JLabel("DeliverableID");
		lblDeliverableid.setForeground(Color.CYAN);
		lblDeliverableid.setBounds(34, 46, 107, 25);
		frame.getContentPane().add(lblDeliverableid);
		
		JLabel lblAssociatedTasks = new JLabel("Associated Tasks");
		lblAssociatedTasks.setForeground(Color.CYAN);
		lblAssociatedTasks.setBounds(452, 125, 136, 25);
		frame.getContentPane().add(lblAssociatedTasks);
		
		JLabel lblAssociatedRequirements = new JLabel("Associated Requirements");
		lblAssociatedRequirements.setForeground(Color.CYAN);
		lblAssociatedRequirements.setBounds(452, 291, 147, 25);
		frame.getContentPane().add(lblAssociatedRequirements);
		
		
		//***************************************************************************************************************END LABELS
		
		
		DName = new JTextField();
		DName.setBounds(34, 144, 301, 40);
		frame.getContentPane().add(DName);
		DName.setColumns(10);
		
		DID = new JTextField();
		DID.setBounds(34, 76, 136, 34);
		frame.getContentPane().add(DID);
		DID.setColumns(10);
		
		DDueDate = new JTextField();
		DDueDate.setBounds(34, 442, 199, 40);
		frame.getContentPane().add(DDueDate);
		DDueDate.setColumns(10);
		
		if(deliverableID.equals("new")) {///****************************if new item do this 
		
		DID.setText(Integer .toString(Project.deliverables.size()+1));
			
		}else { // else read item fields from linkedlist in main project
			
			DName.setText(Project.deliverables.get(Integer.parseInt(deliverableID)-1).name);
			dDescription.setText(Project.deliverables.get(Integer.parseInt(deliverableID)-1).description);
			DID.setText(Project.deliverables.get(Integer.parseInt(deliverableID)-1).uniqueID);
			DDueDate.setText(Project.deliverables.get(Integer.parseInt(deliverableID)-1).dueDate);
					
		}
		//*******************************************************************************************************************************begin buttons
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(deliverableID.equals("new")) {// if its new create a new object
					Deliverable createdDeliverable = new Deliverable();
					
					createdDeliverable.description = dDescription.getText() + " ";
					createdDeliverable.name = DName.getText() + " " ;
					createdDeliverable.dueDate = DDueDate.getText() + " ";
					createdDeliverable.uniqueID = DID.getText() + " ";
					//createdDeliverable.associated_Tasks =      ;*******************************************fix here
					 
					Project.deliverables.add(createdDeliverable);
					Mainpage.modelD.addElement(createdDeliverable);
					frame.dispose();
				}else {// just update the current object
					
					Project.deliverables.get(Integer.parseInt(deliverableID)-1).description = dDescription.getText() + " ";
					Project.deliverables.get(Integer.parseInt(deliverableID)-1).uniqueID = DID.getText() + " ";
					Project.deliverables.get(Integer.parseInt(deliverableID)-1).dueDate = DDueDate.getText() + " ";
					Project.deliverables.get(Integer.parseInt(deliverableID)-1).name = DName.getText()  + " ";
					//Project.deliverables.get(Integer.parseInt(deliverableID)-1).associated_Tasks = ***************************and here
					
					frame.dispose();
				}	
			}
		});
		btnSave.setBounds(793, 555, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(deliverableID.equals("new")) {
					
				}else {
					Project.deliverables.remove(Integer.parseInt(deliverableID)-1);
					Mainpage.modelD.removeElementAt(Integer.parseInt(deliverableID)-1);
					frame.dispose();
				}
				
				
			}
		});
		btnDelete.setBounds(644, 555, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JList list = new JList();
		list.setBounds(452, 156, 268, 107);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(742, 155, 268, 107);
		frame.getContentPane().add(list_1);
		
		JLabel lblUnassociatedTasks = new JLabel("Unassociated Tasks");
		lblUnassociatedTasks.setForeground(Color.CYAN);
		lblUnassociatedTasks.setBounds(742, 129, 136, 16);
		frame.getContentPane().add(lblUnassociatedTasks);
		
		txtNotCurrentlyFunctional = new JTextField();
		txtNotCurrentlyFunctional.setText("Not Currently Functional");
		txtNotCurrentlyFunctional.setBounds(452, 317, 268, 73);
		frame.getContentPane().add(txtNotCurrentlyFunctional);
		txtNotCurrentlyFunctional.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Not Currently Functional");
		textField.setColumns(10);
		textField.setBounds(742, 317, 268, 73);
		frame.getContentPane().add(textField);
		
		JLabel lblUnnassociatedRequirements = new JLabel("Unnassociated Requirements");
		lblUnnassociatedRequirements.setForeground(Color.CYAN);
		lblUnnassociatedRequirements.setBounds(742, 295, 177, 16);
		frame.getContentPane().add(lblUnnassociatedRequirements);
		
		
		
	}//**************************INITIALIZE
}
