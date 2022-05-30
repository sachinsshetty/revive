package com.slabstech.revive.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slabstech.revive.persistence.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	  
}