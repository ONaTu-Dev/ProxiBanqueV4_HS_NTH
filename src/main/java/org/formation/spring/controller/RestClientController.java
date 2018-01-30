package org.formation.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.OneToOne;

import org.formation.spring.dto.BeanClient;
import org.formation.spring.dto.BeanOperation;
import org.formation.spring.entity.Adresse;
import org.formation.spring.entity.Agence;
import org.formation.spring.entity.Client;
import org.formation.spring.entity.CompteCourant;
import org.formation.spring.entity.CompteEpargne;
import org.formation.spring.entity.Conseiller;
import org.formation.spring.entity.Gerant;
import org.formation.spring.service.IServiceGestionClient;
import org.formation.spring.service.IServiceGestionConseiller;
import org.formation.spring.service.ServiceGestionClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RestClientController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceGestionClient.class);
	@Autowired
	private IServiceGestionClient servCl;
	@Autowired
	IServiceGestionConseiller serviceConseiller;

	@GetMapping(value = "/clients", produces = "application/json")
	public List<BeanClient> getAllclient() {
		List<Client> lC = servCl.listClients();
		ArrayList<BeanClient> lbc = new ArrayList<BeanClient>();
		int i = 0;
		System.out.println("dans getAllClient");

		for (Client client : lC) {
			BeanClient bc = new BeanClient();
			bc.setId(client.getId());
			bc.setNom(client.getNom());
			bc.setPrenom(client.getPrenom());
			bc.setSoldeCC(client.getCompteCourant().getSolde());
			bc.setSoldeEp(client.getCompteEpargne().getSolde());
			bc.setAdresse(client.getAdresse());
			System.out.println("solde " + i + "  = " + bc.getSoldeCC());
			System.out.println("client no : " + i);
			lbc.add(bc);
			i++;
		}
		System.out.println("list beans : " + lbc);
		return lbc;
	}

	@GetMapping(value = "/clients{nom}/", produces = "application/json")
	public ResponseEntity<List<BeanClient>> getAllClientByName(@RequestParam("nom") String nom) {
		List<Client> lC = servCl.findAllClientByNom(nom);

		ArrayList<BeanClient> lbc = new ArrayList<BeanClient>();
		int i = 0;
		System.out.println("dans getAllClient");

		for (Client client : lC) {
			BeanClient beanClient = new BeanClient();
			LOGGER.debug("-------new bean-----");
			beanClient.setId(client.getId());

			beanClient.setNom(client.getNom());
			LOGGER.debug("-------new bean Nom-----" + beanClient.getNom());
			beanClient.setPrenom(client.getPrenom());
			LOGGER.debug("-------new bean Prenom-----" + beanClient.getPrenom());
			//beanClient.setCons(client.getConseiller().getId());
			//LOGGER.debug("-------new bean Conseiller-----" + beanClient.getCons());
			beanClient.setNumCompteCourant(servCl.findCompteCourantByClientId(client.getId()).getNumeroCompte());
			LOGGER.debug("-------new bean-----" + beanClient.getNumCompteCourant());
			beanClient.setNumCompteEpargne(servCl.findCompteEpargneByClientId(client.getId()).getNumeroCompte());
			// beanClient.setSoldeCC(client.getCompteEpargne().getSolde());
			// beanClient.setSoldeEp(client.getCompteEpargne().getSolde());
			beanClient.setAdresse(client.getAdresse());
			// beanClient.setCompte(servCl.client);
			System.out.println("solde " + i + "  = " + beanClient.getSoldeCC());
			System.out.println("client no : " + i);
			lbc.add(beanClient);
			i++;
		}
		System.out.println("list beans : " + lbc);

		return new ResponseEntity<List<BeanClient>>(lbc, HttpStatus.OK);
	}

	@GetMapping(value = "/clients/{id}", produces = "application/json")
	public BeanClient getClientById(@PathVariable String id) {
		Client client = servCl.listClients().get(Integer.parseInt(id));
		BeanClient bc = new BeanClient();

		bc.setId(client.getId());
		bc.setNom(client.getNom());
		bc.setPrenom(client.getPrenom());
		bc.setSoldeCC(client.getCompteCourant().getSolde());
		bc.setSoldeEp(client.getCompteEpargne().getSolde());
		bc.setAdresse(client.getAdresse());
		System.out.println("" + bc.getAdresse());
		return bc;
	}

	@PostMapping(value = "/clientPost", produces = "application/json")
	public HttpStatus addOperation(@RequestBody BeanClient beanCl, UriComponentsBuilder builder) {

		System.err.println("bean recu " + beanCl);
		
		//Client c = new Client(beanCl.getNom(),beanCl.getPrenom(),null,null);
		Client c= new Client();
		c.setAdresse(beanCl.getAdresse());
		c.setNom(beanCl.getNom());
		c.setPrenom(beanCl.getPrenom());
		c.setEmail(beanCl.getEmail());
		System.out.println("************** client 0 : "+c);
		
//		c.setCompteCourant(new CompteCourant(beanCl.getNumCompteCourant(),beanCl.getSoldeCC()));
//		c.setCompteEpargne(new CompteEpargne(beanCl.getNumCompteEpargne(),beanCl.getSoldeEp()));
		CompteCourant cc = new CompteCourant(beanCl.getNumCompteCourant(),beanCl.getSoldeCC()); 
		//cc.setSolde(beanCl.getSoldeCC());
		
		
		CompteEpargne ep = new CompteEpargne(beanCl.getNumCompteEpargne(),beanCl.getSoldeEp()); 
		// ep.setSolde(beanCl.getSoldeEp());
		servCl.addClientToConseiller(c, 5);
		servCl.addCompte(c.getId(), cc);
		servCl.addCompte(c.getId(), ep);
		
		System.out.println("-------"+ c.getCompteCourant().getNumeroCompte());
		System.out.println("------------------"+ cc.getNumeroCompte());
		System.out.println("------------------"+ ep.getNumeroCompte());
		
		
		
	//c.setConseiller(servCl.findClient(0).getConseiller());
		
		




		// client.setConseiller(conseiller);
		// client.setConseiller(serviceConseiller.findConseiller(beanCl.getIdcons()));


		// System.out.println("" +client.getEmail());

		// (new
		// Client(beanCl.getNom(),beanCl.getPrenom(),null,null,beanCl.getEmail(),beanCl.getAdresse()),
		// beanCl.getIdcons())
		// System.out.println(beanCl);

		boolean flag = false;


		return HttpStatus.OK;

		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getArticleId()).toUri());
		// return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
