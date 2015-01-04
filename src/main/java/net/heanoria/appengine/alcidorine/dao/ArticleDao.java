package net.heanoria.appengine.alcidorine.dao;

import static com.googlecode.objectify.ObjectifyService.register;
import net.heanoria.appengine.alcidorine.entity.Article;

public class ArticleDao extends ObjectifyDao<Article>{

    static {
        register(Article.class);
    }
    
    public ArticleDao() {
        super(Article.class);
    }

}
