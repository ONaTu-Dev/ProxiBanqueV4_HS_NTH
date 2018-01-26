package org.formation.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.spring.entity.Client;
import org.formation.spring.entity.Conseiller;
import org.formation.spring.entity.Employe;
import org.formation.spring.entity.Gerant;
import org.formation.spring.service.IServiceGestionAgence;
import org.formation.spring.service.IServiceGestionClient;
import org.formation.spring.service.IServiceGestionConseiller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Le controller renvois a servlet dispatcher les informations concernant le login
 * mot de passe d'un conseiller ou d'un gerant ce qui emmenne a la page correspondant 
 * @author HS NTH
 *
 */
@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IServiceGestionClient serviceClient;

	@Autowired
	private IServiceGestionConseiller serviceConseiller;
	
	@Autowired
	private IServiceGestionAgence serviceAgence;

	@RequestMapping(value = "/Welcome", method = RequestMethod.POST)
	public ModelAndView employeLogin(HttpServletRequest request, HttpServletResponse response) {

		String a = request.getParameter("user");
		String b = request.getParameter("password");

		Conseiller cons = serviceConseiller.findByLoginAndPwd(a, b);
		Gerant ger = serviceAgence.findByLoginAndPwd(a, b);
		
		LOGGER.info("tentative de connexion user :" + a + "pwd :" + b);

		if ((cons != null) && (cons.getLogin().equals(a)) && (cons.getPwd().equals(b))) {
			
			LOGGER.info("connexion conseiller user :" + a + "pwd :" + b);
			
			List<Client> clients = serviceClient.listClientsByConseiller(cons.getId());
			return new ModelAndView("welcome_conseiller", "clients", clients);

		} else if ((ger != null) && (ger.getLogin().equals(a)) && (ger.getPwd().equals(b))) {

			LOGGER.info("connexion gerant user :" + a + "pwd :" + b);
			
			List<Conseiller> conseillers = serviceConseiller.listConseillersByGerant(ger.getId());
			return new ModelAndView("welcome_gerant","conseillers",conseillers);

		} else { return new ModelAndView("unknown-num"); }
		

	}  
}
