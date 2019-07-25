package com.example.golabour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.golabour.model.ConfirmationJob;
import com.example.golabour.model.Labour;

public interface ConfirmationJobDao extends JpaRepository<ConfirmationJob, Integer> {
	@Query("Select u from ConfirmationJob u where u.labour = ?1")
	List<ConfirmationJob> getAllJobs(Labour labour);
}
