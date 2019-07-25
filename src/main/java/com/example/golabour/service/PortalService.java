package com.example.golabour.service;

import com.example.golabour.model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.golabour.Response;
import com.example.golabour.dao.AddressDao;
import com.example.golabour.dao.CategoryDao;
import com.example.golabour.dao.ConfirmationJobDao;
import com.example.golabour.dao.JobDao;
import com.example.golabour.dao.LabourDao;
import com.example.golabour.dao.RequestedJobDao;
import com.example.golabour.dao.UserDao;

@Service
public class PortalService {
	@Autowired
	private AddressDao ad;
	@Autowired
	private CategoryDao cd;
	@Autowired
	private ConfirmationJobDao cjd;
	@Autowired
	private JobDao jd;
	@Autowired
	private LabourDao ld;
	@Autowired
	private RequestedJobDao rjd;
	@Autowired
	private UserDao ud;
	
	public Response getUser(User user) {
		Response res = new Response();
		Optional<User> op = ud.findById(user.getEmail());
		res.setO("Wrong Credentials");
		res.setStatus(false);
		if(op.isPresent()) {
			User use = op.get();
			res.setO("Wrong Password");
			res.setStatus(false);
			if(user.getPassword().equals(use.getPassword()))
			{
				res.setStatus(true);
				res.setO(use.getName());
			}
		}
		return res;
	}
	
	public Response getUserDetail(User user) {
		Response res = new Response();
		Optional<User> op = ud.findById(user.getEmail());
		if(op.isPresent())
		{
			User us = op.get();
			res.setO(us);
			res.setStatus(true);
		}
		return res;
 	}

	public Response registerUser(User user) {
		// TODO Auto-generated method stub
		Response res = new Response();
		ud.save(user);
		res.setO("Registration Successfully");
		return res;
	}

	public Response updateProfile(User user) {
		// TODO Auto-generated method stub
		Response res = new Response();
		ud.save(user);
		res.setStatus(true);
		return res;
	}

	public Response updatePassword(User user, String old) {
		// TODO Auto-generated method stub
		Response res = new Response();
		Optional<User> op = ud.findById(user.getEmail());
		if(op.isPresent())
		{
			User use = op.get();
			res.setO("Wrong Password");
			res.setStatus(false);
			if(use.getPassword().equals(old)) {
				ud.save(user);
				res.setO("Password is Updated");
				res.setStatus(true);
			}
		}
		return res;
	}

	public Response addAddress(User user) {
		// TODO Auto-generated method stub
		Response res = new Response();
		ud.save(user);
		res.setStatus(true);
		res.setO("New Address is Added");
		return res;
	}

	public void removeAddress(int id) {
		// TODO Auto-generated method stub
		ad.deleteById(id);;
	}

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> l_cat = cd.findAll();		
		return l_cat;
	}

	public void removeJob(int id) {
		// TODO Auto-generated method stub
		jd.deleteById(id);
	}

	public Response addJob(Job user) {
		// TODO Auto-generated method stub
		Response res = new Response();
		jd.save(user);
		res.setStatus(true);
		res.setO("New Job is Added");
		return res;
	}

	public Response registerLabour(Labour labour) {
		// TODO Auto-generated method stub
		Response res = new Response();
		ld.save(labour);
		res.setStatus(true);
		res.setO("Registration is Successfully");
		return res;
	}

	public Response getLabour(Labour labour) {
		// TODO Auto-generated method stub
		Response res = new Response();
		Optional<Labour> op = ld.findById(labour.getMobile());
		res.setO("Wrong Credentials");
		res.setStatus(false);
		if(op.isPresent()) {
			Labour lab = op.get();
			res.setO("Wrong Password");
			res.setStatus(false);
			if(labour.getPassword().equals(lab.getPassword()))
			{
				res.setStatus(true);
				res.setO(lab.getName());
			}
		}
		return res;
	}

	public Response getLabourDetail(Labour labour) {
		// TODO Auto-generated method stub
		Response res = new Response();
		Optional<Labour> op = ld.findById(labour.getMobile());
		if(op.isPresent())
		{
			Labour lab = op.get();
			res.setO(lab);
			res.setStatus(true);
		}
		return res;
	}

	public List<Job> getJobs(Category id) {
		// TODO Auto-generated method stub
		return jd.getJobs(id);
	}

	public Response requestJob(RequestedJob req) {
		// TODO Auto-generated method stub
		rjd.save(req);
		Response res = new Response();
		res.setO("Requested");
		res.setStatus(true);
		return res;
	}

	public List<RequestedJob> getJobsById(Job id) {
		// TODO Auto-generated method stub
		return rjd.getJobsById(id);
	
	}

	public Response confirmedJob(ConfirmationJob cj) {
		// TODO Auto-generated method stub
		Response res = new Response();
		cjd.save(cj);
		Job j = cj.getJob();
		Optional<Job> op = jd.findById(j.getJob_id());
		if(op.isPresent()) {
			Job job = op.get();
			job.setStatus(Status.Confirm);
		}
		rjd.deleteJob(j);
		res.setO("Successfully");
		res.setStatus(true);
		return res;
	}

	public List<ConfirmationJob> getAllJobs(Labour labour) {
		// TODO Auto-generated method stub
		return cjd.getAllJobs(labour);
	}
	
}
