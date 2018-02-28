package com.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class IndexController {
	
	@GetMapping(value="")
	public ModelAndView index() {
		return new ModelAndView(new RedirectView("/swagger-ui.html"));
	}
	
}
