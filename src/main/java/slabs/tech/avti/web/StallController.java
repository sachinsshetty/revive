package slabs.tech.avti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slabs.tech.avti.persistance.model.Stall;
import slabs.tech.avti.persistance.repo.StallRepository;

@RestController
@RequestMapping("/stalls")
public class StallController {

	@Autowired
	private StallRepository stallRepository;

	/**
	 * Get all Stalls list.
	 *
	 * @return the list
	 */
	@GetMapping				 // GET Method for reading operation
	public List<Stall> getAllStalls() {
		return stallRepository.findAll();
	}

}
