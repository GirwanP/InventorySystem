package com.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.inventorysystem.model.Bill;
import com.inventorysystem.model.Product;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class PrinterViewFrame extends JFrame {
	private JPanel contentPane;
	private JLabel lblPrintPreview;
	private JTextPane textPane;
	private JButton btnPrint;
	
	private Bill b;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PrinterViewFrame frame = new PrinterViewFrame(new Bill());
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
	public PrinterViewFrame(Bill bi) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPrintPreview());
		contentPane.add(getTextPane());
		contentPane.add(getBtnPrint());
		
		b=bi;
		btnPrint.setVisible(false);// undhide later
		
		prepareBillIntxt();
//		System.out.println("this inside printer view frame constructor");
	}
	private JLabel getLblPrintPreview() {
		if (lblPrintPreview == null) {
			lblPrintPreview = new JLabel("Print Preview");
			lblPrintPreview.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrintPreview.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrintPreview.setBounds(161, 11, 245, 29);
		}
		return lblPrintPreview;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(63, 70, 496, 312);
		}
		return textPane;
	}
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Print");
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					try {
						textPane.print();
					} catch (PrinterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnPrint.setBounds(530, 393, 89, 23);
		}
		return btnPrint;
	}
	
	private void prepareBillIntxt() {
		String bs="";
		bs+="\n";
		bs+="\t\t\t\tDate : ";
		bs+=b.getBillingDate().toGMTString();
		bs+="\n Cashier Id : ";
		bs+=b.getCashierId();
		bs+="\n Bill N0. : ";
		bs+=b.getBillNo();
		bs+="\n Customer\'s Name : ";
		bs+=b.getCustomerName();
		bs+="\n Discount on bill : ";
		bs+=b.getaDiscount();
		bs+="\n Net Payable Amount : ";
		bs+=b.getBillAmount();
		bs+="\n";
		for(int i=0;i<30;i++) {bs+="-------";}
		bs+="\n";
		bs+="Product Id        Product Name        \t  Price   \t     Quantity  \t     Amount\n";
		for(int i=0;i<30;i++) {bs+="-------";}
		int l;
		List<Product> plist=b.getProductList();
		
		int lOfplist=0;
		for(Product p:plist) {
			lOfplist++;
			bs+="\n";
			bs+=p.getId();
			l=String.valueOf(p.getId()).length();
			for(int i=0;i<6-l;i++) {bs+=" ";}
			bs+="\t";
			bs+=p.getName();
			bs+="    ";
			
			l=p.getName().length();
			int ll=30-l;
			if(ll>20) {bs+="\t";}
			if(ll>15) {bs+="  ";}
			if(ll>10) {bs+="\t";}
//			for(int i=0;i<20-l;i++) {
//				bs+="   ";
//				//bs+=" ";
//				//bs+=" ";
//				for(int j=0;j<i-27;j++) {bs+=" ";}
//				}
			//bs+="\t";
			bs+=p.getMRP();
			bs+="/-";
//			bs+="  ";
			bs+="\t   ";
//			l=String.valueOf(p.getMRP()).length();
//			for(int i=0;i<15-l;i++) {
//				bs+="  ";
				//for(int j=0;j<i-8;j++) {bs+=" ";}
//			}
			//bs+="\t";
			bs+=p.getQuantity();
			bs+="\t   ";
//			l=String.valueOf(p.getQuantity()).length();
//			for(int i=0;i<14-l;i++) {
//				bs+="  ";
//				for(int j=0;j<i-9;j++) {bs+=" ";}}
			//bs+="\t";
			Float amount=p.getMRP()*p.getQuantity();
			bs+=amount;	
			bs+="/-";
		}
		if(lOfplist==0) {bs+="\n\t\t*****    The item list is not available    ******\n";}
		bs+="\n";
		for(int i=0;i<30;i++) {bs+="-----";}
		bs+="\n";
		bs+="\t\t\t\t";
		bs+="Bill total is : RS.";
		bs+=b.getBillAmount();
		bs+="/-";
		bs+="\n";
		//bs+="\t \t this is title \n";
		for(int i=0;i<30;i++) {bs+="-----";}
		bs+="\n";
		bs+="\t\t\t Thank You";
	
		textPane.setText(bs);	
	}
}
