package testingtheGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionItems_popup {

	JFrame frame;
	private JTextField actionItemID;
	private JTextField actionItemName;
	private JTextField dateCreated;
	private JTextField dateAssigned;
	private JTextField expectedDate;
	private JTextField actualDate;
	private JTextField status;
	private String aiID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActionItems_popup window = new ActionItems_popup();
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
	public ActionItems_popup() {
		this.aiID = "new";
		initialize();
		
	}
	
	public ActionItems_popup(String ID) {
		this.aiID = ID;
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
		
		JLabel lblCreateditActionItems = new JLabel("Create/Edit Action Items");
		lblCreateditActionItems.setForeground(Color.CYAN);
		lblCreateditActionItems.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCreateditActionItems.setBounds(380, 13, 212, 47);
		frame.getContentPane().add(lblCreateditActionItems);
		
		JButton btnSave = new JButton("save");
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(855, 590, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JLabel lblActionItemId = new JLabel("Action Item ID");
		lblActionItemId.setForeground(Color.CYAN);
		lblActionItemId.setBounds(50, 52, 97, 32);
		frame.getContentPane().add(lblActionItemId);
		
		JLabel lblActionItemName = new JLabel("Action Item Name");
		lblActionItemName.setForeground(Color.CYAN);
		lblActionItemName.setBounds(52, 116, 130, 32);
		frame.getContentPane().add(lblActionItemName);
		
		JLabel lblDateCreated = new JLabel("Date Created");
		lblDateCreated.setForeground(Color.CYAN);
		lblDateCreated.setBounds(52, 183, 130, 32);
		frame.getContentPane().add(lblDateCreated);
		
		JLabel lblDateAssigned = new JLabel("Date Assigned");
		lblDateAssigned.setForeground(Color.CYAN);
		lblDateAssigned.setBounds(227, 187, 121, 25);
		frame.getContentPane().add(lblDateAssigned);
		
		JLabel lblExpectedCompletionDate = new JLabel("Expected Completion Date");
		lblExpectedCompletionDate.setForeground(Color.CYAN);
		lblExpectedCompletionDate.setBounds(50, 256, 165, 25);
		frame.getContentPane().add(lblExpectedCompletionDate);
		
		JLabel lblActualCompletionDate = new JLabel("Actual Completion Date");
		lblActualCompletionDate.setForeground(Color.CYAN);
		lblActualCompletionDate.setBounds(227, 256, 138, 25);
		frame.getContentPane().add(lblActualCompletionDate);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.CYAN);
		lblStatus.setBounds(50, 335, 153, 25);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblStatusDescription = new JLabel("Status Description");
		lblStatusDescription.setForeground(Color.CYAN);
		lblStatusDescription.setBounds(50, 406, 165, 25);
		frame.getContentPane().add(lblStatusDescription);
		
		JLabel lblActionItemDescription = new JLabel("Action Item Description");
		lblActionItemDescription.setForeground(Color.CYAN);
		lblActionItemDescription.setBounds(521, 86, 195, 25);
		frame.getContentPane().add(lblActionItemDescription);
		
		JLabel lblResourcesAssigned = new JLabel("Resources Assigned");
		lblResourcesAssigned.setForeground(Color.CYAN);
		lblResourcesAssigned.setBounds(521, 281, 182, 21);
		frame.getContentPane().add(lblResourcesAssigned);
		
		JTextArea statusDescription = new JTextArea();
		statusDescription.setBounds(50, 443, 370, 116);
		frame.getContentPane().add(statusDescription);
		
		JTextArea actionItemDescription = new JTextArea();
		actionItemDescription.setBounds(522, 121, 395, 138);
		frame.getContentPane().add(actionItemDescription);
		
		actionItemID = new JTextField();
		actionItemID.setBounds(50, 82, 120, 32);
		frame.getContentPane().add(actionItemID);
		actionItemID.setColumns(10);
		
		actionItemName = new JTextField();
		actionItemName.setText("Action Item Section Not Currently Functional");
		actionItemName.setBounds(50, 150, 335, 32);
		frame.getContentPane().add(actionItemName);
		actionItemName.setColumns(10);
		
		dateCreated = new JTextField();
		dateCreated.setBounds(50, 222, 116, 22);
		frame.getContentPane().add(dateCreated);
		dateCreated.setColumns(10);
		
		dateAssigned = new JTextField();
		dateAssigned.setBounds(227, 222, 116, 22);
		frame.getContentPane().add(dateAssigned);
		dateAssigned.setColumns(10);
		
		expectedDate = new JTextField();
		expectedDate.setColumns(10);
		expectedDate.setBounds(50, 293, 116, 22);
		frame.getContentPane().add(expectedDate);
		
		actualDate = new JTextField();
		actualDate.setColumns(10);
		actualDate.setBounds(227, 293, 116, 22);
		frame.getContentPane().add(actualDate);
		
		status = new JTextField();
		status.setBounds(50, 362, 165, 32);
		frame.getContentPane().add(status);
		status.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(715, 590, 97, 25);
		frame.getContentPane().add(btnDelete);
	}
}
