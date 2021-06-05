package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	DataResult<List<JobAdvert>> getAll();
	Result add(JobAdvert jobAdvert);
	DataResult<List<JobAdvertDto>> getByIsActive();
	DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate();
	DataResult<List<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName);
	
}
