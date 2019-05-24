package com.inventorysystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inventorysystem.db.Db;
import com.inventorysystem.model.Bill;
import com.inventorysystem.model.Product;

public class BillDaoImpl implements BillDao{
	
	Connection con=null;

	public BillDaoImpl() {
		con = Db.getDbCon();
	}

	@Override
	public boolean addBill(Bill b) {
		String sql1="insert into bills (cashierid,customername,billingdate,amount,discount) values(?,?,?,?,?)";
		
		try {
			PreparedStatement stm1=con.prepareStatement(sql1);
			
			stm1.setInt(1, b.getCashierId());
			stm1.setString(2, b.getCustomerName());
			stm1.setDate(3, b.getBillingDate());
			stm1.setFloat(4, b.getBillAmount());
			stm1.setFloat(5, b.getaDiscount());
			
			stm1.execute();//if(stm1.execute()) {
			
			List<Product> plist=b.getProductList();
			//debuging
			for(Product p:plist) {
				System.out.println(p.getName());
			}
			
			int bno=getLastBillNo();
			System.out.println(" added bill,the last added bill no is "+bno);
			
			for(Product p:plist) {
				System.out.println(p.getMRP()+" will be added");
				String sql2="insert into productsinbills (billno,productid,productname,mrp,quantity,discount) values(?,?,?,?,?,?)"; // run this query in loop for each product
				PreparedStatement stm2=con.prepareStatement(sql2);
					
				stm2.setInt(1,bno);         // how to extract bill no??
				stm2.setInt(2, p.getId());
				stm2.setString(3, p.getName());
				stm2.setFloat(4, p.getMRP());
				stm2.setInt(5, p.getQuantity());
				stm2.setFloat(6, p.getDiscount());
				
				stm2.execute();
				
			}
			return true;
			//}else{System.out.println("stm1.execute() is false");
			//	return false;}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeBill(int id) {
		String sql1="remove from bills where billno="+id;
		String sql2="remove from productinbills where billno="+id;
		
		try {
			Statement stm1=con.createStatement();
			Statement stm2=con.createStatement();
			
			stm1.execute(sql1);
			stm2.execute(sql2);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public Bill getBillById(int id) {
		String sql1="select* from bills where billno="+id;
		String sql2="select*from productsinbills where billno="+id;
		
		try {
			Statement stm1=con.createStatement();
			ResultSet rs1=stm1.executeQuery(sql1);
			Statement stm2=con.createStatement();
			ResultSet rs2=stm2.executeQuery(sql2);
			rs1.next();
			Bill b=new Bill();
			b.setBillNo(rs1.getInt("billno"));
			b.setCashierId(rs1.getInt("cashierid"));
			b.setCustomerName(rs1.getString("customername"));
			b.setBillingDate(rs1.getDate("billingdate"));
			b.setaDiscount(rs1.getFloat("discount"));
			b.setBillAmount(rs1.getFloat("amount"));
			
			List<Product> plist=new ArrayList<Product>();
			while(rs2.next()) {
				Product p=new Product();
				p.setId(rs2.getInt(3));
//				System.out.println(p.getId()+"#####");
				p.setName(rs2.getString(4));
//				System.out.println("name= "+p.getName());
				p.setMRP(rs2.getFloat(5));
				p.setQuantity(rs2.getInt(6));
				p.setDiscount(rs2.getFloat(7));
				plist.add(p);
			}
			b.setProductList(plist);
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Bill> getAllBills() {
		String sql="select*from bills";
		List<Bill> blist=new ArrayList<Bill>();
		
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next()) {
				Bill b= new Bill();
				b.setBillNo(rs.getInt("billno"));
				b.setCustomerName(rs.getString("customername"));
				b.setBillAmount(rs.getFloat("amount"));
				b.setBillingDate(rs.getDate("billingdate"));
				
				blist.add(b);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return blist;
	}

	@Override
	public boolean updateBill(Bill b) {
		
		return false;
	}
	
	private  int getLastBillNo() {
		String sql="select billno from bills";
		int lId=-1;
		try {
			Statement stm= con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			int idt;
			while(rs.next()) {
				idt=rs.getInt("billno");
				lId=(lId<idt)?idt:lId;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lId;
	}
	public int nextBillNo() {
		return getLastBillNo()+1;
	}

}
