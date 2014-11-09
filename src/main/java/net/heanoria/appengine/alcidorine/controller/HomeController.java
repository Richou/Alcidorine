package net.heanoria.appengine.alcidorine.controller;

import java.util.List;
import java.util.logging.Logger;

import net.heanoria.appengine.alcidorine.entity.Article;
import net.heanoria.appengine.alcidorine.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class.getName());
	
	@Autowired
	private ArticleService articleService = null;
	
	public HomeController() {}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String doHome(ModelMap model) {
		
		List<Article> articles = articleService.getArticles();
		if(articles != null) {
			logger.info("Found " + articles.size() + " articles");
		}
		
		model.addAttribute("articles", articles);
		
		return "home/index";
	}
}
