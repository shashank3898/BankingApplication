package com.tcs.bank_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bank_app.dto.CustomerDTO;
import com.tcs.bank_app.entity.MyCustomer;
import com.tcs.bank_app.entity.MyUser;
import com.tcs.bank_app.repository.CustomerRepo;
import com.tcs.bank_app.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CustomerRepo customerRepo;
	
	public String register(CustomerDTO customerDto) {
		
		MyUser user = new MyUser();
		user.setUserName(customerDto.getCustomerName());
		user.setUserPassword(customerDto.getCustomerPassword());
		user.setUserRole("ROLE_USER");
		
		MyCustomer customer = new MyCustomer();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setCustomerEmail(customerDto.getCustomeremail());
		customer.setCustomerPhoneNo(customerDto.getCustomerPhoneNo());
		customer.setCustomerAddress(customerDto.getCustomerAddress());
		customer.setUser(user);
		
		user.setCustomer(customer);
		
		userRepo.save(user);
		customerRepo.save(customer);
		
		return "User Successfully Registered";
	}
	
	public MyUser login(String username,String password) {
		return userRepo.findByUserNameAndUserPassword(username,password);
	}
	
}
