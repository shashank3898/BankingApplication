package com.tcs.bank_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.bank_app.entity.MyUser;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Long> {

	MyUser findByUserNameAndUserPassword(String email, String password);

}
