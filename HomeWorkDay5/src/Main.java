import java.util.Scanner;

import Entity.concretes.User;
import Entity.concretes.UserDto;
import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.GoogleAdapters;
import dataAccess.concretes.HibernateUserDao;

public class Main {
	public static void main(String[] args) {
		
		User user = new User();
		user.setId(1);
		user.setFirstName("Murat");
		user.setLastName("Selim");
		user.setEmail("murat94@gmail.com");
		user.setPassword("123456");
		
		User user1 = new User();
		user1.setId(2);
		user1.setFirstName("Ali");
		user1.setLastName("Yilmaz");
		user1.setEmail("ali15@gmail.com");
		user1.setPassword("321321");
		

		UserManager userManager = new UserManager(new HibernateUserDao(), new GoogleAdapters());
		
		userManager.add(user);
		
		AuthManager authManager = new AuthManager(new UserManager(new HibernateUserDao(), new GoogleAdapters()));
		
		userManager.getAll();
		
		UserDto userDto = new UserDto();
		userDto.setEmail("ali15@gmail.com");
		userDto.setPassword("321321");
		
		authManager.login(userDto);
		
		
		
	
	}
	
}
