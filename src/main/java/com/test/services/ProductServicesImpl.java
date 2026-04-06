package com.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ProductDao;

import com.test.model.ProductModel;
@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	private ProductDao productdao;
	@Transactional
	@Override
	public void saveProduct(ProductModel product) {
		// TODO Auto-generated method stub
	productdao.saveProduct(product);
		
	}
	@Transactional
	@Override
	public ProductModel editProductById(int id) {
		// TODO Auto-generated method stub
		return productdao.editProductById(id);
	}
	@Transactional
	@Override
	public List<ProductModel> getProducts() {
		// TODO Auto-generated method stub
		return productdao.getProducts();
	}
	@Transactional
	@Override
	public void updateProduct(ProductModel product) {
		// TODO Auto-generated method stub
		productdao.updateProduct(product);
	}
	@Transactional
	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productdao.deleteProduct(id);
	}

}
