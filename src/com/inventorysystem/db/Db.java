package com.inventorysystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	
	public static Connection getDbCon() {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb","root","");
		} catch (ClassNotFoundException | SQLException e) {// compare with swingproject db class
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
