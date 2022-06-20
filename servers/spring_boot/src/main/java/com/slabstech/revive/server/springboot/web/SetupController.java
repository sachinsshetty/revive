package com.slabstech.revive.server.springboot.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.slabstech.revive.server.springboot.persistence.model.Setup;
import com.slabstech.revive.server.springboot.persistence.repo.SetupRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/setup")
public class SetupController {

	@Autowired
	private SetupRepository setupRepository;

	@Autowired
	private Validator validator;

	/**
	 * Get all Setups list.
	 *
	 * @return the list
	 */
	@GetMapping // GET Method for reading operation
	public List<Setup> getAllSetups() {
		return setupRepository.findAll();
	}

	/**
	 * Gets setups by id.
	 *
	 * @param setupId the setup id
	 * @return the setups by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<Setup> getSetupById(@PathVariable(value = "id") Long setupId) throws Exception {

		Setup setup = setupRepository.findById(setupId)
				.orElseThrow(() -> new Exception("Setup " + setupId + " not found"));
		return ResponseEntity.ok().body(setup);
	}

	/**
	 * Create setup.
	 *
	 * @param setup the setup
	 * @return the setup
	 */
	@PostMapping // POST Method for Create operation
	@ResponseStatus(HttpStatus.CREATED)
	public Setup createSetup(@Valid @RequestBody Setup setup) {

		Set<ConstraintViolation<Setup>> violations = validator.validate(setup);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<Setup> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}

			throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
		}

		return setupRepository.save(setup);
	}

	/**
	 * Update setup response entity.
	 *
	 * @param setupId      the setup id
	 * @param setupDetails the setup details
	 * @return the response entity
	 * @throws Exception
	 */
	@PutMapping("/{id}") // PUT Method for Update operation
	public ResponseEntity<Setup> updateSetup(@PathVariable(value = "id") Long setupId,
			@Valid @RequestBody Setup setupDetails) throws Exception {

		Setup setup = setupRepository.findById(setupId)
				.orElseThrow(() -> new Exception("Setup " + setupId + " not found"));

		// setup.setCarName(setupDetails.getSetupName());
		// setup.setDoors(setupDetails.getOs());


		Set<ConstraintViolation<Setup>> violations = validator.validate(setup);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<Setup> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}

			throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
		}

		final Setup updatedSetup = setupRepository.save(setup);
		return ResponseEntity.ok(updatedSetup);
	}

	/**
	 * Delete setup map.
	 *
	 * @param setupId the setup id
	 * @return the map of the deleted setup
	 * @throws Exception the exception
	 */
	@DeleteMapping("/{id}") // DELETE Method for Delete operation
	public Map<String, Boolean> deleteSetup(@PathVariable(value = "id") Long setupId) throws Exception {
		Setup setup = setupRepository.findById(setupId)
				.orElseThrow(() -> new Exception("Setup " + setupId + " not found"));

		setupRepository.delete(setup);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}



	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
