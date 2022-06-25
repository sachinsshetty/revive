package com.slabstech.revive.server.springboot.web;;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.slabstech.revive.server.springboot.persistence.model.Home;
import com.slabstech.revive.server.springboot.persistence.repo.HomeRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/homes")
public class HomeController {

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private Validator validator;

    /**
     * Get all Homes list.
     *
     * @return the list
     */
    @GetMapping				   // GET Method for reading operation
    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    /**
     * Gets homes by id.
     *
     * @param homeId the home id
     * @return the homes by id
     * @throws Exception
     */
    @GetMapping("/{id}")    // GET Method for Read operation
    public ResponseEntity<Home> getHomeById(@PathVariable(value = "id") Long homeId)
            throws Exception {

        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new Exception("Home " + homeId + " not found"));
        return ResponseEntity.ok().body(home);
    }

    /**
     * Create home.
     *
     * @param home the home
     * @return the home
     */
    @PostMapping   // POST Method for Create operation
    @ResponseStatus(HttpStatus.CREATED)
    public Home createHome(@Valid @RequestBody Home home) {

        Set<ConstraintViolation<Home>> violations = validator.validate(home);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Home> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }

            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }

        return homeRepository.save(home);
    }

    /**
     * Update home response entity.
     *
     * @param homeId the home id
     * @param homeDetails the home details
     * @return the response entity
     * @throws Exception
     */
    @PutMapping("/{id}")    // PUT Method for Update operation
    public ResponseEntity<Home> updateHome(
            @PathVariable(value = "id") Long homeId, @Valid @RequestBody Home homeDetails)
            throws Exception {

        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new Exception("Home " + homeId + " not found"));


        // Set the values for home here to update

        Set<ConstraintViolation<Home>> violations = validator.validate(home);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Home> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }

            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }


        final Home updatedHome = homeRepository.save(home);
        return ResponseEntity.ok(updatedHome);
    }

    /**
     * Delete home map.
     *
     * @param homeId the home id
     * @return the map of the deleted home
     * @throws Exception the exception
     */
    @DeleteMapping("/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deleteHome(@PathVariable(value = "id") Long homeId) throws Exception {
        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new Exception("Home " + homeId + " not found"));

        homeRepository.delete(home);
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
