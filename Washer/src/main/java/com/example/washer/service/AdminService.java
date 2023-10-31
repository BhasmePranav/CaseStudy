package com.example.washer.service;

import java.util.List;

import com.example.washer.entity.Admin;

public interface AdminService {
	
	public Admin addAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public String deleteAdmin(String email);
	
	public List<Admin> getAllAdmin();
	
	public Admin loginAdmin(String email , String password);

}
