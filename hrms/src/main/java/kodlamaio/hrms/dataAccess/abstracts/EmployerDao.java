package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	List<Employer> findAllByEmail(String email);
	
	@Query("From Employer where isActivated=true")
	List<Employer> getAllByIsActive(Pageable pageable);
	
	@Query("From Employer where isActivated=false")
	List<Employer> getAllByNotActive(Pageable pageable);
	
	@Modifying
	@Query("update Employer set isActivated=true where id=:userId")
	int updateChangeActive(@Param("userId") int userId);
	
	@Modifying
	@Query("update Employer set isActivated=false where id=:userId")
	int updateChangeFalse(@Param("userId") int userId);

    List<Employer> getByUpdatedDataNotNull();

}
