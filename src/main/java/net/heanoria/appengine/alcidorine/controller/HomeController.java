package net.heanoria.appengine.alcidorine.controller;

import net.heanoria.appengine.alcidorine.entity.Article;
import net.heanoria.appengine.alcidorine.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private ArticleService articleService = null;
	
	public HomeController() {}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String doHome(ModelMap model) {
		return "home/home";
	}
	
	@RequestMapping(value = "/articles/view.do", method = RequestMethod.GET)
	public String doViewArticle(
			@RequestParam(value="id", required = true) Long id,
			ModelMap model) {
		Article article = articleService.getOne(id);
		model.addAttribute("article", article);
		return "home/view";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
}
