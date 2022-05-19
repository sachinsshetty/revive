package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Recycle;

public interface RecycleRepository extends JpaRepository<Recycle, Long> {
	  
}