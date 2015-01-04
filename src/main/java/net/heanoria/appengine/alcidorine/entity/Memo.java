package net.heanoria.appengine.alcidorine.entity;

import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Memo {
    
    public static final String MEMO_ID_FIELD = "id";
    public static final String MEMO_CATEGORY_FIELD = "category";
    public static final String MEMO_TITLE_FIELD = "title";
    public static final String MEMO_CONTENT_FIELD = "content";
    public static final String MEMO_IMAGE_FIELD = "image";
    
    @Id
    private Long id;
    
    @Index
    private String title;
    @Index
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
