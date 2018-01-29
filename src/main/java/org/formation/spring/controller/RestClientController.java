package org.formation.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.formation.spring.dto.BeanClient;
import org.formation.spring.entity.Client;

import org.formation.spring.service.ServiceGestionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

	@Autowired
	private ServiceGestionClient servCl;

	@GetMapping(value = "/clients", produces = "application/json")
	public List<BeanClient> getAllclient() {
		List<Client> lC = servCl.listClients();
		ArrayList<BeanClient> lbc = new ArrayList<BeanClient>(); int i=0;
		System.out.println("dans getAllClient");
		
		for (Client client : lC) {
			BeanClient bc = new BeanClient();
			bc.setId(client.getId());
			bc.setNom(client.getNom());
			bc.setPrenom(client.getPrenom());
			bc.setSoldeCC(client.getCompteCourant().getSolde());
			bc.setSoldeEp(client.getCompteEpargne().getSolde());
			bc.setAdresse(client.getAdresse());
			System.out.println("solde "+i+"  = "+bc.getSoldeCC());
			System.out.println("client no : "+i);
			lbc.add(bc);i++;
		}
		System.out.println("list beans : "+lbc);
		return lbc;
	}
}
