package net.heanoria.appengine.alcidorine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	public AdminController() {}
	
	@RequestMapping(value = "/admin/index.do", method = RequestMethod.GET)
	public String doAdminHome() {
		return "admin/index";
	}
}
