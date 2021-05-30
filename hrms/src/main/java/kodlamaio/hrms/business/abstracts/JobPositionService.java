package kodlamaio.hrms.business.abstracts;


import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> add(JobPosition jobPosition);
	Optional<JobPosition> findById(Integer id);
	List<JobPosition> findByJobTitle(String title);

}
