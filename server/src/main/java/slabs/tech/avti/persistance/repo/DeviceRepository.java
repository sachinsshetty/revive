package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	  
}