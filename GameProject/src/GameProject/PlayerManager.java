package GameProject;

public class PlayerManager implements PlayerService{
	
	public void add(Player player) {
		  System.out.println("kayýt basarili : "+ player.getFirstName() + "  " + player.getLastName());
	  }
	  
	  public void update(Player player) {
		  System.out.println(player.getFirstName() + "  " + player.getLastName() + " " + player.getNationalIdentity());
		  System.out.println("bilgiler güncellendi.");
	  }
	  public void delete(Player player) {
		  System.out.println("hesabýn silindi : " + player.getFirstName() + "  " + player.getLastName());
	  }
}
