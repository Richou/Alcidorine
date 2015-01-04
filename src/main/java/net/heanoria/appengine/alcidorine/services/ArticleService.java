package net.heanoria.appengine.alcidorine.services;

import static net.heanoria.appengine.alcidorine.entity.Article.ARTICLE_ID_FIELD;

import javax.inject.Named;

import net.heanoria.appengine.alcidorine.entity.Article;

public interface ArticleService {

    public Article getOne(@Named(ARTICLE_ID_FIELD) Long id);
    
}
