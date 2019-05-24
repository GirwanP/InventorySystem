package com.inventorysystem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inventorysystem.dao.BillDao;
import com.inventorysystem.dao.BillDaoImpl;
import com.inventorysystem.extraUtilities.ObjectPrinterClass;
import com.inventorysystem.model.Bill;
import com.inventorysystem.model.Product;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchBillForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblSearchBill;
	private JTextField billNoTxt;
	private JButton searchBtn;
	private JLabel lblBillNo;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton printBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBillForm frame = new SearchBillForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBillForm() {
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSearchBill());
		contentPane.add(getBillNoTxt());
		contentPane.add(getSearchBtn());
		contentPane.add(getLblBillNo());
		contentPane.add(getScrollPane());
		contentPane.add(getPrintBtn());
		
		printBtn.setVisible(false);
		populateTable();
		
	}

	private JLabel getLblSearchBill() {
		if (lblSearchBill == null) {
			lblSearchBill = new JLabel("Search Bill");
			lblSearchBill.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSearchBill.setBounds(244, 23, 93, 25);
		}
		return lblSearchBill;
	}
	private JTextField getBillNoTxt() {
		if (billNoTxt == null) {
			billNoTxt = new JTextField();
			billNoTxt.setBounds(210, 59, 145, 22);
			billNoTxt.setColumns(10);
		}
		return billNoTxt;
	}
	private JButton getSearchBtn() {
		if (searchBtn == null) {
			searchBtn = new JButton("Search");
			searchBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					 DefaultTableModel model=(DefaultTableModel)table.getModel();
					 int count=model.getRowCount();
					 int i=0;
					 boolean flagFoundId=false;
					 for(;i<count;i++) {
//						 System.out.println(model.getValueAt(i, 0));
//						 System.out.println("entry "+billNoTxt.getText());
						 if(model.getValueAt(i, 0).toString().equals(billNoTxt.getText().toString())) {
							 
							 Object[] rowFound=new Object[] {model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3)};
							 model.setRowCount(0);
							 model.addRow(rowFound);
//							 System.out.println("matching bill found");
							 flagFoundId=true;
							 break;
							
							// table.addRowSelectionInterval(i, i+1);
						 }
						 
					 }
					 if(flagFoundId) {
						 printBtn.setVisible(true);
						// System.out.println("bill detail is set into table");
					 }else {
						 JOptionPane.showMessageDialog(null, "Can not find Bill with specified bill no!");
					 }
				}
			});
			searchBtn.setIcon(new ImageIcon(new ImageIcon( SearchBillForm.class.getResource("/IconFiles/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			searchBtn.setBounds(398, 59, 99, 25);
		}
		return searchBtn;
	}
	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill No");
			lblBillNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBillNo.setBounds(91, 63, 71, 18);
		}
		return lblBillNo;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(56, 95, 460, 323);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					printBtn.setVisible(true);
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Bill No", "Customer Name", "Amount", "Date"
				}
			));
		}
		return table;
	}
	private JButton getPrintBtn() {
		if (printBtn == null) {
			printBtn = new JButton("Print");
			printBtn.setIcon(new ImageIcon(new ImageIcon(SearchBillForm.class.getResource("/IconFiles/print.png")).getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT)));
			printBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int id;
					if(!billNoTxt.getText().equals("")) {
						id=Integer.valueOf(billNoTxt.getText().toString());
//						System.out.println("searched with button");
					}else {
						id=(int)table.getValueAt(table.getSelectedRow(), 0);
//						System.out.println("searched by selection");
					}
					Bill b=new BillDaoImpl().getBillById(id);
					
					ObjectPrinterClass.printBill(b);
					
//					System.out.println(" is bill no"+b.getBillNo());
//					System.out.println("Cashier id="+b.getCashierId());
//					System.out.println("Customer Name: "+b.getCustomerName());
//					System.out.println("Billinng Date: "+b.getBillingDate());
//					System.out.println("Billing Amount: "+b.getBillAmount());
//					System.out.println("Bill disocunt: "+b.getaDiscount());
//					System.out.println("=========================");
//					List<Product> plist=b.getProductList();
//					for(Product p:plist) {
//						System.out.println("Product id: "+p.getId());
//						System.out.println("Product Name: "+p.getName());
//						System.out.println("MRP: "+p.getMRP());
//						System.out.println("Quantity: "+p.getQuantity());
//						System.out.println("Discount on Prodct: "+p.getDiscount());
//						
//					}
					populateTable();
					printBtn.setVisible(false);
					billNoTxt.setText("");
				}
			});
			printBtn.setBounds(421, 427, 98, 23);
		}
		return printBtn;
	}
	
	private void populateTable() {
		BillDao bdao=new BillDaoImpl();
		List<Bill> bills=new ArrayList<Bill>();
		bills=bdao.getAllBills();
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setRowCount(0);
		//table.edit
		
		for(Bill b:bills) {
			model.addRow(new Object[] {b.getBillNo(),b.getCustomerName(),b.getBillAmount(),b.getBillingDate()});
		}
		
		
	}
	
//	private Bill prepareBill() {
//		
//	}
}
