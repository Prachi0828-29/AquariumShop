package com.test.dao;

import java.util.List;

import com.test.model.ProductModel;

public interface ProductDao {
	public void saveProduct(ProductModel product);
	public ProductModel editProductById(int id);
	public List<ProductModel> getProducts();
	public void updateProduct(ProductModel product);
	public void deleteProduct(int id);
}

