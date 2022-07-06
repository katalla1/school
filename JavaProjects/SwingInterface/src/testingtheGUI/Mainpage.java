package testingtheGUI;

import java.awt.EventQueue;
import java.lang.*;
import java.util.LinkedList;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JList;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Mainpage {

	 JFrame frame;
	 private JTextField txtSearchdel;
	 private JTextField searchTasks;
	 private JTextField searchActionItems;
	 private JTextField searchIssues;
	 private JTextField searchResources;
	 static DefaultListModel modelD = new DefaultListModel();
	 static DefaultListModel modelT = new DefaultListModel();
	 static DefaultListModel modelR = new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage window = new Mainpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public Mainpage() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		Project.load();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        Project.save();
		        frame.dispose();
		        System.exit(0);
		    }
		});	
		JLabel lblIhdcProjectManagement = new JLabel("IHDC Project Management Systems");
		lblIhdcProjectManagement.setForeground(Color.CYAN);
		lblIhdcProjectManagement.setBounds(585, 41, 750, 62);
		lblIhdcProjectManagement.setFont(new Font("Vladimir Script", Font.BOLD, 47));
		frame.getContentPane().add(lblIhdcProjectManagement);
			
		JButton btnHelp = new JButton("Help?");
		btnHelp.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnHelp.setBounds(1699, 145, 116, 28);
		frame.getContentPane().add(btnHelp);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(255, 145, 1335, 854);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel deliverables = new JPanel();
		deliverables.setBackground(Color.DARK_GRAY);
		layeredPane.add(deliverables, "name_19545765279300");
		deliverables.setLayout(null);
		
		JLabel lblDeliverables = new JLabel("Deliverables");
		lblDeliverables.setForeground(Color.CYAN);
		lblDeliverables.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDeliverables.setBounds(6, 6, 140, 47);
		deliverables.add(lblDeliverables);
		
		JButton btnCreateNewDeliverable = new JButton("+ Create New Deliverable");
		btnCreateNewDeliverable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Deliverables_popup window = new Deliverables_popup("new");//********************************************************opens the deliverables popup window
				window.frame.setVisible(true);			
			}
		});
		btnCreateNewDeliverable.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnCreateNewDeliverable.setBounds(893, 33, 205, 52);
		deliverables.add(btnCreateNewDeliverable);
		
		txtSearchdel = new JTextField();
		txtSearchdel.setBounds(347, 18, 198, 28);
		deliverables.add(txtSearchdel);
		txtSearchdel.setColumns(10);
		
		JButton btnSearchd = new JButton("Search");
		btnSearchd.setBounds(579, 18, 90, 28);
		deliverables.add(btnSearchd);
		
		JLabel lblFilterBy_1 = new JLabel("Filter By");
		lblFilterBy_1.setForeground(Color.CYAN);
		lblFilterBy_1.setBounds(192, 69, 55, 16);
		deliverables.add(lblFilterBy_1);
		
		JLabel lblSearchDeliverables = new JLabel("Search Deliverables");
		lblSearchDeliverables.setForeground(Color.CYAN);
		lblSearchDeliverables.setBounds(168, 24, 132, 16);
		deliverables.add(lblSearchDeliverables);
		
		JButton btnAlphabeticald = new JButton("Alphabetical");
		btnAlphabeticald.setBounds(271, 63, 126, 28);
		deliverables.add(btnAlphabeticald);
		
		JButton btnDueDateD = new JButton("Due Date");
		btnDueDateD.setBounds(409, 63, 90, 28);
		deliverables.add(btnDueDateD);
		
		JButton btnUniqueIdD = new JButton("Unique ID");
		btnUniqueIdD.setBounds(511, 63, 90, 28);
		deliverables.add(btnUniqueIdD);
		
		JLabel label = new JLabel("");
		label.setBounds(208, 460, 55, 16);
		deliverables.add(label);
		
		
		for(int i = 0;i < Project.deliverables.size();i++ ) {
			modelD.addElement(Project.deliverables.get(i));	
		}
		
		JList list = new JList(modelD);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedIndex() == -1) {					
				}else {
				int i = list.getSelectedIndex();
				i++;
				String intvalue = Integer.toString(i);
				Deliverables_popup window = new Deliverables_popup(intvalue);
				window.frame.setVisible(true);
				}
			}
		});
		list.setForeground(Color.CYAN);
		list.setFont(new Font("SansSerif", Font.PLAIN, 25));
		list.setBackground(Color.DARK_GRAY);//**********************************************list of deliverables
		list.setBounds(95, 164, 1106, 618);
		deliverables.add(list);
		
		JPanel tasks = new JPanel();
		tasks.setBackground(Color.DARK_GRAY);
		layeredPane.add(tasks, "name_19587502761700");
		tasks.setLayout(null);
		
		JLabel lblTasks = new JLabel("Tasks");
		lblTasks.setForeground(Color.CYAN);
		lblTasks.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTasks.setBounds(6, 0, 126, 34);
		tasks.add(lblTasks);
		
		JButton btnCreateNewTaskst = new JButton("+ Create new Task");//******************************************************task popup window
		btnCreateNewTaskst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tasks_popup window = new Tasks_popup("new");
				window.frame.setVisible(true);
			}
		});
		btnCreateNewTaskst.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnCreateNewTaskst.setBounds(888, 41, 182, 52);
		tasks.add(btnCreateNewTaskst);
		
		JLabel lblSearch = new JLabel("Search Tasks");
		lblSearch.setForeground(Color.CYAN);
		lblSearch.setBounds(92, 38, 165, 16);
		tasks.add(lblSearch);
		
		searchTasks = new JTextField();
		searchTasks.setBounds(204, 32, 228, 28);
		tasks.add(searchTasks);
		searchTasks.setColumns(10);
		
		JButton btnSearcht = new JButton("Search");
		btnSearcht.setBounds(464, 32, 90, 28);
		tasks.add(btnSearcht);
		
		JLabel lblFilterBy_2 = new JLabel("filter by");
		lblFilterBy_2.setForeground(Color.CYAN);
		lblFilterBy_2.setBounds(141, 77, 55, 16);
		tasks.add(lblFilterBy_2);
		
		JButton btnAlphabeticalT = new JButton("Alphabetical");
		btnAlphabeticalT.setBounds(214, 71, 108, 28);
		tasks.add(btnAlphabeticalT);
		
		JButton btnDueDateT = new JButton("Due Date");
		btnDueDateT.setBounds(334, 71, 90, 28);
		tasks.add(btnDueDateT);
		
		JButton btnStartDateT = new JButton("Start Date");
		btnStartDateT.setBounds(436, 71, 108, 28);
		tasks.add(btnStartDateT);
		
		JButton btnResourceT = new JButton("Resource");
		btnResourceT.setBounds(556, 71, 90, 28);
		tasks.add(btnResourceT);
		
		
		for(int i = 0;i < Project.tasks.size();i++ ) {
			modelT.addElement(Project.tasks.get(i));		
		}
		
		JList list_1 = new JList(modelT);
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list_1.getSelectedIndex() == -1) {					
				}else {
				int i = list_1.getSelectedIndex();
				i++;
				String intvalue = Integer.toString(i);
				Tasks_popup window = new Tasks_popup(intvalue);
				window.frame.setVisible(true);
				}
			}
		});
		
		list_1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		list_1.setForeground(Color.CYAN);
		list_1.setBackground(Color.DARK_GRAY);
		list_1.setBounds(91, 162, 1115, 632);
		tasks.add(list_1);
		
		
		JPanel actionitems = new JPanel();
		actionitems.setBackground(Color.DARK_GRAY);
		layeredPane.add(actionitems, "name_19607879904000");
		actionitems.setLayout(null);
		
		JLabel lblActionItems = new JLabel("Action Items");
		lblActionItems.setForeground(Color.CYAN);
		lblActionItems.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblActionItems.setBounds(6, 6, 194, 43);
		actionitems.add(lblActionItems);
		
		JButton btnSearchAA = new JButton("Search");
		btnSearchAA.setBounds(451, 61, 90, 28);
		actionitems.add(btnSearchAA);
		
		searchActionItems = new JTextField();
		searchActionItems.setBounds(238, 61, 183, 28);
		actionitems.add(searchActionItems);
		searchActionItems.setColumns(10);
		
		JLabel lblSearchActionItems = new JLabel("Search Action Items");
		lblSearchActionItems.setForeground(Color.CYAN);
		lblSearchActionItems.setBounds(100, 67, 117, 16);
		actionitems.add(lblSearchActionItems);
		
		JButton btnCreateNew = new JButton("+ Create new Action Item");//***************************************************action item popup
		btnCreateNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActionItems_popup window = new ActionItems_popup("new");
				window.frame.setVisible(true);
			}
		});
		btnCreateNew.setBounds(896, 61, 213, 48);
		actionitems.add(btnCreateNew);
		
		JLabel lblFilterBy_3 = new JLabel("filter by");
		lblFilterBy_3.setForeground(Color.CYAN);
		lblFilterBy_3.setBounds(145, 108, 55, 16);
		actionitems.add(lblFilterBy_3);
		
		JButton btnAlphabeticalaa = new JButton("Alphabetical");
		btnAlphabeticalaa.setBounds(212, 102, 110, 28);
		actionitems.add(btnAlphabeticalaa);
		
		JButton btnDueDateAa = new JButton("Due Date");
		btnDueDateAa.setBounds(334, 102, 90, 28);
		actionitems.add(btnDueDateAa);
		
		JButton btnStartDateAa = new JButton("Start Date");
		btnStartDateAa.setBounds(436, 102, 90, 28);
		actionitems.add(btnStartDateAa);
		
		JButton btnEndDateAa = new JButton("End Date");
		btnEndDateAa.setBounds(538, 102, 90, 28);
		actionitems.add(btnEndDateAa);
		
		JButton btnResourceAa = new JButton("Resource");
		btnResourceAa.setBounds(640, 102, 90, 28);
		actionitems.add(btnResourceAa);
		
		JLabel lblNotFunctional = new JLabel("Not Functional");
		lblNotFunctional.setFont(new Font("SansSerif", Font.PLAIN, 44));
		lblNotFunctional.setForeground(Color.RED);
		lblNotFunctional.setBounds(218, 262, 350, 61);
		actionitems.add(lblNotFunctional);
		
		JPanel issues = new JPanel();
		issues.setBackground(Color.DARK_GRAY);
		layeredPane.add(issues, "name_19637697096700");
		issues.setLayout(null);
		
		JLabel lblIssues = new JLabel("Issues");
		lblIssues.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblIssues.setForeground(Color.CYAN);
		lblIssues.setBounds(6, 0, 137, 48);
		issues.add(lblIssues);
		
		JLabel lblSearchIssues = new JLabel("Search Issues");
		lblSearchIssues.setForeground(Color.CYAN);
		lblSearchIssues.setBounds(142, 19, 114, 16);
		issues.add(lblSearchIssues);
		
		searchIssues = new JTextField();
		searchIssues.setBounds(242, 13, 228, 28);
		issues.add(searchIssues);
		searchIssues.setColumns(10);
		
		JButton btnCreateNew_1 = new JButton("+ Create new Issue");//******************************************issue popup
		btnCreateNew_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Issues_popup window = new Issues_popup("new");
				window.frame.setVisible(true);
				
			}
		});
		btnCreateNew_1.setBounds(1004, 19, 162, 42);
		issues.add(btnCreateNew_1);
		
		JLabel lblFilterBy_4 = new JLabel("filter by");
		lblFilterBy_4.setForeground(Color.CYAN);
		lblFilterBy_4.setBounds(111, 60, 55, 16);
		issues.add(lblFilterBy_4);
		
		JButton btnAlphabeticalIss = new JButton("Alphabetical");
		btnAlphabeticalIss.setBounds(167, 54, 123, 28);
		issues.add(btnAlphabeticalIss);
		
		JButton btnDueDateIss = new JButton("Due Date");
		btnDueDateIss.setBounds(302, 54, 90, 28);
		issues.add(btnDueDateIss);
		
		JButton btnStartDateIss = new JButton("Start Date");
		btnStartDateIss.setBounds(404, 54, 101, 28);
		issues.add(btnStartDateIss);
		
		JButton btnEndDateIss = new JButton("End Date");
		btnEndDateIss.setBounds(517, 54, 90, 28);
		issues.add(btnEndDateIss);
		
		JButton btnResourceIss = new JButton("Resource");
		btnResourceIss.setBounds(619, 54, 101, 28);
		issues.add(btnResourceIss);
		
		JLabel lblNotFunctional_1 = new JLabel("Not Functional");
		lblNotFunctional_1.setForeground(Color.RED);
		lblNotFunctional_1.setFont(new Font("SansSerif", Font.PLAIN, 44));
		lblNotFunctional_1.setBounds(167, 254, 350, 61);
		issues.add(lblNotFunctional_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(517, 13, 90, 28);
		issues.add(btnSearch);
		
		JPanel resources = new JPanel();
		resources.setBackground(Color.DARK_GRAY);
		layeredPane.add(resources, "name_19676516510000");
		resources.setLayout(null);
		
		JLabel lblResources = new JLabel("Resources");
		lblResources.setForeground(Color.CYAN);
		lblResources.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblResources.setBounds(6, 6, 138, 45);
		resources.add(lblResources);
		
		JLabel lblSearchResources = new JLabel("Search Resources");
		lblSearchResources.setForeground(Color.CYAN);
		lblSearchResources.setBounds(156, 23, 117, 16);
		resources.add(lblSearchResources);
		
		JLabel lblFilterBy_5 = new JLabel("filter by");
		lblFilterBy_5.setForeground(Color.CYAN);
		lblFilterBy_5.setBounds(182, 51, 55, 16);
		resources.add(lblFilterBy_5);
		
		searchResources = new JTextField();
		searchResources.setBounds(283, 17, 195, 28);
		resources.add(searchResources);
		searchResources.setColumns(10);
		
		JButton btnAlphabeticalR = new JButton("Alphabetical");
		btnAlphabeticalR.setBounds(251, 51, 107, 28);
		resources.add(btnAlphabeticalR);
		
		JButton btnAvailability = new JButton("Availability");
		btnAvailability.setBounds(370, 51, 108, 28);
		resources.add(btnAvailability);
		
		JButton btnCost = new JButton("Cost");
		btnCost.setBounds(490, 51, 90, 28);
		resources.add(btnCost);
		
		JButton btnAddNew = new JButton("+ Add New Resource");//*************************************************************resource popup window
		btnAddNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Resources_popup window = new Resources_popup("new");
				window.frame.setVisible(true);
			}
		});
		btnAddNew.setBounds(878, 23, 165, 54);
		resources.add(btnAddNew);
			
		
		
		
		for(int i = 0;i < Project.resources.size();i++ ) {
			modelR.addElement(Project.resources.get(i));		
		}
			
		JList list_2 = new JList(modelR);
		list_2.setFont(new Font("SansSerif", Font.PLAIN, 25));
		list_2.setForeground(Color.CYAN);
		list_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list_2.getSelectedIndex() == -1) {					
				}else {
				int i = list_2.getSelectedIndex();
				i++;
				String intvalue = Integer.toString(i);
				Resources_popup window = new Resources_popup(intvalue);
				window.frame.setVisible(true);			
				}
			}
		});
		
		
		
		
		
		list_2.setBackground(Color.DARK_GRAY);
		list_2.setBounds(158, 171, 911, 617);
		resources.add(list_2);
		
		
			
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBounds(490, 17, 90, 28);
		resources.add(btnSearch_1);
		
		
		
		JButton btnDeliverables = new JButton("Deliverables");
		btnDeliverables.setFont(new Font("SansSerif", Font.PLAIN, 14));//*********************************************************deliverable main layer
		btnDeliverables.setBounds(86, 260, 130, 28);
		frame.getContentPane().add(btnDeliverables);
		btnDeliverables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(deliverables);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		
		JButton btntasks = new JButton("Tasks");
		btntasks.setFont(new Font("SansSerif", Font.PLAIN, 14));//*********************************************************tasks main layer
		btntasks.setBounds(86, 300, 130, 28);
		frame.getContentPane().add(btntasks);
		btntasks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(tasks);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
			
		JButton btnActionItems = new JButton("Action Items");
		btnActionItems.setFont(new Font("SansSerif", Font.PLAIN, 14));//*********************************************************actions items main layer
		btnActionItems.setBounds(86, 340, 130, 28);
		frame.getContentPane().add(btnActionItems);
		btnActionItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(actionitems);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		JButton btnIssues = new JButton("Issues");
		btnIssues.setFont(new Font("SansSerif", Font.PLAIN, 14));//*********************************************************issues main layer
		btnIssues.setBounds(86, 380, 130, 28);
		frame.getContentPane().add(btnIssues);
		btnIssues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(issues);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		JButton btnResources = new JButton("Resources");
		btnResources.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnResources.setBounds(86, 420, 130, 28);
		frame.getContentPane().add(btnResources);
		
		btnResources.addMouseListener(new MouseAdapter() {//*********************************************************resources main layer
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(resources);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		
		
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(1699, 203, 116, 28);
		frame.getContentPane().add(btnSettings);	
		
	}
}
