package testingtheGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Issues_popup {

	JFrame frame;
	private JTextField issueID;
	private JTextField issueName;
	private JTextField dateRaised;
	private JTextField dateAssigned;
	private JTextField ExpectedEnd;
	private JTextField ActualEnd;
	private String iID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issues_popup window = new Issues_popup();
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
	public Issues_popup() {
		this.iID = "new";
		initialize();
		
	}
	public Issues_popup(String ID) {
		this.iID = ID;
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
		
		JLabel lblCreateeditIssues = new JLabel("Create/Edit Issues");
		lblCreateeditIssues.setForeground(Color.CYAN);
		lblCreateeditIssues.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCreateeditIssues.setBounds(424, 13, 250, 47);
		frame.getContentPane().add(lblCreateeditIssues);
		
		JButton btnSave = new JButton("save");
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(842, 588, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JLabel lblIssueId = new JLabel("Issue ID");
		lblIssueId.setForeground(Color.CYAN);
		lblIssueId.setBounds(33, 45, 117, 30);
		frame.getContentPane().add(lblIssueId);
		
		JLabel lblIssueName = new JLabel("Issue Name");
		lblIssueName.setForeground(Color.CYAN);
		lblIssueName.setBounds(33, 98, 117, 16);
		frame.getContentPane().add(lblIssueName);
		
		JLabel lblIssueDescription = new JLabel("Issue Description");
		lblIssueDescription.setForeground(Color.CYAN);
		lblIssueDescription.setBounds(33, 156, 123, 16);
		frame.getContentPane().add(lblIssueDescription);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setForeground(Color.CYAN);
		lblPriority.setBounds(33, 296, 123, 25);
		frame.getContentPane().add(lblPriority);
		
		JLabel lblSeverity = new JLabel("Severity");
		lblSeverity.setForeground(Color.CYAN);
		lblSeverity.setBounds(33, 366, 91, 16);
		frame.getContentPane().add(lblSeverity);
		
		JLabel lblDateRaised = new JLabel("Date Raised");
		lblDateRaised.setForeground(Color.CYAN);
		lblDateRaised.setBounds(33, 440, 93, 25);
		frame.getContentPane().add(lblDateRaised);
		
		JLabel lblDateAssigned = new JLabel("Date Assigned");
		lblDateAssigned.setForeground(Color.CYAN);
		lblDateAssigned.setBounds(179, 444, 123, 16);
		frame.getContentPane().add(lblDateAssigned);
		
		JLabel lblActualEndDate = new JLabel("Actual End Date");
		lblActualEndDate.setForeground(Color.CYAN);
		lblActualEndDate.setBounds(179, 495, 135, 25);
		frame.getContentPane().add(lblActualEndDate);
		
		JLabel lblExpectedEndDate = new JLabel("Expected End Date");
		lblExpectedEndDate.setForeground(Color.CYAN);
		lblExpectedEndDate.setBounds(33, 497, 135, 21);
		frame.getContentPane().add(lblExpectedEndDate);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.CYAN);
		lblStatus.setBounds(557, 72, 117, 16);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblStatusDescription = new JLabel("Status Description");
		lblStatusDescription.setForeground(Color.CYAN);
		lblStatusDescription.setBounds(557, 113, 147, 30);
		frame.getContentPane().add(lblStatusDescription);
		
		JLabel lblActionItems = new JLabel("Action Items");
		lblActionItems.setForeground(Color.CYAN);
		lblActionItems.setBounds(557, 296, 131, 25);
		frame.getContentPane().add(lblActionItems);
		
		JLabel lblDecisions = new JLabel("Decisions");
		lblDecisions.setForeground(Color.CYAN);
		lblDecisions.setBounds(557, 376, 103, 25);
		frame.getContentPane().add(lblDecisions);
		
		issueID = new JTextField();
		issueID.setBounds(34, 69, 116, 22);
		frame.getContentPane().add(issueID);
		issueID.setColumns(10);
		
		issueName = new JTextField();
		issueName.setText("Issue Section not currently working");
		issueName.setBounds(33, 113, 341, 30);
		frame.getContentPane().add(issueName);
		issueName.setColumns(10);
		
		JTextArea issueDescription = new JTextArea();
		issueDescription.setBounds(33, 185, 341, 110);
		frame.getContentPane().add(issueDescription);
		
		JTextArea statusDescription = new JTextArea();
		statusDescription.setBounds(557, 153, 341, 110);
		frame.getContentPane().add(statusDescription);
		
		dateRaised = new JTextField();
		dateRaised.setColumns(10);
		dateRaised.setBounds(33, 473, 116, 22);
		frame.getContentPane().add(dateRaised);
		
		dateAssigned = new JTextField();
		dateAssigned.setColumns(10);
		dateAssigned.setBounds(179, 473, 116, 22);
		frame.getContentPane().add(dateAssigned);
		
		ExpectedEnd = new JTextField();
		ExpectedEnd.setColumns(10);
		ExpectedEnd.setBounds(33, 519, 116, 22);
		frame.getContentPane().add(ExpectedEnd);
		
		ActualEnd = new JTextField();
		ActualEnd.setColumns(10);
		ActualEnd.setBounds(179, 519, 116, 22);
		frame.getContentPane().add(ActualEnd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(702, 588, 97, 25);
		frame.getContentPane().add(btnDelete);
	}
}
