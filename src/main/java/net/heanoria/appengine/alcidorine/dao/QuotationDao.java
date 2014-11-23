package net.heanoria.appengine.alcidorine.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static net.heanoria.appengine.alcidorine.entity.Quotation.QUOTATION_RANK_FIELD;
import static net.heanoria.appengine.alcidorine.utils.MathUtil.getRandomRange;
import net.heanoria.appengine.alcidorine.entity.Quotation;

import com.googlecode.objectify.ObjectifyService;

public class QuotationDao extends ObjectifyDao<Quotation>{

	static {
		ObjectifyService.register(Quotation.class);
	}
	
	public QuotationDao() {
		super(Quotation.class);
	}
	
	public Quotation getOneRandom() {
		
		int number = ofy().load().type(Quotation.class).count();
		Integer randomRank = getRandomRange(0, number - 1);
		return ofy().load().type(Quotation.class).filter(QUOTATION_RANK_FIELD + " =", randomRank).first().now();
	}

}
