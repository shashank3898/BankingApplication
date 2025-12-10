package com.tcs.bank_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bank_app.entity.MyCustomer;
import com.tcs.bank_app.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public MyCustomer getCustomerDetails(long customerId) {
		return customerRepo.findById(customerId).orElseThrow(()->new RuntimeException("Customer not found"));
	}
}
