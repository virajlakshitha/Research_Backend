package com.tech.ring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Role;


@Repository
public interface RoleDao extends MongoRepository<Role, String>{
	
	public Role findRoleByroleName(String roleName);
}
