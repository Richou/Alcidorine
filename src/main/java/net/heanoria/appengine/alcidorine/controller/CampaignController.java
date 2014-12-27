package net.heanoria.appengine.alcidorine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CampaignController {

	public CampaignController () {}
	
	@RequestMapping(value = "/campaign.do", method = RequestMethod.GET)
	public String doHome() {
		
		return "campaign/home";
	}
}
