package net.heanoria.appengine.alcidorine.services;

import static net.heanoria.appengine.alcidorine.entity.Article.ARTICLE_ID_FIELD;

import java.util.List;

import javax.inject.Named;

import org.springframework.stereotype.Service;

import net.heanoria.appengine.alcidorine.aspects.Logging;
import net.heanoria.appengine.alcidorine.dao.ArticleDao;
import net.heanoria.appengine.alcidorine.entity.Article;
import net.heanoria.appengine.alcidorine.exceptions.EntityCreationException;
import net.heanoria.appengine.alcidorine.exceptions.EntityFetchException;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Service("articleService")
@Api(name = "alcidorine", version = "v1", description = "Alcidorine API service")
public class ArticleServiceImpl implements ArticleService{

    private ArticleDao articleDao = new ArticleDao();
    
    @ApiMethod(name = "alcidorine.articles.list",path = "articles/list",httpMethod = HttpMethod.GET)
    public List<Article> getArticles() {
        return articleDao.listAll();
    }
    
    @ApiMethod(name = "alcidorine.articles.create", path = "articles/create", httpMethod = HttpMethod.POST)
    public Article createArticle(Article entity) {
        Article article = articleDao.save(entity);
        if(article.getId() != null) {
            return article;
        }
        throw new EntityCreationException("Cannot create entity Article with title ['"+ entity.getTitle() +"']");
    }
    
    @Logging
    @ApiMethod(name = "alcidorine.articles.view", path="articles/view/{id}", httpMethod = HttpMethod.GET)
    public Article getOne(@Named(ARTICLE_ID_FIELD) Long id) {
        Article article = articleDao.get(id);
        if(article == null) {
            throw new EntityFetchException("Cannot find article with id ['" + id + "']");
        }
        return article;
    }
    
}
