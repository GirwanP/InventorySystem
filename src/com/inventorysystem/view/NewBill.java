package com.inventorysystem.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inventorysystem.dao.BillDao;
import com.inventorysystem.dao.BillDaoImpl;
import com.inventorysystem.dao.ProductDao;
import com.inventorysystem.dao.ProductDaoImpl;
import com.inventorysystem.extraUtilities.ObjectPrinterClass;
import com.inventorysystem.model.Bill;
import com.inventorysystem.model.Product;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class NewBill extends JFrame {

	private JPanel contentPane;
	private JLabel lblBillNo;
	private JTextField billNoTxt;
	private JLabel lblDate;
	private JTextField dateTxt;
	private JLabel lblCustomerName;
	private JTextField customerNameTxt;
	private JLabel lblName;
	private JTextField productNameTxt;
	private JLabel lblMrp;
	private JTextField mRPTxt;
	private JLabel lblQuantity;
	private JTextField quantityTxt;
	private JLabel lblDiscount;
	private JTextField discountTxt;
	private JLabel lblProductId;
	private JComboBox<Integer> productIDComboBox;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblTotal;
	private JTextField totalTxt;
	private JButton btnPrint;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblCashierName;
	private JLabel cashierNamelbl;
	
	List<Product> plist;
	float billTotal=0f;
	int cashierId;
	int billNo;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewBill frame = new NewBill(9999);
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
	public NewBill(int cid) {
		setTitle("New Bill");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBillNo());
		contentPane.add(getBillNoTxt());
		contentPane.add(getLblDate());
		contentPane.add(getDateTxt());
		contentPane.add(getLblCustomerName());
		contentPane.add(getCustomerNameTxt());
		contentPane.add(getLblName());
		contentPane.add(getProductNameTxt());
		contentPane.add(getLblMrp());
		contentPane.add(getMRPTxt());
		contentPane.add(getLblQuantity());
		contentPane.add(getQuantityTxt());
		contentPane.add(getLblDiscount());
		contentPane.add(getDiscountTxt());
		contentPane.add(getLblProductId());
		contentPane.add(getProductIDComboBox());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnRemove());
		contentPane.add(getLblTotal());
		contentPane.add(getTotalTxt());
		contentPane.add(getBtnPrint());
		contentPane.add(getScrollPane());
		contentPane.add(getLblCashierName());
		contentPane.add(getCashierNamelbl());
		
		cashierId=cid;
		loadStock();
		
	}
	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill No");
			lblBillNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBillNo.setBounds(10, 54, 65, 21);
		}
		return lblBillNo;
	}
	private JTextField getBillNoTxt() {
		if (billNoTxt == null) {
			billNoTxt = new JTextField();
			billNoTxt.setEnabled(false);
			billNoTxt.setBounds(142, 53, 98, 22);
			billNoTxt.setColumns(10);
		}
		return billNoTxt;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDate.setBounds(393, 53, 65, 21);
		}
		return lblDate;
	}
	private JTextField getDateTxt() {
		if (dateTxt == null) {
			dateTxt = new JTextField();
			dateTxt.setEnabled(false);
			dateTxt.setColumns(10);
			dateTxt.setBounds(474, 53, 157, 22);
		}
		return dateTxt;
	}
	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer Name");
			lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCustomerName.setBounds(10, 101, 104, 21);
		}
		return lblCustomerName;
	}
	private JTextField getCustomerNameTxt() {
		if (customerNameTxt == null) {
			customerNameTxt = new JTextField();
			customerNameTxt.setColumns(10);
			customerNameTxt.setBounds(142, 100, 150, 22);
		}
		return customerNameTxt;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Product Name");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblName.setBounds(10, 189, 104, 21);
		}
		return lblName;
	}
	private JTextField getProductNameTxt() {
		if (productNameTxt == null) {
			productNameTxt = new JTextField();
			productNameTxt.setEnabled(false);
			productNameTxt.setColumns(10);
			productNameTxt.setBounds(142, 183, 150, 22);
		}
		return productNameTxt;
	}
	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("MRP");
			lblMrp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMrp.setBounds(10, 232, 65, 21);
		}
		return lblMrp;
	}
	private JTextField getMRPTxt() {
		if (mRPTxt == null) {
			mRPTxt = new JTextField();
			mRPTxt.setEnabled(false);
			mRPTxt.setColumns(10);
			mRPTxt.setBounds(142, 226, 150, 22);
		}
		return mRPTxt;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuantity.setBounds(10, 312, 65, 21);
		}
		return lblQuantity;
	}
	private JTextField getQuantityTxt() {
		if (quantityTxt == null) {
			quantityTxt = new JTextField();
			quantityTxt.setColumns(10);
			quantityTxt.setBounds(142, 312, 150, 22);
		}
		return quantityTxt;
	}
	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("Discount on Product");
			lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDiscount.setBounds(10, 268, 134, 21);
		}
		return lblDiscount;
	}
	private JTextField getDiscountTxt() {
		if (discountTxt == null) {
			discountTxt = new JTextField();
			discountTxt.setColumns(10);
			discountTxt.setBounds(142, 268, 150, 22);
		}
		return discountTxt;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id");
			lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProductId.setBounds(10, 143, 65, 21);
		}
		return lblProductId;
	}
	private JComboBox<Integer> getProductIDComboBox() {
		if (productIDComboBox == null) {
			productIDComboBox = new JComboBox<Integer>();
			productIDComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int id=(int)productIDComboBox.getSelectedItem();
					ProductDao pdao=new ProductDaoImpl();
					Product p=pdao.getProductById(id);
					
					productNameTxt.setText(p.getName());
					mRPTxt.setText(Float.toString(p.getMRP()));
					discountTxt.setText(Float.toString(0.0f));
					quantityTxt.setText(Integer.toString(1));
				}
			});
//			productIDComboBox.addItemListener(new ItemListener() {
//				public void itemStateChanged(ItemEvent arg0) {
//					JOptionPane.showMessageDialog(null, "Item state changed-only once but message appears twice why? consult");
//					
//					int id=(int)productIDComboBox.getSelectedItem();
//					ProductDao pdao=new ProductDaoImpl();
//					Product p=pdao.getProductById(id);
//					
//					productNameTxt.setText(p.getName());
//					mRPTxt.setText(Float.toString(p.getMRP()));
//					discountTxt.setText(Float.toString(0.0f));
//					quantityTxt.setText(Integer.toString(1));
//					
//				}
//			});
//			DefaultComboBoxModel<Integer> model=new DefaultComboBoxModel<Integer>();
//			ProductDaoImpl pdao=new ProductDaoImpl();
//			List<Integer> pidList=pdao.getAllProductIds();
//			
//			for(Integer i:pidList) {
//				model.addElement(i);
//			}
//			productIDComboBox.setModel(model);
//			
			productIDComboBox.setBounds(142, 140, 150, 22);
			
			
		}
		return productIDComboBox;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					float mprice=Float.valueOf(mRPTxt.getText());
					int quant=(int)Integer.valueOf(quantityTxt.getText());
					float discount=Float.valueOf(discountTxt.getText());
					float price=quant*(((10000-discount*100)*mprice)/10000);
					
					Product p=new Product();
					p.setId(Integer.valueOf(productIDComboBox.getSelectedItem().toString()));
					p.setMRP(mprice);
					p.setQuantity(quant);
					p.setName(productNameTxt.getText());
					p.setDiscount(discount);
					plist.add(p);
					
					Object[] obj=new Object[] {quant,productNameTxt.getText(),mprice,price};
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.addRow(obj);
					billTotal+=price;
					totalTxt.setText(Float.toString(billTotal));
					
				}
			});
			btnAdd.setIcon(new ImageIcon(new ImageIcon(NewBill.class.getResource("/IconFiles/plus.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			btnAdd.setBounds(50, 396, 89, 23);
		}
		return btnAdd;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int row=table.getSelectedRow();
					if(row<0) {
						JOptionPane.showMessageDialog(null, "First select product to remove from Bill");
						}else {	
							DefaultTableModel model=(DefaultTableModel)table.getModel();
							plist.remove(model.getValueAt(row, 0));
							billTotal-=Float.valueOf(model.getValueAt(row,3 ).toString());
							totalTxt.setText(String.valueOf( billTotal));
							model.removeRow(table.getSelectedRow());
						}
				}
			});
			btnRemove.setIcon(new ImageIcon(new ImageIcon(NewBill.class.getResource("/IconFiles/cross.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			btnRemove.setBounds(199, 396, 115, 23);
		}
		return btnRemove;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTotal.setBounds(532, 397, 65, 21);
		}
		return lblTotal;
	}
	private JTextField getTotalTxt() {
		if (totalTxt == null) {
			totalTxt = new JTextField();
			totalTxt.setColumns(10);
			totalTxt.setBounds(613, 397, 150, 22);
		}
		return totalTxt;
	}
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Print");
			btnPrint.setIcon(new ImageIcon(new ImageIcon(NewBill.class.getResource("/IconFiles/print.png")).getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT)));
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getRowCount()>0) {
					
						Bill nb=new Bill();
						nb.setCashierId(cashierId);
						nb.setCustomerName(customerNameTxt.getText());
						nb.setBillAmount(billTotal);
						long date=(new Date()).getTime();
						nb.setBillingDate(new java.sql.Date(date));
						nb.setaDiscount(Float.valueOf( discountTxt.getText()));
						nb.setProductList(plist);
						
						BillDao bdao=new BillDaoImpl();
						if(bdao.addBill(nb)) {//print the bill as transaction is successful
							JOptionPane.showMessageDialog(null, "bill is loaded to database");
							ObjectPrinterClass.printBill(nb);
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(null, "Can not creaet Bill");
						}
					}else {
						JOptionPane.showMessageDialog(null, "No product on Bills");
					}
				}
			});
			btnPrint.setBounds(626, 427, 98, 23);
		}
		return btnPrint;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(393, 85, 369, 286);
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
					"Quantity", "Name", "MRP", "Price"
				}
			));
		}
		return table;
	}
	
	private void loadStock() {
		plist=new ArrayList<Product>();
		List<Product> plist1=new ArrayList<Product>();
		BillDaoImpl bd=new BillDaoImpl();
		billNo=bd.nextBillNo();
		billNoTxt.setText(Integer.toString(billNo));
		
		ProductDao pdao =new ProductDaoImpl();
		plist1=pdao.getAllProducts();
		
		DefaultComboBoxModel<Integer> model=new DefaultComboBoxModel<Integer>();
		for(Product p:plist1) {
			model.addElement(p.getId());
		}
		productIDComboBox.setModel(model);
		totalTxt.setText(Float.toString(0.00f));
		dateTxt.setText((new Date()).toLocaleString());
		
		cashierNamelbl.setText(Integer.toString(cashierId));
	}
	private JLabel getLblCashierName() {
		if (lblCashierName == null) {
			lblCashierName = new JLabel("Cashier Id :");
			lblCashierName.setBounds(10, 11, 65, 14);
		}
		return lblCashierName;
	}
	private JLabel getCashierNamelbl() {
		if (cashierNamelbl == null) {
			cashierNamelbl = new JLabel("Cashier Name:");
			cashierNamelbl.setBounds(80, 11, 64, 14);
		}
		return cashierNamelbl;
	}
}
