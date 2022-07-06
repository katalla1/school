package testingtheGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class Loginpage {

	private JFrame frame;	
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage window = new Loginpage();
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
	public Loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIhdc = new JLabel("IHDC Project Management Systems");
		lblIhdc.setForeground(Color.CYAN);
		lblIhdc.setFont(new Font("Vladimir Script", Font.ITALIC, 32));
		lblIhdc.setBounds(110, 31, 468, 39);
		frame.getContentPane().add(lblIhdc);
		
		JLabel lblEnterUsername = new JLabel("Enter Username:");
		lblEnterUsername.setForeground(Color.CYAN);
		lblEnterUsername.setBounds(110, 120, 118, 16);
		frame.getContentPane().add(lblEnterUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(240, 114, 147, 28);
		txtUsername.setText("");
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setForeground(Color.CYAN);
		lblEnterPassword.setBounds(110, 160, 115, 16);
		frame.getContentPane().add(lblEnterPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(240, 154, 147, 28);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");				
		btnLogin.setBounds(271, 194, 76, 28);
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if((txtUsername.getText().equals("lstein") ) && (txtPassword.getText().equals("comp380"))) {
					Mainpage main;
					try {
						main = new Mainpage();
						main.frame.setVisible(true);
						frame.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {					
					JOptionPane.showMessageDialog(frame, "Incorrect Username or Password!");
				}
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtUsername.getText().equals("lstein") ) && (txtPassword.getText().equals("comp380"))) {
					Mainpage main;
					try {
						main = new Mainpage();
						main.frame.setVisible(true);
						frame.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {					
					JOptionPane.showMessageDialog(frame, "Incorrect Username or Password!");
				}
			}
		});
		frame.getContentPane().add(btnLogin);
		
	}

}
