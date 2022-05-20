package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	  
}