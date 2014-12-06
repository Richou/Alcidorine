package net.heanoria.appengine.alcidorine.services;

import static net.heanoria.appengine.alcidorine.entity.MemoCategory.MEMOCAT_ID_FIELD;

import java.util.List;
import java.util.logging.Logger;

import net.heanoria.appengine.alcidorine.aspects.Logging;
import net.heanoria.appengine.alcidorine.dao.MemoCategoryDao;
import net.heanoria.appengine.alcidorine.dao.MemoDao;
import net.heanoria.appengine.alcidorine.entity.Memo;
import net.heanoria.appengine.alcidorine.entity.MemoCategory;
import net.heanoria.appengine.alcidorine.entity.MemoCategoryWrapper;
import net.heanoria.appengine.alcidorine.exceptions.EntityCreationException;
import net.heanoria.appengine.alcidorine.exceptions.EntityFetchException;

import org.springframework.stereotype.Service;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;

@Service("memoService")
@Api(name = "alcidorine", version = "v1", description = "Alcidorine API service")
public class MemoServiceImpl implements MemoService{

	private final Logger logger = Logger.getLogger(MemoServiceImpl.class.getName());
	
	private MemoDao memoDao = new MemoDao();
	private MemoCategoryDao memoCategoryDao = new MemoCategoryDao();
	
	@ApiMethod(name = "alcidorine.memos.list",path = "memos/list",httpMethod = HttpMethod.GET)
	public List<Memo> getMemos() {
		return memoDao.listAll();
	}
	
	@ApiMethod(name = "alcidorine.memos.categories.list", path = "memos/categories/list", httpMethod = HttpMethod.GET)
	public List<MemoCategory> getMemoCategories() {
		return memoCategoryDao.listAll();
	}
	
	@Logging
	@ApiMethod(name = "alcidorine.memos.categories.listTop", path = "memos/categories/listTop", httpMethod = HttpMethod.GET)
	public List<MemoCategory> getMemoTopCategories() {
		return memoCategoryDao.fetchTopCategories();
	}
	
	@ApiMethod(name = "alcidorine.memos.categories.create", path = "memos/categories/create", httpMethod = HttpMethod.POST)
	public MemoCategory createMemoCategory(MemoCategory memoCat) {
		memoCat = memoCategoryDao.save(memoCat);
		if(memoCat != null && memoCat.getId() != null) return memoCat;
		logger.severe("Cannot create Memo Category");
		throw new EntityCreationException("Cannot create MemoCategory");
	}
	
	@ApiMethod(name = "alcidorine.memos.categories.createAll", path = "memos/categories/createAll", httpMethod = HttpMethod.POST)
	public void createAllMemoCategories(MemoCategoryWrapper memoCategoryWrapper) {
		memoCategoryDao.saveAll(memoCategoryWrapper.getItems());
	}
	
	@ApiMethod(name = "alcidorine.memos.categories.view", path = "memos/categories/view/{id}", httpMethod = HttpMethod.GET)
	public MemoCategory getMemoCategoryById(@Named(MEMOCAT_ID_FIELD) Long id) {
		MemoCategory memoCategory = memoCategoryDao.get(id);
		if(memoCategory == null) {
			throw new EntityFetchException("Cannot find article with id ['" + id + "']");
		}
		return memoCategory;		
	}
}
