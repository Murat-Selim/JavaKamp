package GameProject;

public class GameSaleManager implements GameSaleService{

	@Override
	public void gameSale(Player player, Game game) {
		
		System.out.println(player.getFirstName() + " "+ game.getName() + " isimli Oyunu "+ game.getPrice() + " TL'ye Aldi");

	}

	@Override
	public void gameSale(Player player, Game game, Campaign campaign) {
		
		System.out.println(player.getFirstName() + " "+ game.getName() + " isimli Oyunu " + campaign.getCampaignName() + " Kampanyasindan yararlanarak 150 TL'ye Aldi");

	}

}
