package com.test.dao;

import java.util.List;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.LoginModel;
import com.test.model.ProductModel;
import com.test.model.UserModel;

import jakarta.persistence.EntityManager;


@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private EntityManager em;
	@Override
	public void saveUser(UserModel user) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		session.persist(user);
		
	}

	@Override
	public UserModel editUserById(int id) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		return session.get(UserModel.class, id);
	}

	@Override
	public List<UserModel> getUsers() {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		
		return session.createQuery("from UserModel").list();
	}

	@Override
	public void updateUser(UserModel user) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		session.merge(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		UserModel user = session.get(UserModel.class, id);
		session.remove(user);
	}

	@Override
	public List<UserModel> doLogin(LoginModel log) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		List<UserModel> list = session.createQuery("from UserModel U where U.email='"+log.getEmail()+"' and U.password='"+log.getPassword()+"'").list();
		List<UserModel> list1 = list.size() >0 ? list:null;
				return list1;
	}

	@Override
	public void saveProduct(ProductModel product) {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		session.persist(product);
	}

}
