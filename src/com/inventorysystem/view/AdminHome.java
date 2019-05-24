package com.inventorysystem.view;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;

import com.inventorysystem.dao.UserDaoImpl;
import com.inventorysystem.model.User;
import com.toedter.calendar.JDateChooser;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;


public class AdminHome extends JFrame {


	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblCreateBill;
	private JLabel lblSearchBill;
	private JLabel lblProductInformation;
	private JLabel lblSales;
	private JLabel lblExit;
	
	int adminId;
	String adminUsername;
	private JMenu mnQuickBill;
	private JMenuItem mntmChangePassword;
	private JMenuItem mntmMyProfile;
	private JMenuBar menuBar;
	
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
	private JLabel lblEmail;
	private JTextField emailTxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminHome frame = new AdminHome("developer");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//	}
		/**
		 * Create the frame.
		 */
		public AdminHome(String un) {
			setIconImage(Toolkit.getDefaultToolkit().getImage(AdminHome.class.getResource("/IconFiles/admin-with-cogwheels.png")));
			setTitle("Administrator");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 600);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(169, 169, 169));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			contentPane.add(getPanel());
			contentPane.add(getMenuBar_1());
			
			contentPane.add(getProfilePanel());
			contentPane.add(getChangePasswordPanel());
			
			profilePanel.setVisible(false);
			changePasswordPanel.setVisible(false);
			
			adminUsername=un;
			adminId=new UserDaoImpl().getUserId(un);
		}
		private JPanel getPanel() {
			if (panel == null) {
				panel = new JPanel();
				panel.setBackground(new Color(255, 127, 80));
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
				lblCreateBill = new JLabel("Cashier");
				lblCreateBill.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						AddCashierForm af=new AddCashierForm();
						af.setVisible(true);
					}
				});
				lblCreateBill.setIcon(new ImageIcon(new ImageIcon(AdminHome.class.getResource("/IconFiles/avatar.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
				lblCreateBill.setForeground(new Color(0, 0, 205));
				lblCreateBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblCreateBill.setBounds(159, 11, 119, 49);
			}
			return lblCreateBill;
		}
		private JLabel getLblSearchBill() {
			if (lblSearchBill == null) {
				lblSearchBill = new JLabel("Transaction");
				lblSearchBill.setIcon(new ImageIcon(new ImageIcon(AdminHome.class.getResource("/IconFiles/transaction.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
				lblSearchBill.setForeground(new Color(0, 0, 205));
				lblSearchBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblSearchBill.setBounds(290, 11, 119, 49);
			}
			return lblSearchBill;
		}
		private JLabel getLblProductInformation() {
			if (lblProductInformation == null) {
				lblProductInformation = new JLabel("Stock");
				lblProductInformation.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						StockUpdateForm sf=new StockUpdateForm();
						sf.setVisible(true);
					}
				});
				lblProductInformation.setIcon(new ImageIcon(new ImageIcon(AdminHome.class.getResource("/IconFiles/warehouse.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
				lblProductInformation.setForeground(new Color(0, 0, 205));
				lblProductInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblProductInformation.setBounds(419, 11, 119, 49);
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
				lblExit.setBounds(794, 9, 90, 49);
			}
			return lblExit;
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
			mntmChangePassword = new JMenuItem("change password");
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
				public void actionPerformed(ActionEvent e) {
					changeFieldEnabled(false);
					fillFields();
					profilePanel.setVisible(true);
				}
			});
		}
		return mntmMyProfile;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 71, 81, 21);
			menuBar.add(getMnQuickBill());
		}
		return menuBar;
	}
	
	private JPanel getProfilePanel() {
		if (profilePanel == null) {
			profilePanel = new JPanel();
			profilePanel.setLayout(null);
			profilePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			profilePanel.setBackground(new Color(0, 128, 128));
			profilePanel.setBounds(203, 112, 504, 437);
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
			profilePanel.add(getLblEmail());
			profilePanel.add(getEmailTxt());
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
			label_3.setBounds(44, 338, 115, 22);
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
			label_6.setBounds(44, 239, 115, 22);
		}
		return label_6;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBackground(new Color(255, 240, 245));
			passwordField.setBounds(198, 338, 180, 22);
		}
		return passwordField;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setColumns(10);
			addressTxt.setBackground(new Color(230, 230, 250));
			addressTxt.setBounds(198, 237, 239, 90);
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
			btnDismiss.setBounds(328, 371, 89, 30);
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
							u.setId(adminId);
							u.setfName(fNameTxt.getText());
							u.setlName(lNameTxt.getText());
							u.setAddress(addressTxt.getText());
							u.setDob(new Date(birthDateChooser.getDate().getDate()));
							u.setUserName(userNameTxt.getText());
							
							u.setPassword(new UserDaoImpl().getPassword(adminId));
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
			btnUpdate.setBounds(198, 371, 89, 30);
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
			changePasswordPanel.setBounds(269, 98, 372, 202);
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
						if(new UserDaoImpl().logIn(adminUsername, oldPasswordField.getText())[1]) {
							if(new UserDaoImpl().changePassword(newPasswordField.getText(), adminId)) {
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
		User u=new UserDaoImpl().getUserById(adminId);
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
					clearChangePasswordFields();
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
			lblMobileNo = new JLabel("Mobile no : ");
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
			mobileNotxt.setEnabled(false);
			mobileNotxt.setColumns(10);
			mobileNotxt.setBackground(new Color(230, 230, 250));
			mobileNotxt.setBounds(198, 168, 180, 22);
		}
		return mobileNotxt;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email : ");
			lblEmail.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmail.setBounds(44, 203, 115, 22);
		}
		return lblEmail;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setEnabled(false);
			emailTxt.setColumns(10);
			emailTxt.setBackground(new Color(230, 230, 250));
			emailTxt.setBounds(198, 206, 180, 22);
		}
		return emailTxt;
	}
}
