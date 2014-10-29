package net.heanoria.appengine.alcidorine.dao;

import net.heanoria.appengine.alcidorine.entity.Article;

import com.googlecode.objectify.ObjectifyService;

public class ArticleDao extends ObjectifyDao<Article>{

	static {
		ObjectifyService.register(Article.class);
	}
	
	public ArticleDao() {
		super(Article.class);
	}

}
