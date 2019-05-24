package com.inventorysystem.extraUtilities;

import java.util.List;

import com.inventorysystem.model.Bill;
import com.inventorysystem.model.Product;
import com.inventorysystem.view.PrinterViewFrame;

public class ObjectPrinterClass {
	
	
	public static void printBill(Bill b) {
		PrinterViewFrame pvf=new PrinterViewFrame(b);
		pvf.setVisible(true);
		
//		System.out.println("Bill no: "+b.getBillNo());
//		System.out.println("Cashier Id: "+b.getCashierId());
//		System.out.println("Customer Name: "+b.getCustomerName());
//		System.out.println("Billing date: "+b.getBillingDate());
//		System.out.println("Bill Amount: "+b.getBillAmount());
//		System.out.println("Discount on bill: ");
//		List<Product> plist= b.getProductList();
//		for(Product p:plist) {
//			System.out.println("Product Id: "+ p.getId()+"//t Product Name: "+p.getName());
//			//System.out.print("Product Name: "+p.getName());
//			System.out.print("MRP: "+p.getMRP());
//			System.out.print("Quantity: "+p.getQuantity());
//			System.out.print("Discount on Product"+p.getDiscount());
//		}
		
	}

}
