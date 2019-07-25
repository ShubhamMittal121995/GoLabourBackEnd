package com.example.golabour.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name = "job")
public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int job_id;
	private String description;
	private String dateofjob;
	@Enumerated(EnumType.STRING)
	private Status status; 
	
	@OneToOne
	private Category category;
	
	@OneToOne
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "user_job")
	@JsonBackReference
	private User user;
	
	/**
	 * @return the job_id
	 */
	public int getJob_id() {
		return job_id;
	}

	/**
	 * @param job_id the job_id to set
	 */
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateofjob
	 */
	public String getDateofjob() {
		return dateofjob;
	}

	/**
	 * @param dateofjob the dateofjob to set
	 */
	public void setDateofjob(String dateofjob) {
		this.dateofjob = dateofjob;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Job [job_id=" + job_id + ", description=" + description + ", dateofjob=" + dateofjob + ", status="
				+ status + ", category=" + category + ", address=" + address + ", user=" + user + "]";
	}
	
	
}
