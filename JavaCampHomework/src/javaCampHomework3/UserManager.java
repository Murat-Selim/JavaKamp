package javaCampHomework3;

public class UserManager {
		public void add(User user) {
			System.out.println("ad�: "+user.getFirstName()+" "+"soyad�:"+user.getLastName());
			System.out.println("email: "+user.getEmail()+" "+"sifre: "+user.password());
			System.out.println("kullan�c� eklendi");
		}
		
		public void delete(User user) {
			System.out.println("ad�: "+user.getFirstName()+" "+"soyad�:"+user.getLastName());
			System.out.println("kullan�c� silindi");
		}
		
		public void update(User user) {
			System.out.println("ad�: "+user.getFirstName()+" "+"soyad�:"+user.getLastName());
			System.out.println("kullan�c� g�ncellendi");
		}

		
}
