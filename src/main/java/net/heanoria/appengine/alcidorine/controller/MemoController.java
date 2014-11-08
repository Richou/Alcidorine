package net.heanoria.appengine.alcidorine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {

	public MemoController(){}
	
	@RequestMapping(value = "/memos.do", method = RequestMethod.GET)
	public String doMemosPage(ModelMap model) {
		return "memo/index";
	}
	
	
}
