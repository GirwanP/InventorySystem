package com.inventorysystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inventorysystem.db.Db;
import com.inventorysystem.model.Product;

public class ProductDaoImpl implements ProductDao{
	
	Connection con=null;
	

	public ProductDaoImpl() {
		
		con = Db.getDbCon();
	}

	@Override
	public boolean addProduct(Product p) {
		String sql="insert into productstock(name,mrp,quantity,discount) values(?,?,?,?)";
		try {
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1, p.getName());
			stm.setFloat(2, p.getMRP());
			stm.setInt(3, p.getQuantity());
			stm.setFloat(4, p.getDiscount());
			
			stm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeProduct(int id) {
		String sql="delete from productstock where id="+id;
		try {
			Statement stm=con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateProduct(Product p) {   // the quantity received here is the quantity to be added on the existing quantity in the database
		int id=p.getId();
		String sql1="select quantity from productstock where id="+id;
		try {
			Statement stm1=con.createStatement();
			ResultSet rs1=stm1.executeQuery(sql1);
			if(rs1.next()) {
				int quantity=rs1.getInt("quantity")+p.getQuantity();
				String sql2="update productstock set mrp=?,quantity=?,discount=? where id="+id;
				PreparedStatement stm2=con.prepareStatement(sql2);
				stm2.setFloat(1, p.getMRP());
				stm2.setInt(2, quantity);
				stm2.setFloat(3, p.getDiscount());
				stm2.execute();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product getProductById(int id) {
		String sql="select* from productstock where id="+id;
		
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setMRP(rs.getFloat("mrp"));
				p.setQuantity(rs.getInt("quantity"));
				
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getProductId says: no product found");
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql="select * from productstock";
		List<Product> plist=new ArrayList<Product>();
		
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setQuantity(rs.getInt("quantity"));
				p.setMRP(rs.getFloat("mrp"));
				p.setName(rs.getString("name"));
				
				plist.add(p);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return plist;
	}
	
	public List<Integer> getAllProductIds(){
		List<Integer> li=new ArrayList<Integer>();
		String sql= "select id from productstock";
		
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				li.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}

}
