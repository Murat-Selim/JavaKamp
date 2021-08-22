package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","technologies","educations","jobExperiences","languages"})
public class Cv {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;		
	
	@Column(name="description")
	private String description;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="image")
	private String image;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="updated_date")
	private LocalDate updatedDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
	@OneToMany(mappedBy="cv", cascade = CascadeType.ALL)
	private List<Language> languages;
	
	@OneToMany(mappedBy="cv", cascade = CascadeType.ALL)
	private List<Technology> technologies;
	
	@OneToMany(mappedBy="cv", cascade = CascadeType.ALL)
	private List<Education> educations;
	
	@OneToMany(mappedBy="cv", cascade = CascadeType.ALL)
	private List<JobExperience> jobExperiences;	
}
