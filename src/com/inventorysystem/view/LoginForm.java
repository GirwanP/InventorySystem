package com.inventorysystem.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.inventorysystem.dao.UserDao;
import com.inventorysystem.dao.UserDaoImpl;


import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JTextField userNameTxt;
	private JLabel lblPa;
	private JPasswordField passwordField;
	private JButton cancelBtn;
	private JButton LoginBtn;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginForm frame = new LoginForm(false);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LoginForm(boolean loginAsAdmin) {
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 35));
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getUserNameTxt());
		contentPane.add(getLblPa());
		contentPane.add(getPasswordField());
		contentPane.add(getCancelBtn());
		contentPane.add(getLoginBtn(loginAsAdmin));
		contentPane.add(getLblNewLabel());
		
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsername.setBounds(43, 35, 76, 27);
		}
		return lblUsername;
	}
	private JTextField getUserNameTxt() {
		if (userNameTxt == null) {
			userNameTxt = new JTextField();
			userNameTxt.setBounds(172, 35, 142, 27);
			userNameTxt.setColumns(10);
		}
		return userNameTxt;
	}
	private JLabel getLblPa() {
		if (lblPa == null) {
			lblPa = new JLabel("Password");
			lblPa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPa.setBounds(43, 93, 76, 27);
		}
		return lblPa;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(172, 93, 142, 27);
		}
		return passwordField;
	}
	private JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Cancel");
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					WelcomeFrame wf=new WelcomeFrame();
					wf.setVisible(true);
					dispose();
				}
			});
			cancelBtn.setBounds(101, 140, 94, 33);
		}
		return cancelBtn;
	}
	private JButton getLoginBtn(boolean loginAsAdmin) {
		if (LoginBtn == null) {
			LoginBtn = new JButton("Login");
			LoginBtn.setBounds(220, 140, 94, 33);
			LoginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					UserDao ud= new UserDaoImpl();
					String un=userNameTxt.getText();
					boolean[] a=ud.logIn(un, passwordField.getText());
				//	System.out.println("password: "+passwordField.getPassword().equals("admin"));
					System.out.println(a[0]+" "+a[1]);
					if(loginAsAdmin) {
						if(a[0]) {          //boolean for isAdmin?
							if( a[1]) {    //  boolean for loginSuccess
								AdminHome ah=new AdminHome(un);
								ah.setVisible(true);
								dispose();	
							}else {
								userNameTxt.setText("");
								passwordField.setText("");
								JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
							}
						}else {
							userNameTxt.setText("");
							passwordField.setText("");
							JOptionPane.showMessageDialog(null, "Entered username Doesnot have Administrative Privilage");
						}
					}else {
						if(a[1]) {
							CashierHome ch=new CashierHome(un);
							ch.setVisible(true);
							dispose();	
						}else { 
							userNameTxt.setText("");
							passwordField.setText("");
							JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
						}
					}
				}
			});
		}
		return LoginBtn;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Contact Administrator to create  a new account");
			lblNewLabel.setBounds(43, 196, 300, 20);
		}
		return lblNewLabel;
	}
}
