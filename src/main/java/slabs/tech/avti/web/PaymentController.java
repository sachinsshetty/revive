package slabs.tech.avti.web;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slabs.tech.avti.persistance.model.Payment;

import slabs.tech.avti.persistance.model.Payment;
import slabs.tech.avti.persistance.repo.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;


	@GetMapping				 // GET Method for reading operation
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}


	/**
	 * Gets payments by id.
	 *
	 * @param paymentId the payment id
	 * @return the payments by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "id") Long paymentId) throws Exception {

		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new Exception("Payment " + paymentId + " not found"));
		return ResponseEntity.ok().body(payment);
	}

	/**
	 * Create payment.
	 *
	 * @param payment the payment
	 * @return the payment
	 */
	@PostMapping // POST Method for Create operation
	public Payment createPayment(@Valid @RequestBody Payment payment) {
		return paymentRepository.save(payment);
	}

}
