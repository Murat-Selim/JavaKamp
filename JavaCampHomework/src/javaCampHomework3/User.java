package javaCampHomework3;

public class User {
		 private int id;
		 private String firstName;
		 private String lastName;
		 private String email;
		 private String password;
		 
		 public User() {
			 
		 }
		 
		 public User(int id,String firstName,String lastName,String email,String password) {
			 	super();
			    this.id=id;
				this.firstName=firstName;
				this.lastName=lastName;
				this.email=email;
				this.password=password;
		 }
		 
		 public int getId() {
			 return this.id;
		 }
		 public void setId(int id) {
			 this.id=id;
		 }
		 
		 public String getFirstName() {
			 return this.firstName;
		 }
		 public void setFirstName(String firstName) {
			 this.firstName=firstName;
		 }
		 
		 public String getLastName() {
			 return this.lastName;
		 }
		 public void setLastName(String lastName) {
			 this.lastName=lastName;
		 }
		 
		 public String getEmail() {
			 return this.email;
		 }
		 public void setEmail(String email) {
			 this.email=email;
		 }
		 
		 public String password() {
			 return this.password;
		 }
		 public void setPassword(String password) {
			 this.password=password;
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
	
}
