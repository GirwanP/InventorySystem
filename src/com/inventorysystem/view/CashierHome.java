package com.inventorysystem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.inventorysystem.dao.UserDaoImpl;
import com.inventorysystem.model.User;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierHome extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblCreateBill;
	private JLabel lblSearchBill;
	private JLabel lblProductInformation;
	private JLabel lblSales;
	private JLabel lblExit;
	private JMenuBar menuBar;
	private JMenu mnQuickBill;
	private JMenuItem mntmChangePassword;
	private JMenuItem mntmMyProfile;
	
	private JPanel profilePanel;
	private JLabel label;
	private JTextField fNameTxt;
	private JLabel label_1;
	private JTextField lNameTxt;
	private JLabel label_2;
	private JTextField userNameTxt;
	private JLabel label_3;
	private JLabel label_5;
	private JLabel label_6;
	private JPasswordField passwordField;
	private JTextField addressTxt;
	private JButton btnDismiss;
	private JButton btnUpdate;
	private JDateChooser birthDateChooser;
	
	private JPasswordField oldPasswordField;
	private JPasswordField retypePasswordField;
	private JLabel lblOldPassword;
	private JLabel lblRetypeNewPassword;
	private JPanel changePasswordPanel;
	private JLabel lblNewPassword;
	private JPasswordField newPasswordField;
	private JButton btnSave;
	private JButton btnClose;
	private JLabel lblMobileNo;
	private JTextField mobileNotxt;
	private JTextField emailTxt;
	private JLabel lblEmail;
	
	int cashierId;
	String cashierUsername;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CashierHome frame = new CashierHome("developer");
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
	public CashierHome(String  un) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CashierHome.class.getResource("/IconFiles/cashier.png")));
		setBackground(new Color(0, 128, 128));
		setTitle("Cashier");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getMenuBar_1());
		
		contentPane.add(getProfilePanel());
		contentPane.add(getChangePasswordPanel());
		
		profilePanel.setVisible(false);
		changePasswordPanel.setVisible(false);
		
		cashierId=(new UserDaoImpl().getUserId(un));
		cashierUsername=un;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(60, 179, 113));
			panel.setBounds(0, 0, 894, 71);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblCreateBill());
			panel.add(getLblSearchBill());
			panel.add(getLblProductInformation());
			panel.add(getLblSales());
			panel.add(getLblExit());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Quick Bill");
			lblNewLabel.setBounds(10, 11, 119, 49);
		}
		return lblNewLabel;
	}
	private JLabel getLblCreateBill() {
		if (lblCreateBill == null) {
			lblCreateBill = new JLabel("Create Bill");
			lblCreateBill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					NewBill nb=new NewBill(cashierId);
					nb.setVisible(true);
				}
			});
			lblCreateBill.setIcon(new ImageIcon(new ImageIcon( CashierHome.class.getResource("/IconFiles/new.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			lblCreateBill.setForeground(new Color(0, 0, 205));
			lblCreateBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCreateBill.setBounds(159, 11, 119, 49);
		}
		return lblCreateBill;
	}
	private JLabel getLblSearchBill() {
		if (lblSearchBill == null) {
			lblSearchBill = new JLabel("Search Bill");
			lblSearchBill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SearchBillForm sf=new SearchBillForm();
					sf.setVisible(true);
				}
			});
			lblSearchBill.setIcon(new ImageIcon(new ImageIcon(CashierHome.class.getResource("/IconFiles/search.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			lblSearchBill.setForeground(new Color(0, 0, 205));
			lblSearchBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSearchBill.setBounds(290, 11, 119, 49);
		}
		return lblSearchBill;
	}
	private JLabel getLblProductInformation() {
		if (lblProductInformation == null) {
			lblProductInformation = new JLabel("Product Information");
			lblProductInformation.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ProductInformationForm pif=new ProductInformationForm();
					pif.setVisible(true);
				}
			});
			lblProductInformation.setForeground(new Color(0, 0, 205));
			lblProductInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblProductInformation.setBounds(419, 11, 130, 49);
		}
		return lblProductInformation;
	}
	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("Sales");
			lblSales.setIcon(new ImageIcon(new ImageIcon( CashierHome.class.getResource("/IconFiles/money-bag.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			lblSales.setForeground(new Color(0, 0, 205));
			lblSales.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSales.setBounds(584, 11, 119, 49);
		}
		return lblSales;
	}
	private JLabel getLblExit() {
		if (lblExit == null) {
			lblExit = new JLabel("Log Out");
			lblExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					WelcomeFrame wf=new WelcomeFrame();
					dispose();
					wf.setVisible(true);
				}
			});
			lblExit.setIcon(new ImageIcon(new ImageIcon(AdminHome.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			lblExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblExit.setBounds(794, 11, 90, 49);
		}
		return lblExit;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 71, 81, 21);
			menuBar.add(getMnQuickBill());
		}
		return menuBar;
	}
	private JMenu getMnQuickBill() {
		if (mnQuickBill == null) {
			mnQuickBill = new JMenu("Quick Bill");
			mnQuickBill.add(getMntmChangePassword());
			mnQuickBill.add(getMntmMyProfile());
		}
		return mnQuickBill;
	}
	private JMenuItem getMntmChangePassword() {
		if (mntmChangePassword == null) {
			mntmChangePassword = new JMenuItem("Change Password");
			mntmChangePassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					changePasswordPanel.setVisible(true);
				}
			});
		}
		return mntmChangePassword;
	}
	private JMenuItem getMntmMyProfile() {
		if (mntmMyProfile == null) {
			mntmMyProfile = new JMenuItem("My Profile");
			mntmMyProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					changeFieldEnabled(false);
					fillFields();
					profilePanel.setVisible(true);
				}
			});
		}
		return mntmMyProfile;
	}
	private JPanel getProfilePanel() {
		if (profilePanel == null) {
			profilePanel = new JPanel();
			profilePanel.setLayout(null);
			profilePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			profilePanel.setBackground(new Color(0, 128, 128));
			profilePanel.setBounds(179, 108, 504, 437);
			profilePanel.add(getLabel());
			profilePanel.add(getFNameTxt());
			profilePanel.add(getLabel_1());
			profilePanel.add(getLNameTxt());
			profilePanel.add(getLabel_2());
			profilePanel.add(getUserNameTxt());
			profilePanel.add(getLabel_3());
			profilePanel.add(getLabel_5());
			profilePanel.add(getLabel_6());
			profilePanel.add(getPasswordField());
			profilePanel.add(getAddressTxt());
			profilePanel.add(getBtnDismiss());
			profilePanel.add(getBtnUpdate());
			profilePanel.add(getBirthDateChooser());
			profilePanel.add(getLblMobileNo());
			profilePanel.add(getMobileNotxt());
			profilePanel.add(getEmailTxt());
			profilePanel.add(getLblEmail());
		}
		return profilePanel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("First Name : ");
			label.setHorizontalTextPosition(SwingConstants.RIGHT);
			label.setHorizontalAlignment(SwingConstants.TRAILING);
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(44, 28, 115, 22);
		}
		return label;
	}
	private JTextField getFNameTxt() {
		if (fNameTxt == null) {
			fNameTxt = new JTextField();
			fNameTxt.setColumns(10);
			fNameTxt.setBackground(new Color(230, 230, 250));
			fNameTxt.setBounds(198, 30, 180, 22);
		}
		return fNameTxt;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Last Name : ");
			label_1.setHorizontalTextPosition(SwingConstants.RIGHT);
			label_1.setHorizontalAlignment(SwingConstants.TRAILING);
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_1.setBounds(44, 62, 115, 22);
		}
		return label_1;
	}
	private JTextField getLNameTxt() {
		if (lNameTxt == null) {
			lNameTxt = new JTextField();
			lNameTxt.setColumns(10);
			lNameTxt.setBackground(new Color(230, 230, 250));
			lNameTxt.setBounds(198, 64, 180, 22);
		}
		return lNameTxt;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Username : ");
			label_2.setHorizontalTextPosition(SwingConstants.RIGHT);
			label_2.setHorizontalAlignment(SwingConstants.TRAILING);
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_2.setBounds(44, 95, 115, 22);
		}
		return label_2;
	}
	private JTextField getUserNameTxt() {
		if (userNameTxt == null) {
			userNameTxt = new JTextField();
			userNameTxt.setEnabled(false);
			userNameTxt.setColumns(10);
			userNameTxt.setBackground(new Color(230, 230, 250));
			userNameTxt.setBounds(198, 98, 180, 22);
		}
		return userNameTxt;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Password : ");
			label_3.setHorizontalTextPosition(SwingConstants.RIGHT);
			label_3.setHorizontalAlignment(SwingConstants.TRAILING);
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_3.setBounds(44, 347, 115, 22);
		}
		return label_3;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("Birthdate : ");
			label_5.setHorizontalTextPosition(SwingConstants.RIGHT);
			label_5.setHorizontalAlignment(SwingConstants.TRAILING);
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_5.setBounds(44, 132, 115, 22);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("Address : ");
			label_6.setHorizontalTextPosition(SwingConstants.RIGHT);
			label_6.setHorizontalAlignment(SwingConstants.TRAILING);
			label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_6.setBounds(45, 248, 115, 22);
		}
		return label_6;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBackground(new Color(255, 240, 245));
			passwordField.setBounds(198, 347, 180, 22);
		}
		return passwordField;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setColumns(10);
			addressTxt.setBackground(new Color(230, 230, 250));
			addressTxt.setBounds(199, 246, 239, 90);
		}
		return addressTxt;
	}
	private JButton getBtnDismiss() {
		if (btnDismiss == null) {
			btnDismiss = new JButton("Dismiss");
			btnDismiss.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(btnDismiss.getText().equals("Cancel")) {
						
						btnDismiss.setText("Dismiss");
						btnUpdate.setText("Update");
						fillFields();
						changeFieldEnabled(false);
					}else {
						profilePanel.setVisible(false);
						//btnDismiss.setText("Cancel");
					}
				}
			});
			btnDismiss.setForeground(Color.WHITE);
			btnDismiss.setBackground(new Color(0, 0, 139));
			btnDismiss.setBounds(328, 380, 89, 30);
		}
		return btnDismiss;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(btnUpdate.getText().equals("Update")) {
						btnUpdate.setText("Save");
						btnDismiss.setText("Cancel");
						changeFieldEnabled(true);
					}else {
						//update user data in database
						if(new UserDaoImpl().logIn(userNameTxt.getText(), passwordField.getText())[1]){  //login to check password
							
							User u=new User();
							u.setId(cashierId);
							u.setfName(fNameTxt.getText());
							u.setlName(lNameTxt.getText());
							u.setAddress(addressTxt.getText());
							u.setDob(new Date(birthDateChooser.getDate().getDate()));
							u.setUserName(userNameTxt.getText());
							
							u.setPassword(new UserDaoImpl().getPassword(cashierId));
							u.setEmail(emailTxt.getText());
							u.setMobile(mobileNotxt.getText());
							if(new UserDaoImpl().isAdmin(userNameTxt.getText())) {
								u.setIsAdmin(true);
							}else {
								u.setIsAdmin(false);}
							if(new UserDaoImpl().updateUser(u)) {
								JOptionPane.showMessageDialog(null, "Data successfully updated");
							}else {
								JOptionPane.showMessageDialog(null, "Data update failed");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect Password");
						}
						passwordField.setText("");
						fillFields();
						changeFieldEnabled(false);
						btnUpdate.setText("Update");
						btnDismiss.setText("Dismiss");
					}
				}
			});
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setBackground(new Color(0, 0, 128));
			btnUpdate.setBounds(198, 380, 89, 30);
		}
		return btnUpdate;
	}
	private JDateChooser getBirthDateChooser() {
		if (birthDateChooser == null) {
			birthDateChooser = new JDateChooser();
			birthDateChooser.setBackground(new Color(230, 230, 250));
			birthDateChooser.setBounds(198, 132, 180, 22);
		}
		return birthDateChooser;
	}
	private JPasswordField getOldPasswordField() {
		if (oldPasswordField == null) {
			oldPasswordField = new JPasswordField();
			oldPasswordField.setBounds(168, 25, 180, 22);
			oldPasswordField.setBackground(new Color(255, 240, 245));
		}
		return oldPasswordField;
	}
	private JPasswordField getRetypePasswordField() {
		if (retypePasswordField == null) {
			retypePasswordField = new JPasswordField();
			retypePasswordField.setBounds(171, 109, 180, 22);
			retypePasswordField.setBackground(new Color(255, 240, 245));
		}
		return retypePasswordField;
	}
	private JLabel getLblOldPassword() {
		if (lblOldPassword == null) {
			lblOldPassword = new JLabel("Old Password : ");
			lblOldPassword.setBounds(44, 26, 115, 22);
			lblOldPassword.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblOldPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblOldPassword;
	}
	private JLabel getLblRetypeNewPassword() {
		if (lblRetypeNewPassword == null) {
			lblRetypeNewPassword = new JLabel("Retype New Password : ");
			lblRetypeNewPassword.setBounds(10, 107, 149, 22);
			lblRetypeNewPassword.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblRetypeNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblRetypeNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblRetypeNewPassword;
	}
	private JPanel getChangePasswordPanel() {
		if (changePasswordPanel == null) {
			changePasswordPanel = new JPanel();
			changePasswordPanel.setBounds(243, 92, 372, 202);
			changePasswordPanel.setLayout(null);
			changePasswordPanel.add(getOldPasswordField());
			changePasswordPanel.add(getRetypePasswordField());
			changePasswordPanel.add(getLblOldPassword());
			changePasswordPanel.add(getLblRetypeNewPassword());
			changePasswordPanel.add(getLblNewPassword());
			changePasswordPanel.add(getNewPasswordField());
			changePasswordPanel.add(getBtnSave());
			changePasswordPanel.add(getBtnClose());
		}
		return changePasswordPanel;
	}
	private JLabel getLblNewPassword() {
		if (lblNewPassword == null) {
			lblNewPassword = new JLabel("New Password : ");
			lblNewPassword.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewPassword.setBounds(32, 67, 127, 22);
		}
		return lblNewPassword;
	}
	private JPasswordField getNewPasswordField() {
		if (newPasswordField == null) {
			newPasswordField = new JPasswordField();
			newPasswordField.setBackground(new Color(255, 240, 245));
			newPasswordField.setBounds(171, 69, 180, 22);
		}
		return newPasswordField;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(newPasswordField.getText().equals(retypePasswordField.getText())) {
						if(new UserDaoImpl().logIn(cashierUsername, oldPasswordField.getText())[1]) {
							if(new UserDaoImpl().changePassword(newPasswordField.getText(), cashierId)) {
								changePasswordPanel.setVisible(false);
								clearChangePasswordFields();
								JOptionPane.showMessageDialog(null, "Password change successfully");
								
							}else {
								clearChangePasswordFields();
			
								
								JOptionPane.showMessageDialog(null, "Unable to change Password!Please Try again");}
						}
					}else {
						clearChangePasswordFields();
						JOptionPane.showMessageDialog(null, "Please give consistent password values at both fields");
						newPasswordField.grabFocus();
					}
					
				}
			});
			btnSave.setForeground(Color.WHITE);
			btnSave.setBackground(new Color(0, 0, 128));
			btnSave.setBounds(171, 146, 89, 30);
		}
		return btnSave;
	}
	
	private void changeFieldEnabled(boolean b) {
		fNameTxt.setEnabled(b);
		lNameTxt.setEnabled(b);
		birthDateChooser.setEnabled(b);
		addressTxt.setEnabled(b);
		passwordField.setEnabled(b);
		emailTxt.setEnabled(b);
		mobileNotxt.setEnabled(b);
	}
	
	private void fillFields() {
		User u=new UserDaoImpl().getUserById(cashierId);
		fNameTxt.setText(u.getfName());
		lNameTxt.setText(u.getlName());
		userNameTxt.setText(u.getUserName());
		birthDateChooser.setDate(u.getDob());
		addressTxt.setText(u.getAddress());
		emailTxt.setText(u.getEmail());
		mobileNotxt.setText(u.getMobile());
		
	}
	
	private void clearChangePasswordFields() {
		oldPasswordField.setText("");
		newPasswordField.setText("");
		retypePasswordField.setText("");
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					changePasswordPanel.setVisible(false);
				}
			});
			btnClose.setForeground(Color.WHITE);
			btnClose.setBackground(new Color(0, 0, 128));
			btnClose.setBounds(273, 146, 89, 30);
		}
		return btnClose;
	}
	private JLabel getLblMobileNo() {
		if (lblMobileNo == null) {
			lblMobileNo = new JLabel("Mobile No : ");
			lblMobileNo.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblMobileNo.setHorizontalAlignment(SwingConstants.TRAILING);
			lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMobileNo.setBounds(44, 165, 115, 22);
		}
		return lblMobileNo;
	}
	private JTextField getMobileNotxt() {
		if (mobileNotxt == null) {
			mobileNotxt = new JTextField();
			mobileNotxt.setColumns(10);
			mobileNotxt.setBackground(new Color(230, 230, 250));
			mobileNotxt.setBounds(198, 167, 180, 22);
		}
		return mobileNotxt;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setEnabled(false);
			emailTxt.setColumns(10);
			emailTxt.setBackground(new Color(230, 230, 250));
			emailTxt.setBounds(198, 201, 180, 22);
		}
		return emailTxt;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email : ");
			lblEmail.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmail.setBounds(44, 198, 115, 22);
		}
		return lblEmail;
	}
}
