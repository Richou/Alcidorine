package net.heanoria.appengine.alcidorine.services;

import java.util.List;

import net.heanoria.appengine.alcidorine.aspects.Logging;
import net.heanoria.appengine.alcidorine.entity.MemoCategory;

public interface MemoService {

	@Logging
	public List<MemoCategory> getMemoTopCategories();
	
	public MemoCategory createMemoCategory(MemoCategory memoCat);
	
}
