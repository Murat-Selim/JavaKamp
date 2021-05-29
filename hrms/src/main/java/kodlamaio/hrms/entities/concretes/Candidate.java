package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{
	 
	 @Column(name="first_name")
     private String first_name;
	 
	 @Column(name="last_name")
     private String last_name;
	 
	 @Column(name="identity_number")
     private String identity_number;
	 
	 @Column(name="date_of_birth")
     private Date date_of_birth;
	 
}
