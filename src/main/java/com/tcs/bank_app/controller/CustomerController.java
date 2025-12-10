package com.tcs.bank_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.bank_app.entity.MyCustomer;
import com.tcs.bank_app.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/details/{id}")
	public String getDetails(@PathVariable Long id, Model model) {
		MyCustomer customer = customerService.getCustomerDetails(id);
		model.addAttribute("customer", customer);
		return "customer-details";
	}
}
