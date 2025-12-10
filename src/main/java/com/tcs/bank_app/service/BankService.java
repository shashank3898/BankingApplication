package com.tcs.bank_app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bank_app.dto.AccountDTO;
import com.tcs.bank_app.entity.BankAccount;
import com.tcs.bank_app.entity.MyCustomer;
import com.tcs.bank_app.entity.Transaction;
import com.tcs.bank_app.repository.BankAccountRepo;
import com.tcs.bank_app.repository.TransactionRepo;

@Service
public class BankService {
 
    @Autowired
    private BankAccountRepo bankAccountRepository;
 
    @Autowired
    private TransactionRepo transactionRepository;

    public BankAccount createAccount(AccountDTO dto) {
 
        MyCustomer customer = new MyCustomer();
        customer.setCustomerId(dto.getCustomerId());
 
        BankAccount account = new BankAccount();
        account.setCustomer(customer);
        account.setBankAccountBalance(0);
        account.setBankAccountType(dto.getType());
 
        return bankAccountRepository.save(account);
    }
    
    public double getBalance(long accountId) {
    	BankAccount acc =  bankAccountRepository.findById(accountId)
    			.orElseThrow(()-> new RuntimeException("Account not found"));
    	return acc.getBankAccountBalance();
    }
 
    public BankAccount deposit(Long accountId, double amount) {
 
        BankAccount account = bankAccountRepository.findById(accountId).orElseThrow();
 
        account.setBankAccountBalance(account.getBankAccountBalance() + amount);
 
        Transaction t = new Transaction();
        t.setTransactionAmount(amount);
        t.setTransactionType("DEPOSIT");
        t.setTransactionDate(LocalDateTime.now());
        t.setAccount(account);
 
        transactionRepository.save(t);
 
        return bankAccountRepository.save(account);
    }
 
    public BankAccount withdraw(Long accountId, double amount) {
 
        BankAccount account = bankAccountRepository.findById(accountId).orElseThrow();
 
        if (amount > account.getBankAccountBalance()) {
            throw new RuntimeException("Insufficient funds");
        }
 
        account.setBankAccountBalance(account.getBankAccountBalance() - amount);
 
        Transaction t = new Transaction();
        t.setTransactionAmount(amount);
        t.setTransactionType("WITHDRAW");
        t.setTransactionDate(LocalDateTime.now());
        t.setAccount(account);
 
        transactionRepository.save(t);
 
        return bankAccountRepository.save(account);
    }
 
    public void transfer(Long fromId, Long toId, double amount) {
 
        BankAccount from = bankAccountRepository.findById(fromId).orElseThrow();
        BankAccount to = bankAccountRepository.findById(toId).orElseThrow();
 
        if (from.getBankAccountBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
 
        from.setBankAccountBalance(from.getBankAccountBalance() - amount);
        to.setBankAccountBalance(to.getBankAccountBalance() + amount);
 
        Transaction t1 = new Transaction();
        t1.setTransactionAmount(amount);
        t1.setTransactionType("TRANSFER_OUT");
        t1.setTransactionDate(LocalDateTime.now());
        t1.setAccount(from);
 
        Transaction t2 = new Transaction();
        t2.setTransactionAmount(amount);
        t2.setTransactionType("TRANSFER_IN");
        t2.setTransactionDate(LocalDateTime.now());
        t2.setAccount(to);
 
        transactionRepository.save(t1);
        transactionRepository.save(t2);
 
        bankAccountRepository.save(from);
        bankAccountRepository.save(to);
    }
}
