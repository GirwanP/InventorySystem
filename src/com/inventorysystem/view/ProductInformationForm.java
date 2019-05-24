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

import com.inventorysystem.dao.ProductDao;
import com.inventorysystem.dao.ProductDaoImpl;
import com.inventorysystem.model.Product;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductInformationForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblProduct;
	private JTextField productTxt;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton printBtn;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProductInformationForm frame = new ProductInformationForm();
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
	public ProductInformationForm() {
		setTitle("Product Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblProduct());
		contentPane.add(getProductTxt());
		contentPane.add(getBtnSearch());
		contentPane.add(getScrollPane());
		contentPane.add(getPrintBtn());
		
		printBtn.setVisible(false);
		
		populateTable();
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Product Information");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(270, 29, 274, 27);
		}
		return lblNewLabel;
	}
	private JLabel getLblProduct() {
		if (lblProduct == null) {
			lblProduct = new JLabel("Product");
			lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProduct.setBounds(126, 67, 82, 18);
		}
		return lblProduct;
	}
	private JTextField getProductTxt() {
		if (productTxt == null) {
			productTxt = new JTextField();
			productTxt.setBounds(282, 67, 151, 22);
			productTxt.setColumns(10);
		}
		return productTxt;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					 DefaultTableModel model=(DefaultTableModel)table.getModel();
					 int count=model.getRowCount();
					 int i=0;
					 boolean flagFoundId=false;
					 for(;i<count;i++) {
						 System.out.println(model.getValueAt(i, 0));
						 System.out.println("entry "+productTxt.getText());
						 if(model.getValueAt(i, 0).toString().equals(productTxt.getText().toString())) {
							 
							 Object[] rowFound=new Object[] {model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3)};
							 model.setRowCount(0);
							 model.addRow(rowFound);
							 System.out.println("matching bill found");
							 flagFoundId=true;
							 break;
							
							// table.addRowSelectionInterval(i, i+1);
						 }
						 
					 }
					 if(flagFoundId) {
						 printBtn.setVisible(true);
						 System.out.println("Product information is set into table");
					 }else {
						 JOptionPane.showMessageDialog(null, "Can not find any Product with specified bill no!");
					 }
				}
			});
			btnSearch.setIcon(new ImageIcon(new ImageIcon( ProductInformationForm.class.getResource("/IconFiles/search.png")).getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT)));
			btnSearch.setBounds(494, 67, 102, 23);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(98, 96, 577, 326);
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
					"Product Id", "Product Name", "Available", "MRP"
				}
			));
		}
		return table;
	}
	
	private JButton getPrintBtn() {
		if (printBtn == null) {
			printBtn = new JButton("Print");
			printBtn.setIcon(new ImageIcon(new ImageIcon(ProductInformationForm.class.getResource("/IconFiles/print.png")).getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT)));
			printBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int id;
					if(!productTxt.getText().equals("")) {
						id=Integer.valueOf(productTxt.getText().toString());
						System.out.println("searched with button");
					}else {
						id=(int)table.getValueAt(table.getSelectedRow(), 0);
						System.out.println("searched by selection");
					}
//					Bill b=new BillDaoImpl().getBillById(id);
//					System.out.println(" is bill no"+b.getBillNo());
//					System.out.println("Cashier id="+b.getCashierId());
//					System.out.println("Customer Name: "+b.getCustomerName());
//					System.out.println("Billinng Date: "+b.getBillingDate());
//					System.out.println("Billing Amount: "+b.getBillAmount());
//					System.out.println("Bill disocunt: "+b.getaDiscount());
//					System.out.println("=========================");
//					List<Product> plist=b.getProductList();
//					for(Product p:plist) {
						Product p=new ProductDaoImpl().getProductById(id);
						if(p.equals(null)) {System.out.println("Product not found of that index");}
						System.out.println("Product id: "+p.getId());
						System.out.println("Product Name: "+p.getName());
						System.out.println("MRP: "+p.getMRP());
						System.out.println("Quantity: "+p.getQuantity());
						System.out.println("Discount on Prodct: "+p.getDiscount());
						
//					}
					populateTable();
					printBtn.setVisible(false);
					productTxt.setText("");
				}
			});
			printBtn.setBounds(577, 433, 98, 23);
		}
		return printBtn;
	}
	
	private void populateTable() {
		ProductDao pdao=new ProductDaoImpl();
		List<Product> plist =new ArrayList<Product>();
		plist=pdao.getAllProducts();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setRowCount(0);
		
		for(Product p:plist) {
			model.addRow(new Object[] {p.getId(),p.getName(),p.getQuantity(),p.getMRP()});
		}
		
	}
}
