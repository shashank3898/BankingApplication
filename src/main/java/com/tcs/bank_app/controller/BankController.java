package com.tcs.bank_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.bank_app.dto.TransactionDTO;
import com.tcs.bank_app.entity.BankAccount;
import com.tcs.bank_app.service.BankService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService bankService;

	@GetMapping("/balance")
	public String balanceForm() {
		return "balance";
	}

	@PostMapping("/balance")
	public String getBalance(@RequestParam Long accountId, Model model) {
		double balance = bankService.getBalance(accountId);
		model.addAttribute("balance", balance);
		return "balance";
	}

	@GetMapping("/deposit")
	public String depositForm() {
		return "deposit";
	}

	@PostMapping("/deposit")
	public String deposit(@RequestParam Long accountId, @RequestParam double amount, Model model) {

		BankAccount acc = bankService.deposit(accountId, amount);
		model.addAttribute("msg", "New balance: " + acc.getBankAccountBalance());
		return "deposit";
	}

	@GetMapping("/withdraw")
	public String withdrawForm() {
		return "withdraw";
	}

	@PostMapping("/withdraw")
	public String withdraw(@RequestParam Long accountId, @RequestParam double amount, Model model) {

		BankAccount acc = bankService.withdraw(accountId, amount);
		model.addAttribute("msg", "New balance: " + acc.getBankAccountBalance());
		return "withdraw";
	}

	@GetMapping("/transfer")
	public String transferForm(Model model) {
		model.addAttribute("transactionDTO", new TransactionDTO());
		return "transfer";
	}

	@PostMapping("/transfer")
	public String transfer(@ModelAttribute @Valid TransactionDTO dto, Model model) {

		bankService.transfer(dto.getAccountId(), dto.getTargetAccountId(), dto.getAmount());
		model.addAttribute("msg", "Transfer completed!");
		return "transfer";
	}
}
