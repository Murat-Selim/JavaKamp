package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import kodlamaio.hrms.entities.dtos.JobAdvertFilterDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	JobAdvert findById(int id);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition, c.name, w.name) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Inner Join j.city c Inner Join j.workTime w Where j.isActive=true Order By j.createdDate Desc")
	List<JobAdvertDto> getAllByIsActive(Pageable pageable);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition, c.name, w.name) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Inner Join j.city c Inner Join j.workTime w Where j.isActive=false Order By j.createdDate Desc")
	Page<JobAdvertDto> getAllByNotActive(Pageable pageable);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition, c.name, w.name) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Inner Join j.city c Inner Join j.workTime w Where j.isActive=true Order By j.createdDate Desc")
	List<JobAdvertDto> getByIsActiveAndCreatedDate();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition, c.name, w.name) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Inner Join j.city c Inner Join j.workTime w Where j.isActive=true And e.companyName=:companyName Order By j.createdDate Desc")
	Page<JobAdvertDto> getByIsActiveAndCompanyName(String companyName, Pageable pageable);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto (j.id, e.companyName, jo.jobTitle, j.applicationDeadline, j.createdDate, j.numberOfOpenPosition, c.name, w.name) From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jo Inner Join j.city c Inner Join j.workTime w Where j.isActive=true And e.id=:employerId Order By j.createdDate Desc")
	Page<JobAdvertDto> getByIsActiveAndEmployerId(int employerId, Pageable pageable);

	@Modifying
	@Query("update JobAdvert set isActive=true where id=:userId")
	int updateChangeActive(@Param("userId") int userId);
	
	@Modifying
	@Query("update JobAdvert set isActive=false where id=:userId")
	int updateChangeFalse(@Param("userId") int userId);
	
	@Query("Select j from kodlamaio.hrms.entities.concretes.JobAdvert j where"
            +" ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
            +" and ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
            +" and ((:#{#filter.workPlaceId}) IS NULL OR j.workPlace.id IN (:#{#filter.workPlaceId}))"
            +" and ((:#{#filter.workTimeId}) IS NULL OR j.workTime.id IN (:#{#filter.workTimeId}))"
            +" and j.isActive=true ORDER BY j.createdDate Desc")
    Page<JobAdvert> getByFilter(@Param("filter") JobAdvertFilterDto jobAdvertFilterDto, Pageable pageable);
	
}
