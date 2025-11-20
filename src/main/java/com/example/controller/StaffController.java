package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Staff;
import com.example.service.StaffService;

@RestController
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping("insertstaff")
	public String insertSatff(@RequestBody Staff staff) {
		
		return staffService.insertStaff(staff);
		
	}
	
	@GetMapping("all")
	public List<Staff>  gelAllStaff() {
		
		return staffService.getAllStaff();
		
	}
	
	@GetMapping("getbyid/{id}")
	public Staff getById(@PathVariable int id) {
		
		return staffService.getById(id);
		
	}
	
	@GetMapping("salarygt/{salary}")
	public List<Staff> salaryGT(@PathVariable double salary) {
		
		return staffService.salaryGT(salary);
		
	}
	
	@GetMapping("experiencebtw/{exp1}/{exp2}")
	public List<Staff> experienceBtw(@PathVariable int exp1, @PathVariable int exp2) {
		
		return staffService.experienceBtw(exp1, exp2);
	}
	
	@GetMapping("maxsalary")
	public Staff maxSalaryStaff() {
		
		return staffService.maxSalaryStaff();
	}
	
	@PutMapping("updatesalarybyid/{id}/{newSal}")
	public String updateSalaryById(@PathVariable int id, @PathVariable double newSal) {
		
		return staffService.updateSalaryById(id, newSal);
	}
	
	@GetMapping("minimumexperience")
	public String minExpStaff() {
		
		return staffService.minExpStaff();
	}
	
	@GetMapping("getstaffbyprofile/{profile}")
	public List<Staff> getStaffByProfile(@PathVariable String profile) {
		
		return staffService.getStaffByProfile(profile);
	}
	
	@GetMapping("staffne/{profile}")
	public List<Staff> getStaffNeProfile(@PathVariable String profile) {
		
		return staffService.getStaffNeProfile(profile);
	}

}
