package net.heanoria.appengine.alcidorine.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static com.googlecode.objectify.ObjectifyService.register;

import java.util.List;

import net.heanoria.appengine.alcidorine.entity.MemoCategory;

public class MemoCategoryDao extends ObjectifyDao<MemoCategory>{

	static {
		register(MemoCategory.class);
	}
	
	public MemoCategoryDao() {
		super(MemoCategory.class);
	}
	
	public List<MemoCategory> fetchTopCategories() {
		return ofy().load().type(MemoCategory.class).filter(MemoCategory.MEMOCAT_PARENT_FIELD, null).list();
	}

}
