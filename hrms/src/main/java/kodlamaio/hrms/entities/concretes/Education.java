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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="educations")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@Column(name="school_name")
	private String schoolName;
	
	@NotBlank
	@Column(name="department")
	private String department;
	
	
	@Column(name="start_date")
	private LocalDate startDate; 
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	@ManyToOne()
	@JoinColumn(name="graduate_id")
	private Graduate graduate;
}

