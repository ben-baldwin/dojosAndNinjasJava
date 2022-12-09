package com.ben.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ben.dojosandninjas.models.Dojo;
import com.ben.dojosandninjas.models.Ninja;
import com.ben.dojosandninjas.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainServ;
	
	
	// ---------------- CREATING A DOJO -----------------//
	@GetMapping(value={"/dojos/new"})
	public String createDojo(
		@ModelAttribute("dojoObj")Dojo emptyDojo
	) {
		return "/dojo/create.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String processDojo(
		@Valid @ModelAttribute("dojoObj")Dojo filledDojo,
		BindingResult results
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			return "/dojo/create.jsp";
		}
		// VALIDATIONS PASS
		mainServ.createDojo(filledDojo);
		return "redirect:/";
	}
	
	// ---------------- CREATING A NINJA -----------------//
	@GetMapping("/ninjas/new")
	public String createNinja(
		@ModelAttribute("ninjaObj") Ninja emptyNinjaObj,
		Model model
	) {
//		Adding allDojos to the Model wrapper class
		model.addAttribute("allDojos", mainServ.getAllDojos());
		return "/ninja/create.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String processNinja(
		@Valid @ModelAttribute("ninjaObj")Ninja filledNinja,
		BindingResult results,
		Model model
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			model.addAttribute("allDojos", mainServ.getAllDojos());
			return "/ninja/create.jsp";
		}
		// VALIDATIONS PASS
		mainServ.createNinja(filledNinja);
		return "redirect:/ninja/new";
	}
	
	// ---------------- DISPLAY ONE DOJO -----------------//
	@GetMapping("/dojos/{id}")
	public String oneDojo(
		@PathVariable("id") Long dojoId,
		Model model
	) {
		Dojo oneDojo = mainServ.getOneDojo(dojoId);
		model.addAttribute("dojo", oneDojo);
		return "/dojo/display.jsp";
	}
	
}