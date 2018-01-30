package org.formation.spring.test;

import java.util.Date;
import java.util.List;

import org.formation.spring.config.ProxiBanqueConfig;
import org.formation.spring.entity.Adresse;
import org.formation.spring.entity.Agence;
import org.formation.spring.entity.Client;
import org.formation.spring.entity.Compte;
import org.formation.spring.entity.CompteCourant;
import org.formation.spring.entity.CompteEpargne;
import org.formation.spring.entity.Conseiller;
import org.formation.spring.entity.Gerant;
import org.formation.spring.entity.Operation;
import org.formation.spring.service.IServiceGestionClient;
import org.formation.spring.service.IServiceGestionConseiller;
import org.formation.spring.service.ServiceGestionClient;
import org.formation.spring.service.ServiceGestionConseiller;
import org.formation.spring.service.ServiceOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTestOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxiBanqueConfig.class);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");
	
		
		
		
		ServiceOperation serviceOperation = context.getBean("serviceOperation", ServiceOperation.class);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");
				
		
		serviceOperation.createVersement(10000,"1517190441829", "Versement");
		serviceOperation.createVirement(5000,"1517190441829", "1517190441971", "Virement");
		serviceOperation.createVersement(2000,"1517190441829", "Versement");
		
		
		List<Operation> list = serviceOperation.getOperationsByIdClient(7);
		for(Operation virement: list) { System.out.println(virement);
			
		}
		System.out.println("listssssssssssssssssssssssssss");


//		Virement virement = new Virement();
//		Date d=new Date();
//		virement.setDate(d);
//		Double m=(double) 100;
//		virement.setMontant(m);
//		virement.setEtat("COMPTA");
//		//virement.setId(1);
//		virement.setIdcomptedepart(1);
//		virement.setIdcomptecible(2);
//		virement.setType("VI");
//		serviceVirement.setVirementForClient(7, virement);
		
		
		
		
//		
//		for(Client c5 :serviceGestionClient.listClientsByConseiller(3)){
//			System.out.println(c5);
//		};
//		List<Compte> list=serviceGestionClient.listCompteByClientId(4);
//		for(Compte c4 :list) {
//			System.out.println(c4);
//		}
	}

}
