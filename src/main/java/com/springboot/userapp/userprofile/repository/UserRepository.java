package com.springboot.userapp.userprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.userapp.userprofile.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailId(String emailId);

}
