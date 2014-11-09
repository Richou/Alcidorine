package net.heanoria.appengine.alcidorine.services;

import java.util.List;

import net.heanoria.appengine.alcidorine.dao.ArticleDao;
import net.heanoria.appengine.alcidorine.entity.Article;
import net.heanoria.appengine.alcidorine.exceptions.EntityCreationException;

import org.springframework.stereotype.Service;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Service("articleService")
@Api(name = "alcidorine", version = "v1", description = "Alcidorine API service")
public class ArticleService {

	private ArticleDao articleDao = new ArticleDao();
	
	@ApiMethod(name = "alcidorine.articles.list",path = "articles/list",httpMethod = HttpMethod.GET)
	public List<Article> getArticles() {
		return articleDao.listAll();
	}
	
	@ApiMethod(name = "alcidorine.articles.create", path = "articles/create", httpMethod = HttpMethod.POST)
	public Article createArticle(Article article) {
		article = articleDao.save(article);
		if(article.getId() != null)
			return article;
		throw new EntityCreationException("Cannot create entity Article with title ['"+ article.getTitle() +"']");
	}
	
}
