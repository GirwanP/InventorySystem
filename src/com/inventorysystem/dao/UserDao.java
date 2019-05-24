package com.inventorysystem.dao;

import java.util.List;

import com.inventorysystem.model.User;

public interface UserDao {
	boolean addUser(User u);
	boolean removeUser(int id);
	boolean updateUser(User u);
	User getUserById(int id);
	boolean[] logIn(String userName,String password);
	boolean isAdmin(String userName);
	List<User> getAllUsers();
	

}
