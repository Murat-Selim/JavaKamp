package InterfaceAbstractDemo;

import java.util.Date;

public class Customer implements Entity{
   private int id;
   private String firstName;
   private String lastName;
   private String nationalIdentity;
   private Date dateOfBirth;

   public Customer() {
		
   }
   
   public Customer(int id, String firstName, String lastName, String nationalIdentity, Date dateOfBirth) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.nationalIdentity = nationalIdentity;
	this.dateOfBirth = dateOfBirth;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getNationalIdentity() {
	return nationalIdentity;
}

public void setNationalIdentity(String nationalIdentity) {
	this.nationalIdentity = nationalIdentity;
}

public Date getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
   
}
