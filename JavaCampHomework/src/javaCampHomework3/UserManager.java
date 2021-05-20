package javaCampHomework3;

public class UserManager {
		public void add(User user) {
			System.out.println("adý: "+user.getFirstName()+" "+"soyadý:"+user.getLastName());
			System.out.println("email: "+user.getEmail()+" "+"sifre: "+user.password());
			System.out.println("kullanýcý eklendi");
		}
		
		public void delete(User user) {
			System.out.println("adý: "+user.getFirstName()+" "+"soyadý:"+user.getLastName());
			System.out.println("kullanýcý silindi");
		}
		
		public void update(User user) {
			System.out.println("adý: "+user.getFirstName()+" "+"soyadý:"+user.getLastName());
			System.out.println("kullanýcý güncellendi");
		}

		
}
