package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private int candidateId;
	private String candidateFirstName;
	private String candidateLastName;
	private String githubLink;
	private String linkedinLink;
	private String image;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private List<JobExperience> jobExperiences;
	private List<Language> languages;
	private List<Technology> technologies;
	private List<Education> educations;
}
