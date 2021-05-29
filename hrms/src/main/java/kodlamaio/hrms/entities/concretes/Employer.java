package kodlamaio.hrms.entities.concretes;

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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{
	
	 @Column(name="company_name")
     private String company_name;
	 
	 @Column(name="web_address")
     private String web_address;
	 
	 @Column(name="phone_number")
     private String phone_number;
	
}
