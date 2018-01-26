package org.formation.spring.controller;

import java.util.List;

import org.formation.spring.entity.Client;
import org.formation.spring.entity.Compte;
import org.formation.spring.service.IServiceGestionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompteShowController {
	@Autowired
	private IServiceGestionClient serviceClient;
	
	@RequestMapping( value="/showAllClient", method=RequestMethod.POST)
	
	public String listCommpte(@RequestParam("idClient") String idClient,ModelMap model) {
		//System.out.println("**** "+idClient);
		int id = Integer.parseInt("idClient");
		System.out.println(id);
		List<Compte>comptes = serviceClient.listCompteByClientId(id);
		model.addAttribute("listCompte",comptes);
		
		 return"displayCompteForClient";
	}
}
