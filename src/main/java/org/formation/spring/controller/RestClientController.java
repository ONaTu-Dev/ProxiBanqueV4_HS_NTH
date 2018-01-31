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
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@PostMapping(value = "/clientPost", produces = "application/json;charset=utf-8")
	public HttpStatus addclient(@RequestBody BeanClient beanCl, UriComponentsBuilder builder) {

		System.out.println("*****************bean recu " + beanCl.toString());
		
		//Client c = new Client(beanCl.getNom(),beanCl.getPrenom(),null,null);
		Client c= new Client();
		Adresse a= new Adresse(beanCl.getAdresseline(), beanCl.getCodepostal(), beanCl.getVille(), beanCl.getTelephone());
		c.setAdresse(a);
		c.setNom(beanCl.getNom());
		c.setPrenom(beanCl.getPrenom());
		c.setEmail(beanCl.getEmail());
		c.affiche();
		servCl.addClientToConseiller(c, 5);
		
		CompteCourant cc = new CompteCourant(); 
		cc.setSolde(beanCl.getSoldeCC());
//		c.setCompteCourant(new CompteCourant(beanCl.getNumCompteCourant(),beanCl.getSoldeCC()));
//		c.setCompteEpargne(new CompteEpargne(beanCl.getNumCompteEpargne(),beanCl.getSoldeEp()));
		
		CompteEpargne ep = new CompteEpargne(); 
		ep.setSolde(beanCl.getSoldeEp());
		
		System.out.println("********Ajouter compte*******************");
		cc.setAutorisationDecouvert(1000);
		ep.setTauxRemuneration(0.03);
		servCl.addCompte(c.getId(), cc);
		servCl.addCompte(c.getId(), ep);
		
		
		
		System.out.println("*****Client ajouté********");
		

		return HttpStatus.OK;

		
	}
	
	
	@PostMapping(value = "/clientUpdate", produces = "application/json")
	public HttpStatus updateclient(@RequestBody BeanClient beanCl, UriComponentsBuilder builder) {

		System.out.println("*****************bean recu " + beanCl.toString());
		Adresse a=null;
		if ((beanCl.getAdresseline()!=null)
				&&(beanCl.getVille()!=null)
				&&(beanCl.getTelephone()!=null)){
			 a=new Adresse(beanCl.getAdresseline(), beanCl.getCodepostal(), beanCl.getVille(), beanCl.getTelephone());
		}

		servCl.updateClient(beanCl.getId(), a, beanCl.getNom(),beanCl.getPrenom(),beanCl.getEmail());
		
		
		
		System.out.println("*****Client MAJ********");
		

		return HttpStatus.OK;

		
	}
	@DeleteMapping(value = "/clientDel/{id}", produces = "application/json")
	public ResponseEntity<Void> deleteClient(@RequestParam("id") String id) {
	servCl.deleteClient(Integer.parseInt(id));
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	} 
	
}
