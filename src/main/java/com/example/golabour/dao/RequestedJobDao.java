package com.example.golabour.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.golabour.model.Job;
import com.example.golabour.model.RequestedJob;

public interface RequestedJobDao extends JpaRepository<RequestedJob, Integer>{
	
	@Query("SELECT u FROM RequestedJob u WHERE u.job = ?1")
	List<RequestedJob> getJobsById(Job id);
	
	@Modifying
	@Query("Delete from RequestedJob u WHERE u.job = ?1")
	@Transactional
	void deleteJob(Job id);

}
