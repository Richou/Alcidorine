package net.heanoria.appengine.alcidorine.services;

import java.util.List;

import net.heanoria.appengine.alcidorine.dao.CampaignDao;
import net.heanoria.appengine.alcidorine.entity.Campaign;

import org.springframework.stereotype.Service;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Service("campaignService")
@Api(name = "alcidorine", version = "v1", description = "Alcidorine API service")
public class CampaignService {

	private CampaignDao campaignDao = new CampaignDao();
	
	@ApiMethod(name = "alcidorine.campaign.list",path = "campaigns/list",httpMethod = HttpMethod.GET)
	public List<Campaign> getCampaigns() {
		return campaignDao.listAll();
	}
	
}
