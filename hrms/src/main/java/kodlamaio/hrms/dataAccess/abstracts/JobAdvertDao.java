package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, j.jobposition.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition) From Employer e Inner Join e.jobAdverts j Where j.isActive=true")
	List<JobAdvertDto> getIsActive();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, j.jobposition.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition) From Employer e Inner Join e.jobAdverts j Where j.isActive=true Order By j.createdDate")
	List<JobAdvertDto> getByIsActiveAndCreatedDate();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, j.jobposition.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition) From Employer e Inner Join e.jobAdverts j Where j.isActive=true And e.companyName=:companyName")
	List<JobAdvertDto> getByIsActiveAndCompanyName(String companyName);
}
