package com.example.major.repository;

import com.example.major.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional <User> findUserByEmail(String email);



}