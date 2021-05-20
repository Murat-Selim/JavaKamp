package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer extends User{
	
	 @Id
	 @GeneratedValue
	 @Column(name="user_id")
     private int user_id;
	 
	 @Column(name="company_name")
     private String company_name;
	 
	 @Column(name="web_address")
     private String web_address;
	 
	 @Column(name="phone_number")
     private String phone_number;
	 
	 @Column(name="is_activated")
     private boolean is_activated;
     
     public Employer() {
    	 
     }

	public Employer(int user_id, String company_name, String web_address, String phone_number, boolean is_activated) {
		super();
		this.user_id = user_id;
		this.company_name = company_name;
		this.web_address = web_address;
		this.phone_number = phone_number;
		this.is_activated = is_activated;
	}
     
}
