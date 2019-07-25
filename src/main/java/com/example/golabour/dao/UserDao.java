package com.example.golabour.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.golabour.model.User;

public interface UserDao extends JpaRepository<User, String>{

}
