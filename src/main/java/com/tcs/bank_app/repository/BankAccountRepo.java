package com.tcs.bank_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.bank_app.entity.BankAccount;
import com.tcs.bank_app.entity.MyCustomer;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, Long> {
	
	List<BankAccount> findByCustomer(MyCustomer customer);
}
