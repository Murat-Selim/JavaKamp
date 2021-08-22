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

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@Column(name="number_of_open_position")
    private int numberOfOpenPosition;

	
    @Column(name = "created_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate createdDate;
	
	@Column(name = "application_deadline")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate applicationDeadline;

	@Column(name = "min_salary")
	private Double minSalary;

	@Column(name = "max_salary")
	private Double maxSalary;

	@Column(name = "is_active")
	private boolean isActive;
    
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "jobPosition_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "workTime_id")
	private WorkTime workTime;
	
	@ManyToOne()
	@JoinColumn(name = "workPlace_id")
	private WorkPlace workPlace;

}
