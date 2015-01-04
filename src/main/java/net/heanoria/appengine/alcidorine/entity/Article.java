package net.heanoria.appengine.alcidorine.entity;

import java.util.Date;

import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Article {
    
    public static final String ARTICLE_ID_FIELD = "id";
    public static final String ARTICLE_TITLE_FIELD = "title";
    public static final String ARTICLE_DATE_FIELD = "date";
    public static final String ARTICLE_CONTENT_FIELD = "content";
    public static final String ARTICLE_IMAGE_FIELD = "image";

    @Id
    private Long id;
    
    @Index
    private String title;
    
    private Date date;
    
    private String content;
    
    private Blob image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
    
}
