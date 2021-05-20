package GameProject;

public class PlayerManager implements PlayerService{
	
	public void add(Player player) {
		  System.out.println("kay�t basarili : "+ player.getFirstName() + "  " + player.getLastName());
	  }
	  
	  public void update(Player player) {
		  System.out.println(player.getFirstName() + "  " + player.getLastName() + " " + player.getNationalIdentity());
		  System.out.println("bilgiler g�ncellendi.");
	  }
	  public void delete(Player player) {
		  System.out.println("hesab�n silindi : " + player.getFirstName() + "  " + player.getLastName());
	  }
}
