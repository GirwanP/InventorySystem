package com.inventorysystem.dao;

import java.util.List;

import com.inventorysystem.model.Bill;

public interface BillDao {
	boolean addBill(Bill b);
	boolean removeBill(int id);
	Bill getBillById(int id);
	List<Bill> getAllBills();
	boolean updateBill(Bill b);

}
