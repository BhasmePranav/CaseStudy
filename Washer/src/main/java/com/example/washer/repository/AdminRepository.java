package com.example.washer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.washer.entity.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin , String>{

}
