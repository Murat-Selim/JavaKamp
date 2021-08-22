package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class Candidate extends User{
	 
	 @Column(name="first_name")
     private String firstName;
	 
	 @Column(name="last_name")
     private String lastName;
	 
	 @Column(name="identity_number")
     private String identityNumber;
	 
	 @Column(name="date_of_birth")
     private LocalDate dateOfBirth;
	 
	 @OneToMany(mappedBy="candidate", cascade = CascadeType.ALL)
	 private List<Cv> cv;
}
