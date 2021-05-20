package GameProject;

public class GameManager implements GameService{
	
	  public void add(Game game) {
		  System.out.println("oyun eklendi : "+ game.getName());
	  }
	  public void delete(Game game) {
		  System.out.println("oyun silindi : " + game.getName());
	  }
	  public void update(Game game) {
		  System.out.println("oyun güncellendi : "+ game.getName());
		  
	  }
	 
}
