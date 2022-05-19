package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.ECharge;

public interface EChargeRepository extends JpaRepository<ECharge, Long> {
	  
}