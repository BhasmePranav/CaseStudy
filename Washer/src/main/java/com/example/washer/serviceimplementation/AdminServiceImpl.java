package com.example.washer.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.washer.entity.Admin;
import com.example.washer.repository.AdminRepository;
import com.example.washer.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		
		Admin a = new Admin();
		a.setFname(admin.getFname());
		a.setEmail(admin.getEmail());
		a.setPhoneNo(admin.getPhoneNo());
		a.setPassword(admin.getPassword());
		return adminRepository.save(a);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Admin a = new Admin();
		a.setFname(admin.getFname());
		a.setEmail(admin.getEmail());
		a.setPhoneNo(admin.getPhoneNo());
		a.setPassword(admin.getPassword());
		return adminRepository.save(a);
	}

	@Override
	public String deleteAdmin(String email) {
		
		Admin a = adminRepository.findById(email).orElse(null);
		if(a != null)
		{
			adminRepository.delete(a);
			return "Admin Deleted";
		}
		else
		{
			return "Admin Not Present with this id";
		}
		
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		return adminRepository.findAll();
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		// TODO Auto-generated method stub
		Admin adminForLogin = adminRepository.findById(email).orElse(null);
		if(adminForLogin != null)
		{
			if(adminForLogin.getPassword().equals(password))
			{
				return adminForLogin;
			}
		}
		return null;
	}

}
