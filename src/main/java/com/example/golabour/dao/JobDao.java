package com.example.golabour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.golabour.model.Category;
import com.example.golabour.model.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	@Query("SELECT u FROM Job u WHERE u.category = ?1 and u.status = 'Pending'")
	List<Job> getJobs(Category id);
}
