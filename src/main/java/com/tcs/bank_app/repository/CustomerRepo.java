package com.tcs.bank_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.bank_app.entity.MyCustomer;

@Repository
public interface CustomerRepo extends JpaRepository<MyCustomer, Long> {

}
