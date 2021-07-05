package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	JobAdvert findById(int id);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Where j.isActive=true")
	List<JobAdvertDto> getAllByIsActive();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Where j.isActive=false")
	List<JobAdvertDto> getAllByNotActive();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Where j.isActive=true Order By j.createdDate Desc")
	List<JobAdvertDto> getByIsActiveAndCreatedDate();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Where j.isActive=true And e.companyName=:companyName")
	List<JobAdvertDto> getByIsActiveAndCompanyName(String companyName);
	
	@Modifying
	@Query("update JobAdvert set isActive=true where id=:userId")
	int updateChangeActive(@Param("userId") int userId);
	
	@Modifying
	@Query("update JobAdvert set isActive=false where id=:userId")
	int updateChangeFalse(@Param("userId") int userId);
	
}
