package com.inventorysystem.view;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;

import com.inventorysystem.dao.UserDao;
import com.inventorysystem.dao.UserDaoImpl;
import com.inventorysystem.model.User;

public class AddCashierForm extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblAddCashierDetail;
	private JLabel lblCashierId;
	private JTextField cashierIDTxt;
	private JLabel lblCashier;
	private JTextField cashierfNameTxt;
	private JLabel lblMobileNo;
	private JTextField mobileNoTxt;
	private JLabel lblAddress;
	private JTextField addressTxt;
	private JLabel lblEmail;
	private JTextField emailTxt;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblLastName;
	private JTextField cashierlNametxt;
	private JCheckBox isAdminChkbx;
	private JTextField userNametxt;
	private JLabel lblUsername;
	private JLabel lblBirthDate;
	private JDateChooser dateChooser;
	private JButton btnUpdateData;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddCashierForm frame = new AddCashierForm();
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
	public AddCashierForm() {
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblAddCashierDetail());
		contentPane.add(getLblCashierId());
		contentPane.add(getCashierIDTxt());
		contentPane.add(getLblCashier());
		contentPane.add(getCashierfNameTxt());
		contentPane.add(getLblMobileNo());
		contentPane.add(getMobileNoTxt());
		contentPane.add(getLblAddress());
		contentPane.add(getAddressTxt());
		contentPane.add(getLblEmail());
		contentPane.add(getEmailTxt());
		contentPane.add(getLblPassword());
		contentPane.add(getPasswordField());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnUpdate());
		contentPane.add(getBtnDelete());
		contentPane.add(getLblLastName());
		contentPane.add(getCashierlNametxt());
		contentPane.add(getIsAdminChkbx());
		contentPane.add(getUserNametxt());
		contentPane.add(getLblUsername());
		contentPane.add(getLblBirthDate());
		contentPane.add(getDateChooser());
		contentPane.add(getBtnUpdateData());
		contentPane.add(getBtnCancel());
		
		btnUpdateData.setVisible(false);
		btnCancel.setVisible(false);
		cashierIDTxt.setEnabled(false);
		
		populateTable();
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(394, 11, 380, 400);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Mobile No.", "Address", "Email", "Password"
				}
			));
		}
		return table;
	}
	private JLabel getLblAddCashierDetail() {
		if (lblAddCashierDetail == null) {
			lblAddCashierDetail = new JLabel("Add Cashier Detail");
			lblAddCashierDetail.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAddCashierDetail.setBounds(115, 11, 177, 25);
		}
		return lblAddCashierDetail;
	}
	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Cashier Id");
			lblCashierId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCashierId.setBounds(59, 61, 99, 22);
		}
		return lblCashierId;
	}
	private JTextField getCashierIDTxt() {
		if (cashierIDTxt == null) {
			cashierIDTxt = new JTextField();
			cashierIDTxt.setBounds(184, 62, 169, 22);
			cashierIDTxt.setColumns(10);
		}
		return cashierIDTxt;
	}
	private JLabel getLblCashier() {
		if (lblCashier == null) {
			lblCashier = new JLabel("First Name");
			lblCashier.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCashier.setBounds(59, 103, 99, 22);
		}
		return lblCashier;
	}
	private JTextField getCashierfNameTxt() {
		if (cashierfNameTxt == null) {
			cashierfNameTxt = new JTextField();
			cashierfNameTxt.setColumns(10);
			cashierfNameTxt.setBounds(184, 104, 169, 22);
		}
		return cashierfNameTxt;
	}
	private JLabel getLblMobileNo() {
		if (lblMobileNo == null) {
			lblMobileNo = new JLabel("Mobile No");
			lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMobileNo.setBounds(59, 190, 99, 22);
		}
		return lblMobileNo;
	}
	private JTextField getMobileNoTxt() {
		if (mobileNoTxt == null) {
			mobileNoTxt = new JTextField();
			mobileNoTxt.setColumns(10);
			mobileNoTxt.setBounds(184, 191, 169, 22);
		}
		return mobileNoTxt;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAddress.setBounds(59, 232, 99, 22);
		}
		return lblAddress;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setColumns(10);
			addressTxt.setBounds(184, 233, 169, 22);
		}
		return addressTxt;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmail.setBounds(59, 281, 99, 22);
		}
		return lblEmail;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setColumns(10);
			emailTxt.setBounds(184, 283, 169, 22);
		}
		return emailTxt;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPassword.setBounds(59, 340, 99, 22);
		}
		return lblPassword;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(184, 340, 169, 22);
		}
		return passwordField;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setIcon(new ImageIcon(new ImageIcon(AddCashierForm.class.getResource("/IconFiles/new-user.png")).getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT)));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					User u=prepareUserObject();
					UserDao udao=new UserDaoImpl();
					
					if(udao.addUser(u)) {
						JOptionPane.showMessageDialog(null, "successfully added user");
						populateTable();
						clearFields();
					}else {JOptionPane.showMessageDialog(null, "Failed to create user");}	
				}
			});
			btnAdd.setBounds(47, 399, 92, 23);
		}
		return btnAdd;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.setIcon(new ImageIcon(new ImageIcon(AddCashierForm.class.getResource("/IconFiles/refresh.png")).getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT)));
			
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "select a User First");
						return;
					}else {
						int row=table.getSelectedRow();
						int id=(int)table.getModel().getValueAt(row, 0);
						fillFields(id);	
					}
					btnUpdate.setVisible(false);
					btnAdd.setVisible(false);
					btnDelete.setVisible(false);
					cashierIDTxt.setEnabled(false);
					btnUpdateData.setVisible(true);
					btnCancel.setVisible(true);
				}
			});
			btnUpdate.setBounds(169, 399, 93, 23);
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.setIcon(new ImageIcon(new ImageIcon(AddCashierForm.class.getResource("/IconFiles/delete.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getSelectedRow()<0) {JOptionPane.showMessageDialog(null, "select user first");
						
					}else {
						int row=table.getSelectedRow();
						int id=(int)table.getModel().getValueAt(row, 0);
						UserDao udao=new UserDaoImpl();
						if(udao.removeUser(id)) {
							JOptionPane.showMessageDialog(null, "removed successfully");
							populateTable();
						}else {JOptionPane.showMessageDialog(null, "removal failed");}
					}
				}
			});
			btnDelete.setBounds(283, 399, 94, 23);
		}
		return btnDelete;
	}
	
	private void populateTable() {
		List<User> ulist= new ArrayList<User>();
		UserDao udao=new UserDaoImpl();
		ulist=udao.getAllUsers();
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setRowCount(0);
		
		for(User u:ulist) {
			model.addRow(new Object[] {u.getId(),u.getfName()+u.getlName(),u.getMobile(),u.getAddress(),u.getEmail()});
		}
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblLastName.setBounds(59, 147, 99, 22);
		}
		return lblLastName;
	}
	private JTextField getCashierlNametxt() {
		if (cashierlNametxt == null) {
			cashierlNametxt = new JTextField();
			cashierlNametxt.setColumns(10);
			cashierlNametxt.setBounds(184, 148, 169, 22);
		}
		return cashierlNametxt;
	}
	private JCheckBox getIsAdminChkbx() {
		if (isAdminChkbx == null) {
			isAdminChkbx = new JCheckBox("Creat as Admin");
			isAdminChkbx.setBounds(184, 369, 108, 23);
		}
		return isAdminChkbx;
	}
	private JTextField getUserNametxt() {
		if (userNametxt == null) {
			userNametxt = new JTextField();
			userNametxt.setColumns(10);
			userNametxt.setBounds(184, 316, 169, 22);
		}
		return userNametxt;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsername.setBounds(59, 314, 99, 22);
		}
		return lblUsername;
	}
	private JLabel getLblBirthDate() {
		if (lblBirthDate == null) {
			lblBirthDate = new JLabel("Birth Date");
			lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBirthDate.setBounds(59, 259, 99, 22);
		}
		return lblBirthDate;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(184, 259, 169, 22);
		}
		return dateChooser;
	}
	private JButton getBtnUpdateData() {
		if (btnUpdateData == null) {
			btnUpdateData = new JButton("Update data");
			btnUpdateData.setIcon(new ImageIcon(new ImageIcon(AddCashierForm.class.getResource("/IconFiles/refresh.png")).getImage().getScaledInstance(12,12, Image.SCALE_DEFAULT)));
			btnUpdateData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					User u=prepareUserObject();
					UserDao udao=new UserDaoImpl();
					if(udao.updateUser(u)) {
						JOptionPane.showMessageDialog(null, "successfully updated user data");
					}else {JOptionPane.showMessageDialog(null, "Unable to update data");
					}
					btnUpdateData.setVisible(false);
					btnAdd.setVisible(true);
					btnDelete.setVisible(true);
					btnUpdate.setVisible(true);
					populateTable();
					clearFields();
					cashierIDTxt.setEnabled(true);
					
				}
			});
			
			btnUpdateData.setBounds(143, 399, 119, 23);
		}
		return btnUpdateData;
	}
	
	private void fillFields(int id) {
		UserDao udao=new UserDaoImpl();
		User u=udao.getUserById(id);
		cashierIDTxt.setText(Integer.toString(u.getId()));
		cashierfNameTxt.setText(u.getfName());
		cashierlNametxt.setText(u.getlName());
		addressTxt.setText(u.getAddress());
		mobileNoTxt.setText(u.getMobile());
		emailTxt.setText(u.getEmail());
		dateChooser.setDate(u.getDob());
		userNametxt.setText(u.getUserName());
		passwordField.setText(u.getPassword());
		isAdminChkbx.setSelected(u.getIsAdmin());
		
	}
	private void clearFields() {
		cashierIDTxt.setText("");
		cashierfNameTxt.setText("");
		cashierlNametxt.setText("");
		addressTxt.setText("");
		mobileNoTxt.setText("");
		emailTxt.setText("");
		dateChooser.setDate(new Date(1955,01,01));
		userNametxt.setText("");
		passwordField.setText("");
		isAdminChkbx.setSelected(false);	
	}
	
	private User prepareUserObject() {
		User u=new User();
		//u.setId(Integer.parseInt(cashierIDTxt.getText()));
		//u.setId(8888);
		u.setfName(cashierfNameTxt.getText());
		u.setlName(cashierlNametxt.getText());
		u.setAddress(addressTxt.getText());
		u.setMobile(mobileNoTxt.getText());
		u.setEmail(emailTxt.getText());
		u.setPassword(passwordField.getText());
		u.setIsAdmin(isAdminChkbx.isSelected());
		u.setDob(new Date(1800,12,11));
		u.setUserName(userNametxt.getText());
		return u;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setIcon(new ImageIcon(new ImageIcon(AddCashierForm.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-error.png")).getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT)));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					btnUpdateData.setVisible(false);
					btnAdd.setVisible(true);
					btnDelete.setVisible(true);
					btnUpdate.setVisible(true);
					btnCancel.setVisible(false);
					populateTable();
					clearFields();
					cashierIDTxt.setEnabled(true);
				}
			});
			btnCancel.setBounds(272, 399, 119, 23);
		}
		return btnCancel;
	}
}
