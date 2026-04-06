package com.test.controller;
import com.test.model.*;

import java.util.List;
import com.test.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class MainController {
	@Autowired
	private UserService userservice;
	@RequestMapping("test")
	public String testMe()
	{
		return "Welcome";
	}
	
	@PostMapping("savecustomer")
	public String saveUser(@RequestBody UserModel user)
	{
		 userservice.saveUser(user);
		return "success";
	}
	
	@PostMapping("doprologin")
	public String doLogin(@RequestBody LoginModel lm)
	{
		List<UserModel>list=userservice.doLogin(lm);
		if(list.isEmpty())//.isEmpty is  boolean method type for list to check if it is empty or wrong password  Or .isEmpty() List ka boolean method hota hai, jo check karta hai ki list khaali hai ya nahi.
		{
			return "Failed Login";
			
		}
		else
		{
			return "success";
		}
		
	}
	
	@GetMapping("customerdetails")
	public List<UserModel> getUserDetails()
	{
		return userservice.getUsers();
	}
	
	@DeleteMapping("deletecustomer/{id}")
	public String deleteUser(@PathVariable int id)
	{
		//System.out.println("id "+id);
		userservice.deleteUser(id);
		return "deleted";
	}
	
	@GetMapping("editcustomer/{id}")
	public UserModel getUserById(@PathVariable int id)
	{
		UserModel user = userservice.editUserById(id);
		return user;
	}
	@PostMapping("customerupdate")
	public String updateUser(@RequestBody UserModel user)
	{
		userservice.updateUser(user);
		return "success";
	}
	@Autowired
	private ProductServices productservices;
	@PostMapping("saveproduct")
	public String saveProduct(@RequestBody ProductModel product)
	{
		 productservices.saveProduct(product);
		return "success";
	}
//	@GetMapping("productdetails")
//	public List<UserModel> getProductDetails()
//	{
//		return productservices.getProducts();
//	}
}
