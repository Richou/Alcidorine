package net.heanoria.appengine.alcidorine.services;

import java.util.List;

import net.heanoria.appengine.alcidorine.dao.MemoDao;
import net.heanoria.appengine.alcidorine.entity.Memo;

import org.springframework.stereotype.Service;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Service("memoService")
@Api(name = "alcidorine", version = "v1", description = "Alcidorine API service")
public class MemoService {

	private MemoDao memoDao = new MemoDao();
	
	@ApiMethod(name = "alcidorine.memos.list",path = "memos/list",httpMethod = HttpMethod.GET)
	public List<Memo> getArticles() {
		return memoDao.listAll();
	}
}
