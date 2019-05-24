package com.inventorysystem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.inventorysystem.activationjob.ActivationStatusChecker;
import com.inventorysystem.environmentManage.MultipleInstanceCheck;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblWelcomeToSupermarket;
	private JButton btnAdminLogin;
	private JButton btnCashierLogin;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					if(MultipleInstanceCheck.conformNotAlreadyRunning()) {
						MultipleInstanceCheck.logInstance();
					}else {
						JOptionPane.showMessageDialog(null, "Another Instance of the application is already running");
						return;
					}
				try {
					ActivationStatusChecker asc=new ActivationStatusChecker();
					boolean stat=asc.hasActivated();
					System.out.println(stat);
					if(!stat) {
						System.out.println("product is not activated");
						ActivationWindow aw=new ActivationWindow();
						aw.setVisible(true);
					}else {
					System.out.println("product is activated");
					WelcomeFrame frame = new WelcomeFrame();
					frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomeFrame.class.getResource("/IconFiles/menu.png")));
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 350);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblWelcomeToSupermarket());
		contentPane.add(getBtnAdminLogin());
		contentPane.add(getBtnCashierLogin());
		contentPane.add(getLblNewLabel());
	}

	private JLabel getLblWelcomeToSupermarket() {
		if (lblWelcomeToSupermarket == null) {
			lblWelcomeToSupermarket = new JLabel("Welcome to Supermarket Billig System");
			lblWelcomeToSupermarket.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblWelcomeToSupermarket.setBounds(88, 23, 389, 25);
		}
		return lblWelcomeToSupermarket;
	}
	private JButton getBtnAdminLogin() {
		if (btnAdminLogin == null) {
			btnAdminLogin = new JButton("Admin Login");
			btnAdminLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LoginForm lf =new LoginForm(true);
					lf.setVisible(true);
					dispose();
				}
			});
			btnAdminLogin.setBackground(new Color(240, 240, 240));
			btnAdminLogin.setIcon(new ImageIcon(new ImageIcon(AdminHome.class.getResource("/IconFiles/admin-with-cogwheels.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			
			btnAdminLogin.setBounds(362, 89, 145, 30);
		}
		return btnAdminLogin;
	}
	private JButton getBtnCashierLogin() {
		if (btnCashierLogin == null) {
			btnCashierLogin = new JButton("Cashier Login");
			btnCashierLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LoginForm lf=new LoginForm(false);
					lf.setVisible(true);
					dispose();
				}
			});
			btnCashierLogin.setIcon(new ImageIcon(new ImageIcon(AdminHome.class.getResource("/IconFiles/avatar.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			
			btnCashierLogin.setBounds(362, 148, 145, 30);
		}
		return btnCashierLogin;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Quick Bill");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
			lblNewLabel.setBounds(28, 89, 171, 122);
		}
		return lblNewLabel;
	}
}
