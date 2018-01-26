package org.formation.spring.controller;

import java.util.List;

import org.formation.spring.entity.Virement;
import org.formation.spring.service.IServiceVirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestVirementController {
@Autowired
private IServiceVirement serviceVirement;

/**
 * Tous les operation de tous les clients
 *
 */
	@GetMapping(value="/operations", produces="application/json")
	public List<Virement> getAllOperations(){
	return serviceVirement.getAllOperations();
		
	}
	
}
