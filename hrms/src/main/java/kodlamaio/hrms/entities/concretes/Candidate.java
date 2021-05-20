package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="candidates")
public class Candidate extends User{
	 
	 @Id
	 @GeneratedValue
	 @Column(name="user_id")
     private int user_id;
	 
	 @Column(name="first_name")
     private String first_name;
	 
	 @Column(name="last_name")
     private String last_name;
	 
	 @Column(name="identity_number")
     private String identity_number;
	 
	 @Column(name="date_of_birth")
     private Date date_of_birth;
	 
	 public Candidate() {
		 
	 }

	public Candidate(int user_id, String first_name, String last_name, String identity_number, Date date_of_birth) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.identity_number = identity_number;
		this.date_of_birth = date_of_birth;
	}
}
