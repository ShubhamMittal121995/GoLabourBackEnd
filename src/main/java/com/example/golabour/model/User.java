package com.example.golabour.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name= "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	private String password;
	private String name;
	private long mobile;
	private int age;
	private String gender;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, targetEntity = Address.class)
	@JsonManagedReference
	private List<Address> aList;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, targetEntity = Job.class)
	@JsonManagedReference
	private List<Job> jList;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mobile
	 */
	public long getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the aList
	 */
	public List<Address> getaList() {
		return aList;
	}
	/**
	 * @param aList the aList to set
	 */
	public void setaList(List<Address> aList) {
		this.aList = aList;
	}
	/**
	 * @return the jList
	 */
	public List<Job> getjList() {
		return jList;
	}
	/**
	 * @param jList the jList to set
	 */
	public void setjList(List<Job> jList) {
		this.jList = jList;
	}
	
	
	

}
