package com.Java.loginreg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Java.loginreg.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmail(String email);




}
