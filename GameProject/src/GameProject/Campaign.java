package GameProject;

public class Campaign {
	private int id;
	private String CampaignName;

	public Campaign(int id, String CampaignName) {
		super();
		this.id = id;
		this.CampaignName = CampaignName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return CampaignName;
	}

	public void setCampaignName(String CampaignName) {
		this.CampaignName = CampaignName;
	}

}
