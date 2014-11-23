package net.heanoria.appengine.alcidorine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	public HomeController() {}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String doHome(ModelMap model) {
		return "home/index";
	}
}
