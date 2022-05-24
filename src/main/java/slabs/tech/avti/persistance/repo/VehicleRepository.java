package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	  
}