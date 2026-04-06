package com.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.ProductModel;
import com.test.model.UserModel;

import jakarta.persistence.EntityManager;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private EntityManager em;
	@Override
	public void saveProduct(ProductModel product) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		session.persist(product);
	}

	@Override
	public ProductModel editProductById(int id) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		return session.get(ProductModel.class, id);
	}

	@Override
	public List<ProductModel> getProducts() {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		
		return session.createQuery("from ProductModel").list();
	}

	@Override
	public void updateProduct(ProductModel product) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		session.merge(product);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		ProductModel product = session.get(ProductModel.class, id);
		session.remove(product);
	}

}
