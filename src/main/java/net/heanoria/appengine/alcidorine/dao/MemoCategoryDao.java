package net.heanoria.appengine.alcidorine.dao;

import static com.googlecode.objectify.ObjectifyService.register;
import net.heanoria.appengine.alcidorine.entity.MemoCategory;

public class MemoCategoryDao extends ObjectifyDao<MemoCategory>{

	static {
		register(MemoCategory.class);
	}
	
	protected MemoCategoryDao() {
		super(MemoCategory.class);
	}

}
