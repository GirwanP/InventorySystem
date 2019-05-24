package com.inventorysystem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inventorysystem.dao.ProductDao;
import com.inventorysystem.dao.ProductDaoImpl;
import com.inventorysystem.model.Product;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.util.List;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class StockUpdateForm extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUpdateStock;
	private JLabel lblProductId;
	private JTextField productIdTxt;
	private JTextField productNameTxt;
	private JLabel lblProductName;
	private JTextField qtyAvailableTxt;
	private JLabel lblQuantityAvailable;
	private JTextField qtyAddedTxt;
	private JLabel lblQuantityAdded;
	private JTextField mRPTxt;
	private JLabel lblMrp;
	private JButton btnNew;
	private JButton btnUpdate;
	private JScrollPane scrollPane;
	private JTable table;
	
	private int nextProductId;
	private JButton btnCancel;
	private JRadioButton rdbtnAdd;
	private JRadioButton rdbtnRemove;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnReset;
	private JButton btnRemoveProduct;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StockUpdateForm frame = new StockUpdateForm();
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
	public StockUpdateForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StockUpdateForm.class.getResource("/inventoryImages/fbfindmore.png")));
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getScrollPane());
		
		populateTable();
		productIdTxt.setEnabled(false);
		productIdTxt.setText(String.valueOf( nextProductId));
		
		btnUpdate.setVisible(false);
		rdbtnAdd.setVisible(false);
		rdbtnRemove.setVisible(false);
		btnRemoveProduct.setVisible(false);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 370, 461);
			panel.setLayout(null);
			panel.add(getLblUpdateStock());
			panel.add(getLblProductId());
			panel.add(getProductIdTxt());
			panel.add(getProductNameTxt());
			panel.add(getLblProductName());
			panel.add(getQtyAvailableTxt());
			panel.add(getLblQuantityAvailable());
			panel.add(getQtyAddedTxt());
			panel.add(getLblQuantityAdded());
			panel.add(getMRPTxt());
			panel.add(getLblMrp());
			panel.add(getBtnNew());
			panel.add(getBtnUpdate());
			panel.add(getBtnCancel());
			panel.add(getRdbtnAdd());
			panel.add(getRdbtnRemove());
			panel.add(getBtnReset());
			panel.add(getBtnRemoveProduct());
		}
		return panel;
	}
	private JLabel getLblUpdateStock() {
		if (lblUpdateStock == null) {
			lblUpdateStock = new JLabel("Update Stock");
			lblUpdateStock.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUpdateStock.setBounds(108, 22, 142, 36);
		}
		return lblUpdateStock;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id");
			lblProductId.setHorizontalAlignment(SwingConstants.RIGHT);
			lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProductId.setBounds(47, 87, 75, 22);
		}
		return lblProductId;
	}
	private JTextField getProductIdTxt() {
		if (productIdTxt == null) {
			productIdTxt = new JTextField();
			productIdTxt.setBounds(164, 88, 163, 25);
			productIdTxt.setColumns(10);
		}
		return productIdTxt;
	}
	private JTextField getProductNameTxt() {
		if (productNameTxt == null) {
			productNameTxt = new JTextField();
			productNameTxt.setColumns(10);
			productNameTxt.setBounds(164, 134, 163, 25);
		}
		return productNameTxt;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("Product Name");
			lblProductName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProductName.setBounds(19, 133, 103, 22);
		}
		return lblProductName;
	}
	private JTextField getQtyAvailableTxt() {
		if (qtyAvailableTxt == null) {
			qtyAvailableTxt = new JTextField();
			qtyAvailableTxt.setColumns(10);
			qtyAvailableTxt.setBounds(164, 179, 163, 25);
		}
		return qtyAvailableTxt;
	}
	private JLabel getLblQuantityAvailable() {
		if (lblQuantityAvailable == null) {
			lblQuantityAvailable = new JLabel("Quantity Available");
			lblQuantityAvailable.setHorizontalAlignment(SwingConstants.RIGHT);
			lblQuantityAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuantityAvailable.setBounds(10, 179, 112, 22);
		}
		return lblQuantityAvailable;
	}
	private JTextField getQtyAddedTxt() {
		if (qtyAddedTxt == null) {
			qtyAddedTxt = new JTextField();
			qtyAddedTxt.setColumns(10);
			qtyAddedTxt.setBounds(164, 225, 163, 25);
		}
		return qtyAddedTxt;
	}
	private JLabel getLblQuantityAdded() {
		if (lblQuantityAdded == null) {
			lblQuantityAdded = new JLabel("Quantity Altered");
			lblQuantityAdded.setHorizontalAlignment(SwingConstants.RIGHT);
			lblQuantityAdded.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuantityAdded.setBounds(10, 225, 112, 22);
		}
		return lblQuantityAdded;
	}
	private JTextField getMRPTxt() {
		if (mRPTxt == null) {
			mRPTxt = new JTextField();
			mRPTxt.setColumns(10);
			mRPTxt.setBounds(164, 281, 163, 25);
		}
		return mRPTxt;
	}
	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("MRP");
			lblMrp.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMrp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMrp.setBounds(-13, 264, 135, 56);
		}
		return lblMrp;
	}
	private JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton("New ");
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Product p=prepareProduct();
					ProductDao pdao=new ProductDaoImpl();
					if(pdao.addProduct(p)) {
						JOptionPane.showMessageDialog(null, "Succesfully Added Item to the Stock database");
					}else {
						JOptionPane.showMessageDialog(null, "Failed to update the stock database");
					}
					
					clearFields();//after updating stock
					populateTable();
				}
			});
			btnNew.setIcon(new ImageIcon(new ImageIcon(StockUpdateForm.class.getResource("/IconFiles/database.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
			btnNew.setBounds(10, 360, 103, 36);
		}
		return btnNew;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int itemAlt=Integer.valueOf(qtyAddedTxt.getText());
					if(rdbtnRemove.isSelected()) {
						itemAlt*=(-1);
					}
					
					  
					Product p=prepareProduct();
					p.setQuantity(itemAlt); // the called function takes takes quantity from directly without checkint add/remove button
					ProductDao pdao=new ProductDaoImpl();
					if(pdao.updateProduct(p)) {
						JOptionPane.showMessageDialog(null, "Stock updated successfully");
					}else {
						JOptionPane.showMessageDialog(null, "Unable to update the stock !Please Try again");
					}
					
					
					resetForm();// after updating the database
					populateTable();
				}
			});
			btnUpdate.setBounds(10, 360, 103, 36);
		}
		return btnUpdate;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(375, 29, 399, 380);
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
					//JOptionPane.showMessageDialog(null, "you clicked on table");
					//DefaultTableModel model=(DefaultTableModel)table.getModel();
					int rowsel=table.getSelectedRow();
					productIdTxt.setText(table.getValueAt(rowsel, 0).toString());
					productNameTxt.setText(table.getValueAt(rowsel, 1).toString());
					qtyAvailableTxt.setText(table.getValueAt(rowsel, 2).toString());
					mRPTxt.setText(table.getValueAt(rowsel, 3).toString());
					qtyAddedTxt.setText("0");
					
					productNameTxt.setEnabled(false);
					qtyAvailableTxt.setEnabled(false);
					btnUpdate.setVisible(true);
					rdbtnAdd.setVisible(true);
					rdbtnAdd.setSelected(true);
					rdbtnRemove.setVisible(true);
					btnRemoveProduct.setVisible(true);
					
					btnNew.setVisible(false);
					btnReset.setVisible(false);
					btnCancel.setVisible(true);
					table.clearSelection();
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
	
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setIcon(new ImageIcon(new ImageIcon(StockUpdateForm.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")).getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT)));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(btnUpdate.isVisible()) {
						resetForm();
						productIdTxt.setText(String.valueOf(nextProductId));
						
						//btnCancel.setVisible(tru);
						
					}else {
						dispose();
					}
					
				}
			});
			btnCancel.setBounds(257, 360, 103, 36);
		}
		return btnCancel;
	}
	private JRadioButton getRdbtnAdd() {
		if (rdbtnAdd == null) {
			rdbtnAdd = new JRadioButton("Add");
			buttonGroup.add(rdbtnAdd);
			rdbtnAdd.setBounds(164, 251, 57, 23);
		}
		return rdbtnAdd;
	}
	private JRadioButton getRdbtnRemove() {
		if (rdbtnRemove == null) {
			rdbtnRemove = new JRadioButton("Withdraw");
			buttonGroup.add(rdbtnRemove);
			rdbtnRemove.setBounds(223, 251, 89, 23);
		}
		return rdbtnRemove;
	}
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("Reset");
			btnReset.setIcon(new ImageIcon(new ImageIcon(StockUpdateForm.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")).getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT)));

			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clearFields();
				}
			});
			btnReset.setBounds(239, 317, 89, 22);
		}
		return btnReset;
	}
	

	private void populateTable() {
		ProductDao pdao=new ProductDaoImpl();
		List<Product> plist=pdao.getAllProducts();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		
		for(Product p:plist) {
			model.addRow(new Object[] {p.getId(),p.getName(),p.getQuantity(),p.getMRP()});
			nextProductId=p.getId()+1;
			
		}
		
	}
	private void clearFields() {
		productIdTxt.setText(String.valueOf(nextProductId));
		productNameTxt.setText("");
		qtyAvailableTxt.setText("");
		qtyAddedTxt.setText("");
		mRPTxt.setText("");
		
	}
	private void resetForm() {    // to keep  multiple windows under one frame---- create multiple functions to change state of elements as needed (make it act like constructor)
		clearFields();    //clear the fields and hide button
		btnUpdate.setVisible(false);
		btnNew.setVisible(true);
		btnReset.setVisible(true);
		productNameTxt.setVisible(true);
		qtyAvailableTxt.setVisible(true);;
		
		rdbtnAdd.setVisible(false);
		rdbtnRemove.setVisible(false);
		btnRemoveProduct.setVisible(false);
		
		productNameTxt.setEnabled(true);
		qtyAvailableTxt.setEnabled(true);
		
	}
	
	//private void updateState() {}  //form state when item selected from table
	
	private Product prepareProduct() {
		Product p=new Product();
		p.setDiscount(0);
		p.setId(Integer.valueOf(productIdTxt.getText()));
		p.setName(productNameTxt.getText());
		p.setMRP(Float.valueOf(mRPTxt.getText()));
		p.setQuantity(Integer.valueOf(qtyAvailableTxt.getText()));
		
		return p;
		
	}
	private JButton getBtnRemoveProduct() {
		if (btnRemoveProduct == null) {
			btnRemoveProduct = new JButton("Remove Product");
			btnRemoveProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnRemoveProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int conform=JOptionPane.showConfirmDialog(null, "This Product will be removed from the stock database");
					System.out.println(conform);
					if(conform==0) {
						ProductDao pdao=new ProductDaoImpl();
//						int row=table.getSelectedRow();
//						int id=Integer.valueOf(table.getValueAt(row, 0).toString());
						if(pdao.removeProduct(Integer.valueOf(productIdTxt.getText()))) {
							System.out.println("user accepted,conform="+conform);
							JOptionPane.showMessageDialog(null, "Product removed from stock Database");
						}else {
							JOptionPane.showMessageDialog(null, "Unable to remove the product from the database");
						}
					
					populateTable();
					resetForm();
					}else {
						System.out.println("canceled,conform="+conform);
					}
					
				}
			});
			btnRemoveProduct.setBounds(123, 360, 127, 36);
		}
		return btnRemoveProduct;
	}
}
