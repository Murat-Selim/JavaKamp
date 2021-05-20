package GameProject;

public class CampaignManager implements CampaignService{
	
	public void add(Campaign campaign) {
		
		System.out.println("kampanya eklendi :" + " " + campaign.getCampaignName());
	}

	public void delete(Campaign campaign) {
		
		System.out.println("kampanya silindi :" + " " + campaign.getCampaignName());
	}
	
    public void update(Campaign campaign) {
		
		System.out.println("kampanya guncellendi :" + " " + campaign.getCampaignName());
	}

	public void finish(Campaign campaign) {
		
		System.out.println("Kampanya bitti." + " " + campaign.getCampaignName());
	}
}
