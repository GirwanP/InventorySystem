package com.inventorysystem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.SystemColor;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblFirstName;
	private JTextField fNametxt;
	private JLabel lblLastName;
	private JTextField lNametxt;
	private JLabel lblUsername;
	private JTextField usernameTxt;
	private JLabel lblPassword;
	private JLabel lblRetypePassword;
	private JLabel lblBirthdate;
	private JLabel lblAddress;
	private JPasswordField passwordField;
	private JPasswordField passwordRetypeField;
	private JTextField addressTxt;
	private JButton cancelBtn;
	private JButton registerBtn;
	private JLabel lblNewLabel;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblFirstName());
		contentPane.add(getFNametxt());
		contentPane.add(getLblLastName());
		contentPane.add(getLNametxt());
		contentPane.add(getLblUsername());
		contentPane.add(getUsernameTxt());
		contentPane.add(getLblPassword());
		contentPane.add(getLblRetypePassword());
		contentPane.add(getLblBirthdate());
		contentPane.add(getLblAddress());
		contentPane.add(getPasswordField());
		contentPane.add(getPasswordRetypeField());
		contentPane.add(getAddressTxt());
		contentPane.add(getCancelBtn());
		contentPane.add(getRegisterBtn());
		contentPane.add(getLblNewLabel());
		contentPane.add(getDateChooser());
	}

	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First Name : ");
			lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblFirstName.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblFirstName.setBounds(44, 28, 115, 22);
		}
		return lblFirstName;
	}
	private JTextField getFNametxt() {
		if (fNametxt == null) {
			fNametxt = new JTextField();
			fNametxt.setBackground(new Color(230, 230, 250));
			fNametxt.setBounds(198, 30, 180, 22);
			fNametxt.setColumns(10);
		}
		return fNametxt;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name : ");
			lblLastName.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblLastName.setBounds(44, 62, 115, 22);
		}
		return lblLastName;
	}
	private JTextField getLNametxt() {
		if (lNametxt == null) {
			lNametxt = new JTextField();
			lNametxt.setBackground(new Color(230, 230, 250));
			lNametxt.setColumns(10);
			lNametxt.setBounds(198, 64, 180, 22);
		}
		return lNametxt;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username : ");
			lblUsername.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsername.setBounds(44, 95, 115, 22);
		}
		return lblUsername;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setBackground(new Color(230, 230, 250));
			usernameTxt.setColumns(10);
			usernameTxt.setBounds(198, 97, 180, 22);
		}
		return usernameTxt;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password : ");
			lblPassword.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPassword.setBounds(44, 130, 115, 22);
		}
		return lblPassword;
	}
	private JLabel getLblRetypePassword() {
		if (lblRetypePassword == null) {
			lblRetypePassword = new JLabel("Retype Password : ");
			lblRetypePassword.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblRetypePassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRetypePassword.setBounds(32, 163, 127, 22);
		}
		return lblRetypePassword;
	}
	private JLabel getLblBirthdate() {
		if (lblBirthdate == null) {
			lblBirthdate = new JLabel("Birthdate : ");
			lblBirthdate.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblBirthdate.setHorizontalAlignment(SwingConstants.TRAILING);
			lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBirthdate.setBounds(44, 197, 115, 22);
		}
		return lblBirthdate;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address : ");
			lblAddress.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAddress.setBounds(44, 233, 115, 22);
		}
		return lblAddress;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBackground(new Color(255, 240, 245));
			passwordField.setBounds(198, 130, 180, 22);
		}
		return passwordField;
	}
	private JPasswordField getPasswordRetypeField() {
		if (passwordRetypeField == null) {
			passwordRetypeField = new JPasswordField();
			passwordRetypeField.setBackground(new Color(255, 240, 245));
			passwordRetypeField.setBounds(198, 166, 180, 22);
		}
		return passwordRetypeField;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setBackground(new Color(230, 230, 250));
			addressTxt.setColumns(10);
			addressTxt.setBounds(198, 233, 239, 90);
		}
		return addressTxt;
	}
	private JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Cancel");
			cancelBtn.setBackground(new Color(0, 0, 139));
			cancelBtn.setForeground(SystemColor.text);
			cancelBtn.setBounds(198, 345, 89, 30);
		}
		return cancelBtn;
	}
	private JButton getRegisterBtn() {
		if (registerBtn == null) {
			registerBtn = new JButton("Register");
			registerBtn.setForeground(SystemColor.text);
			registerBtn.setBackground(new Color(0, 0, 128));
			registerBtn.setBounds(309, 345, 89, 30);
		}
		return registerBtn;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Click Here to Login");
			lblNewLabel.setForeground(new Color(255, 215, 0));
			lblNewLabel.setToolTipText("Log In to account");
			lblNewLabel.setBounds(242, 387, 115, 22);
		}
		return lblNewLabel;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBackground(new Color(230, 230, 250));
			dateChooser.setBounds(198, 197, 180, 22);
		}
		return dateChooser;
	}
}
