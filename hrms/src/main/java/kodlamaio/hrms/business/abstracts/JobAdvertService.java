package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	DataResult<List<JobAdvertDto>> getAll();
	Result add(JobAdvertAddDto jobAdvertAddDto);
	DataResult<List<JobAdvertDto>> getByIsActive();
	DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate();
	DataResult<List<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName);
	Result setActive(int id,boolean active);

	
	
}
