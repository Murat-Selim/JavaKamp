package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="exit_date")
	private LocalDate exitDate;
	
	@ManyToOne()
	@JoinColumn(name="jobPosition_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
	
}
