package net.heanoria.appengine.alcidorine.dao;

import static com.googlecode.objectify.ObjectifyService.register;
import net.heanoria.appengine.alcidorine.entity.Campaign;

public class CampaignDao extends ObjectifyDao<Campaign>{

	static {
		register(Campaign.class);
	}
	
	public CampaignDao() {
		super(Campaign.class);
	}

}
