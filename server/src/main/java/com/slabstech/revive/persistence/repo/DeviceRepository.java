package com.slabstech.revive.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slabstech.revive.persistence.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	  
}