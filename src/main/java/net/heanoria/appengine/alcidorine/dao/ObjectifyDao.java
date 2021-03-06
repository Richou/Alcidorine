package net.heanoria.appengine.alcidorine.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

public class ObjectifyDao<T>{

    private Class<T> clazz;
    
    protected ObjectifyDao(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    public T save(T entity) {
        Key<T> savedEntity = ofy().save().entity(entity).now();
        return get(savedEntity.getId());
    }
    
    public void saveAll(List<T> entities) {
        ofy().save().entities(entities).now();
    }
    
    public List<T> listAll() {
        Query<T> all = ofy().load().type(this.clazz);
        return all.list();
    }
    
    public T get(Long id) {
        return ofy().load().type(this.clazz).id(id).now();
    }
    
    public void delete(T entity) {
        ofy().delete().entity(entity).now();
    }
}
