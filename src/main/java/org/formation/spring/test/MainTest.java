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
import org.formation.spring.entity.Virement;
import org.formation.spring.service.IServiceGestionClient;
import org.formation.spring.service.IServiceGestionConseiller;
import org.formation.spring.service.ServiceGestionClient;
import org.formation.spring.service.ServiceGestionConseiller;
import org.formation.spring.service.ServiceVirement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxiBanqueConfig.class);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");

//		IServiceGestionClient serviceGestionClient = context.getBean("serviceClient", ServiceGestionClient.class);
//		IServiceGestionConseiller gerantService = context.getBean("gerantService", ServiceGestionConseiller.class);
		
		ServiceVirement serviceVirement = context.getBean("serviceVirement", ServiceVirement.class);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");

//		 Agence ag = new Agence("Paris 5");
//		 Gerant gerant = new Gerant("Dupont","Fred",ag);
//		 Agence ag2 = new Agence("La Defense");
//		 Gerant gerant2 = new Gerant("Douglas","Mike",ag2);
//		 Conseiller conseillerB2 = new
//		 Conseiller("NDH","Robert",gerant,ag);
//		 Conseiller conseiller = new
//				 Conseiller("Hjka","Niko",gerant,ag);
//		 
//		 Client c = new Client("Spear", "Brineuy", " abc@gmail.com",
//		 new Adresse("1 rue Verdun", 75001, "Paris 1", "014356782"));
//		 
//		 Client c2 = new Client("Porman", "Nath", " npre2@gmail.com",
//		 new Adresse("2 rue General", 75012, "Paris 12", "016732904"));
//		
//		 Client c3 = new Client("Kiko", "Azika", " hjkpc@gmail.com",
//				 new Adresse("3 rue Charle de Gaule", 94030, "St Maur", "014526875"));
//		 Client c4 = new Client("Thompson", "Lili", " nbchdqc@gmail.com",
//				 new Adresse("4 avenue Elerc", 95040, "Champigni", "0536426875"));
//		
//		
//
//		 gerantService.createAgence(ag);
//		 gerantService.createAgence(ag2);
//		 System.out.println("***************");
//		 
//		 
//		 conseiller.setLogin("cons");
//		 conseiller.setPwd("cons");
//		 
//		 gerantService.addGerant(gerant,ag.getId());
//		 gerantService.addGerant(gerant2,ag.getId());
//		 System.out.println("***************");
//		 gerantService.addConseillerToGerant(conseiller,gerant.getId());
//		 gerantService.addConseillerToGerant(conseillerB2,gerant.getId());
//	
//		 System.out.println("***************");
//	
//		 serviceGestionClient.addClientToConseiller(c,conseiller.getId());
//		 serviceGestionClient.addClientToConseiller(c2,conseiller.getId());
//		 serviceGestionClient.addClientToConseiller(c3,conseiller.getId());
//		 serviceGestionClient.addClientToConseiller(c4,conseiller.getId());
//
//
//		CompteCourant cc = new CompteCourant("456217234", 2345.55, "123890123", 1000);
//		CompteEpargne ep = new CompteEpargne("76352231", 6000.00);
//		CompteCourant cc2 = new CompteCourant("497954324", 265.55, "234566543", 1000);
//		CompteEpargne ep2= new CompteEpargne("7689765490", 400.00);
//		serviceGestionClient.addCompteToClient(c.getId(), cc);
//		serviceGestionClient.addCompteToClient(c.getId(), ep);
//		serviceGestionClient.addCompteToClient(c2.getId(), cc2);
//		serviceGestionClient.addCompteToClient(c2.getId(), ep2);
		
		
		serviceVirement.createVirement(7, 100,new Date(), 11, 14, "Virement");
		//List<Virement> list = serviceVirement.getVirementsByIdclient(7);
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
