package com.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.inventorysystem.activationjob.ActivationStatusChecker;
import com.inventorysystem.activationjob.PkActivate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;

public class ActivationWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblProductKey;
	private JTextField productKey;
	private JButton btnActivate;
	
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ActivationWindow frame = new ActivationWindow();
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
	public ActivationWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProductKey());
		contentPane.add(getProductKey());
		contentPane.add(getBtnActivate());
		
	
	}
	private JLabel getLblProductKey() {
		if (lblProductKey == null) {
			lblProductKey = new JLabel("Product Key");
			lblProductKey.setBounds(47, 90, 77, 20);
		}
		return lblProductKey;
	}
	private JTextField getProductKey() {
		if (productKey == null) {
			productKey = new JTextField();
			productKey.setBounds(144, 90, 156, 20);
			productKey.setColumns(10);
		}
		return productKey;
	}
	private JButton getBtnActivate() {
		if (btnActivate == null) {
			btnActivate = new JButton("Activate");
			btnActivate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String entKey=productKey.getText();
					boolean validpk=new PkActivate().activate(entKey);
					if(validpk) {
						JOptionPane.showMessageDialog(null,"Product Activated");
						ActivationStatusChecker asc=new ActivationStatusChecker();
						asc.hasActivated();
						WelcomeFrame frame = new WelcomeFrame();
						frame.setVisible(true);
						dispose();
					}else {
						productKey.setText("");
						JOptionPane.showMessageDialog(null,"Activation Failed");
					}
				}
			});
			btnActivate.setBounds(211, 132, 89, 23);
		}
		return btnActivate;
	}
}
