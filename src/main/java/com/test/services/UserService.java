package com.test.services;

import java.util.List;


import com.test.model.LoginModel;
import com.test.model.ProductModel;
import com.test.model.UserModel;

public interface UserService {
	
	public void saveUser(UserModel user);
	public UserModel editUserById(int id);
	public List<UserModel> getUsers();
	public void updateUser(UserModel user);
	public void deleteUser(int id);
	public List<UserModel> doLogin(LoginModel log);
	
}
