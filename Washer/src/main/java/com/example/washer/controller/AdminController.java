package com.example.washer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.washer.entity.Admin;
import com.example.washer.serviceimplementation.AdminServiceImpl;

@RestController
@RequestMapping("/Admins")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl  adminServiceImpl;
	
	@PostMapping("/register")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return adminServiceImpl.addAdmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		return adminServiceImpl.updateAdmin(admin);
	}
	
	@DeleteMapping("/deleteAdmin/{email}")
	public String deleteAdmin(@PathVariable String email)
	{
		return adminServiceImpl.deleteAdmin(email);
	}
	
	@GetMapping("/getAllAdmins")
	public List<Admin> getAllAdmin()
	{
		return adminServiceImpl.getAllAdmin();
	}
	
	@GetMapping("/loginAdmin/{email}/{password}")
	public Admin loginAdmin(@PathVariable String email ,@PathVariable String password)
	{
		return adminServiceImpl.loginAdmin(email, password);
	}
	

}
