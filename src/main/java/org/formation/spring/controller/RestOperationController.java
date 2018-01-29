package org.formation.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.formation.spring.dto.BeanOperation;
import org.formation.spring.entity.Operation;
import org.formation.spring.service.IServiceOperation;
import org.formation.spring.service.ServiceGestionClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RestOperationController {
	@Autowired
	private IServiceOperation serviceOperation;
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceGestionClient.class);

	/**
	 * Tous les operation de tous les clients
	 *
	 */

	@PostMapping(value = "/operations", produces = "application/json")
	public List<BeanOperation> getAllOperations(@RequestBody BeanOperation bVir, UriComponentsBuilder builder) {
		
		List<Operation> listOperations = serviceOperation.getAllOperations(bVir.getCritere());
		List<BeanOperation> listJson = new ArrayList<BeanOperation>();
		for (Operation virement : listOperations) {
			BeanOperation beanVir = new BeanOperation();
			LOGGER.debug("-------new beanVirement");
			beanVir.setId(virement.getId());
			LOGGER.debug("-------id beanVirement" + beanVir.getId());
			beanVir.setIdclient(virement.getClient().getId());
			LOGGER.debug("-------id client beanVirement" + beanVir.getIdclient());
			beanVir.setNomClient(virement.getClient().getNom());
			beanVir.setPrenomClient(virement.getClient().getPrenom());
			beanVir.setIdcomptedepart(virement.getIdcomptedepart());
			LOGGER.debug("-------idcomptedepart beanVirement" + beanVir.getIdcomptedepart());
			
			beanVir.setIdcomptecible(virement.getIdcomptecible());
			LOGGER.debug("-------id comptecible beanVirement" + beanVir.getIdcomptecible());
			beanVir.setNumCompteDepart(virement.getNumcomptedepart());
			LOGGER.debug("-------num comptedepart beanVirement" + beanVir.getNumCompteDepart());
			beanVir.setNumCompteCible(virement.getNumcomptecible());
			
			beanVir.setDate(virement.getDate());
			beanVir.setEtat(virement.getEtat());
			beanVir.setTypeOper(virement.getType());
			beanVir.setMontant(virement.getMontant());
			listJson.add(beanVir);

		}

		return listJson;

	}
	
	@PostMapping(value ="/operationsPost", produces="application/json")
	public HttpStatus addOperation(@RequestBody BeanOperation beanVir, UriComponentsBuilder builder) {
	   
	System.out.println(beanVir);
	
	boolean flag = false;
	if (beanVir.getTypeOper().equalsIgnoreCase("Virement")) {
		flag=serviceOperation.createVirement(beanVir.getMontant(),beanVir.getNumCompteDepart(), beanVir.getNumCompteCible(), beanVir.getTypeOper());
	}
	
	if (beanVir.getTypeOper().equalsIgnoreCase("Versement")) {
		flag=serviceOperation.createVersement(beanVir.getMontant(),beanVir.getNumCompteCible(), beanVir.getTypeOper());
	}
			
	   if (flag == false) {
	       	return HttpStatus.BAD_REQUEST;
	   }
	   return HttpStatus.OK;
		
//	   HttpHeaders headers = new HttpHeaders();
//	   headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getArticleId()).toUri());
//	   return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	} 
}
