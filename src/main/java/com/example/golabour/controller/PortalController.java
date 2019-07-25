package com.example.golabour.controller;

import com.example.golabour.Response;
import com.example.golabour.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.golabour.service.PortalService;

@RestController
@CrossOrigin
public class PortalController {
	private PortalService ps;
	
	@Autowired
	public void setPs(PortalService ps) {
		System.out.println("Service are Autowired");
		this.ps = ps;
	}
	
	@PostMapping("/user/login")
	public Response getUser(@RequestBody User user) {
		return ps.getUser(user);
	}
	
	@PostMapping("/user/detail")
	public Response getUserDetail(@RequestBody User user) {
		return ps.getUserDetail(user);
	}
	
	@PostMapping("/user/register")
	public Response register(@RequestBody User user) {
		return ps.registerUser(user);
	}
	
	@PostMapping("/user/updateProfile")
	public Response updateProfile(@RequestBody User user) {
		return ps.updateProfile(user);
	}
	
	@PostMapping("/user/updatePassword/{old}")
	public Response updatePassword(@RequestBody User user, @PathVariable String old) {
		System.out.println(old);
		return ps.updatePassword(user, old);
	}
	
	@PostMapping("/user/addAddress")
	public Response addAddress(@RequestBody User user) {
		return ps.addAddress(user);
	}
	
	@DeleteMapping("/user/removeAddress/{id}")
	public void removeAddress(@PathVariable int id) {
		System.out.println(id);
		ps.removeAddress(id);
	}
	
	@GetMapping("/getAllCategory") 
	public List<Category> getAllCategory() {
		return ps.getAllCategory();
	}
	
	@DeleteMapping("/user/removeJob/{id}")
	public void removeJob(@PathVariable int id) {
		System.out.println(id);
		ps.removeJob(id);
	}
	
	@PostMapping("/user/addJob")
	public Response addJob(@RequestBody Job user) {
		return ps.addJob(user);
	}
	
	@PostMapping("/labour/register")
	public Response registerLabour(@RequestBody Labour labour) {
		return ps.registerLabour(labour);
	}

	@PostMapping("/labour/login")
	public Response getLabour(@RequestBody Labour labour) {
		return ps.getLabour(labour);
	}
	
	@PostMapping("/labour/getDetail")
	public Response getLabourDetail(@RequestBody Labour labour) {
		return ps.getLabourDetail(labour);
	}
	
	@PostMapping("/jobs")
	public List<Job> getJobs(@RequestBody Category id) {
		return ps.getJobs(id);
	}
	
	@PostMapping("/requestJobs")
	public Response postJobs(@RequestBody RequestedJob req) {
		return ps.requestJob(req);
	}
	
	@PostMapping("/RequestJobsById")
	public List<RequestedJob> getJobById(@RequestBody Job id) {
		return ps.getJobsById(id);
	}
	
	@PostMapping("/confirmJob")
	public Response confirmedJob(@RequestBody ConfirmationJob job) {
		return ps.confirmedJob(job);
	}
	
	@PostMapping("/getAllJobs")
	public List<ConfirmationJob> getAllJobs(@RequestBody Labour labour ) {
		return ps.getAllJobs(labour);
	}
}
