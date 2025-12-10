package com.tcs.bank_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.bank_app.dto.CustomerDTO;
import com.tcs.bank_app.dto.UserDTO;
import com.tcs.bank_app.entity.MyUser;
import com.tcs.bank_app.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("customerDTO", new CustomerDTO());
		return "register";
	}

	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute @Valid CustomerDTO dto, Model model) {
		userService.register(dto);
		model.addAttribute("msg", "Registration successful!");
		return "index";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "login";
	}

	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute @Valid UserDTO dto, Model model) {

		MyUser user = userService.login(dto.getUserName(), dto.getUserPassword());

		if (user == null) {
			model.addAttribute("error", "Invalid credentials");
			return "login";
		}

		model.addAttribute("customer", user.getCustomer());
		return "dashboard";
	}

}
