package net.heanoria.appengine.alcidorine.dao;

import static com.googlecode.objectify.ObjectifyService.register;
import net.heanoria.appengine.alcidorine.entity.Memo;

public class MemoDao extends ObjectifyDao<Memo>{

	static {
		register(Memo.class);
	}
	
	public MemoDao() {
		super(Memo.class);
	}

}
