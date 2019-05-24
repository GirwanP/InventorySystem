package com.inventorysystem.dao;

import java.util.List;

import com.inventorysystem.model.Product;

public interface ProductDao {
	boolean addProduct(Product p);
	boolean removeProduct(int id);
	boolean updateProduct(Product p);
	Product getProductById(int id);
	List<Product> getAllProducts();

}
