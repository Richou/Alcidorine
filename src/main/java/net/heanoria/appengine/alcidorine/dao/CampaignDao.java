package net.heanoria.appengine.alcidorine.dao;

import com.googlecode.objectify.ObjectifyService;

import net.heanoria.appengine.alcidorine.entity.Campaign;

public class CampaignDao extends ObjectifyDao<Campaign>{

	static {
		ObjectifyService.register(Campaign.class);
	}
	
	public CampaignDao() {
		super(Campaign.class);
	}

}
