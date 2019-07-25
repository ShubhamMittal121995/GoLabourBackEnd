package com.example.golabour.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.golabour.model.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
