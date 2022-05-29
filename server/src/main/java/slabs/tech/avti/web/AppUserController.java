package slabs.tech.avti.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import slabs.tech.avti.persistance.model.AppUser;
import slabs.tech.avti.persistance.repo.AppUserRepository;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/app_users")
public class AppUserController {

	@Autowired
	private AppUserRepository appUserRepository;


	/**
	 * Get all Users list.
	 *
	 * @return the list
	 */
	@GetMapping // GET Method for reading operation
	public List<AppUser> getAllUsers() {
		return appUserRepository.findAll();
	}

	/**
	 * Gets users by id.
	 *
	 * @param userId the user id
	 * @return the users by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<AppUser> getUserById(@PathVariable(value = "id") Long userId) throws Exception {

		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(() -> new Exception("User " + userId + " not found"));
		return ResponseEntity.ok().body(user);
	}

	/**
	 * Create user.
	 *
	 * @param user the user
	 * @return the user
	 */
	@PostMapping // POST Method for Create operation
	@ResponseStatus(HttpStatus.CREATED)
	public AppUser createUser(@Valid @RequestBody AppUser user) {
		return appUserRepository.save(user);
	}

	/**
	 * Update user response entity.
	 *
	 * @param userId      the user id
	 * @param userDetails the user details
	 * @return the response entity
	 * @throws Exception
	 */
	@PutMapping("/{id}") // PUT Method for Update operation
	public ResponseEntity<AppUser> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody AppUser userDetails) throws Exception {

		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(() -> new Exception("User " + userId + " not found"));

		// user.setCarName(userDetails.getUserName());
		// user.setDoors(userDetails.getOs());

		final AppUser updatedUser = appUserRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	/**
	 * Delete user map.
	 *
	 * @param userId the user id
	 * @return the map of the deleted user
	 * @throws Exception the exception
	 */
	@DeleteMapping("/{id}") // DELETE Method for Delete operation
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(() -> new Exception("User " + userId + " not found"));

		appUserRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
