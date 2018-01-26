package org.formation.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PageController {
	@RequestMapping(value = "/ajoutClient", method = RequestMethod.GET)
	public String ajoutClient(Model model) {

		return "ajoutClient";
		
	}
}
