package com.inventorysystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inventorysystem.db.Db;
import com.inventorysystem.model.User;

public class UserDaoImpl implements UserDao{
	
	Connection con= null;
	

	public UserDaoImpl() {
		
		con =Db.getDbCon();
	}

	@Override
	public boolean addUser(User u) {
		String sql="insert into user (fname,lname,address,mobile,email,dob,username,password,isadmin) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stm =con.prepareStatement(sql);
			stm.setString(1, u.getfName());
			stm.setString(2, u.getlName());
			stm.setString(3, u.getAddress());
			stm.setString(4, u.getMobile());
			stm.setString(5, u.getEmail());
			stm.setDate(6, u.getDob());
			stm.setString(7, u.getUserName());
			stm.setString(8, u.getPassword());
			stm.setBoolean(9, u.getIsAdmin());
			
			stm.execute();
			return true;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeUser(int id) {
		String sql="delete from user where id="+id;
		try {
			Statement stm=con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		String sql="update user set fname=?,lname=?,address=?,mobile=?,email=?,dob=?,username=?,password=?,isadmin=? where id="+u.getId();
		
		try {
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1, u.getfName());
			stm.setString(2, u.getlName());
			stm.setString(3, u.getAddress());
			stm.setString(4, u.getMobile());
			stm.setString(5, u.getEmail());
			stm.setDate(6, u.getDob());
			stm.setString(7, u.getUserName());
			stm.setString(8, u.getPassword());
			stm.setBoolean(9, u.getIsAdmin());
			
			System.out.println(sql);
			
			stm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserById(int id) {
		String sql="select* from user where id="+id;
		
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			rs.next();
			User u=new User();
			u.setId(id);
			u.setfName(rs.getString("fname"));
			u.setlName(rs.getString("lname"));
			u.setAddress(rs.getString("address"));
			u.setMobile(rs.getString("mobile"));
			u.setDob(rs.getDate("dob"));
			u.setEmail(rs.getString("email"));
			u.setUserName(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setIsAdmin(rs.getBoolean("isadmin"));
			
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		String sql="select*from user";
		List<User> ulist=new ArrayList<User>();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setfName(rs.getString("fname"));
				u.setlName(rs.getString("lname"));
				u.setAddress(rs.getString("address"));
				u.setMobile(rs.getString("mobile"));
				u.setDob(rs.getDate("dob"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setIsAdmin(rs.getBoolean("isadmin"));
				
				ulist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}

	@Override
	public boolean[] logIn(String userName, String password) {
		//String sql= "select isadmin,password from user where username='"+userName+"'and password='"+password+"'";
		String sql= "select isadmin,password from user where username='"+userName+"'";
		boolean[] a=new boolean[2];
		try {
			
			Statement stm=con.createStatement();
			ResultSet rs= stm.executeQuery(sql);
			if(rs.next()) {
				a[0]=rs.getBoolean("isadmin");
				if(rs.getString("password").equals(password)) {
					a[1]=true;
					return a;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		a[1]= false;
		return a;
	}

	@Override
	public boolean isAdmin(String userName) {
		String sql="select isadmin from user where username='"+userName+"'";
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			rs.next();
			return rs.getBoolean("isadmin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public int getUserId(String un) {
		String sql="select id from user where username='"+un+"'";  // the username is a string so,  include the variable inside ''
		
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean changePassword(String newPassword,int id) {
		String sql="update user set password='"+newPassword+"' where id="+id;
		
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
	
	public String getPassword(int id) {
		String sql="select password from user where id="+id;
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			rs.next();
			return rs.getString("password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
