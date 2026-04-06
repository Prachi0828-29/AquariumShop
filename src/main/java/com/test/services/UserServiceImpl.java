package com.test.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDao;
import com.test.model.LoginModel;
import com.test.model.ProductModel;
import com.test.model.UserModel;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdao;
	@Transactional
	@Override
	public void saveUser(UserModel user) {
		// TODO Auto-generated method stub
		userdao.saveUser(user);
	}
	@Transactional
	@Override
	public UserModel editUserById(int id) {
		// TODO Auto-generated method stub
		return userdao.editUserById(id);
	}

	@Override
	public List<UserModel> getUsers() {
		// TODO Auto-generated method stub
		return userdao.getUsers();
	}
	
	@Transactional
	@Override
	public void updateUser(UserModel user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
	}
	@Transactional
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userdao.deleteUser(id);
	}
	@Transactional
	@Override
	public List<UserModel> doLogin(LoginModel log) {
		// TODO Auto-generated method stub
		return userdao.doLogin(log);
	}
	
	

}
