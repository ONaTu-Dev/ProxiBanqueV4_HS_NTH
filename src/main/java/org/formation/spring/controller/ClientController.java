package org.formation.spring.controller;

import java.util.List;

import org.formation.spring.dao.IDaoClient;
import org.formation.spring.dao.IDaoCompte;
import org.formation.spring.dao.IDaoConseiller;
import org.formation.spring.entity.Client;
import org.formation.spring.entity.Compte;
import org.formation.spring.service.IServiceGestionClient;
import org.formation.spring.service.IServiceGestionConseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	
	@Autowired
	private IServiceGestionClient serviceClient;
	
	@RequestMapping(value="/showAllClient", method=RequestMethod.GET)
	public ModelAndView listClient() {
		List<Client> clients =serviceClient.listClients();
		return new ModelAndView("showAllClient","clients",clients);
	}
	

	

}
