package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvDao extends JpaRepository<Cv, Integer>{
	
	List<CvDto> findAllByCandidateId(int id);
	
}
