package net.heanoria.appengine.alcidorine.services;

import java.util.List;

import net.heanoria.appengine.alcidorine.dao.QuotationDao;
import net.heanoria.appengine.alcidorine.entity.Quotation;
import net.heanoria.appengine.alcidorine.exceptions.EntityCreationException;

import org.springframework.stereotype.Service;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Service("quotationService")
@Api(name = "alcidorine", version = "v1", description = "Alcidorine API service")
public class QuotationService {

	private QuotationDao quotationDao = new QuotationDao();
	
	@ApiMethod(name = "alcidorine.quotations.list", path="quotations/list", httpMethod = HttpMethod.GET)
	public List<Quotation> listAll() {
		return quotationDao.listAll();
	}
	
	@ApiMethod(name = "alcidorine.quotations.getRandom", path="quotations/random", httpMethod = HttpMethod.GET)
	public Quotation getRandom() {
		Quotation random = quotationDao.getOneRandom();
		return random;
	}
	
	@ApiMethod(name="alcidorine.quotations.create", path="quotations/create", httpMethod = HttpMethod.POST)
	public Quotation createQuotation(Quotation quotation) {
		quotation = quotationDao.save(quotation);
		if(quotation.getId() != null) return quotation;
		throw new EntityCreationException("Cannot create entity Quotation");
	}
	
}
