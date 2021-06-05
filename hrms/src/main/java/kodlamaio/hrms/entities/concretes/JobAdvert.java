package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adverts")
@Entity
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name="number_of_open_position")
    private int numberOfOpenPosition;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "min_salary")
	private Double minSalary;

	@Column(name = "max_salary")
	private Double maxSalary;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne
	@JoinColumn(name = "jobPosition_id")
	private JobPosition jobposition;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

}
