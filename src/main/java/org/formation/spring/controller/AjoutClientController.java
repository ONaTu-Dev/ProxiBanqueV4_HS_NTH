package org.formation.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.formation.spring.entity.Adresse;
import org.formation.spring.entity.Client;
import org.formation.spring.service.IServiceGestionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * La direction vers la page liste de tous les clients d'un conseiller
 * @author HS NTH
 *
 */
@Controller
public class AjoutClientController {
	@Autowired
	private IServiceGestionClient serviceClient;

	
	@RequestMapping(value = "/ajoutClient", method = RequestMethod.POST)
	public ModelAndView createClient(HttpServletRequest request,HttpServletRequest response) {
//		int nbrClient=serviceClient.selectClientByConseillerId(int id).size();
//		if (nbrClient <11) {
		String nom = request.getParameter("name");
		String prenom= request.getParameter("prenom");
		String rue= request.getParameter("rue");		
		int codePostal= Integer.parseInt(request.getParameter("codepostale"));
		String ville= request.getParameter("ville");
		String email= request.getParameter("email");
		String tel= request.getParameter("tel");
		Adresse ad = new Adresse(rue,codePostal,ville,tel);
		Client client = new Client(nom,prenom,email,ad);
//		}
//		else 
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(rue);
		System.out.println(codePostal);
		System.out.println(ville);
		System.out.println(email);
		System.out.println(tel);
		serviceClient.addClientToConseiller(client, 5);
		 return new ModelAndView("messageAddClient");
	}
}

