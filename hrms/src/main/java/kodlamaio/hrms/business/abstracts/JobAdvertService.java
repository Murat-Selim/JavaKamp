package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	DataResult<List<JobAdvertDto>> getAll();
	Result add(JobAdvertAddDto jobAdvertAddDto);
	DataResult<JobAdvert> getById(int id);
	DataResult<List<JobAdvertDto>> getAllByIsActive();
	DataResult<List<JobAdvertDto>> getAllByNotActive();
	DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate();
	DataResult<List<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName);
	Result updateChangeActive(int userId);
	Result updateChangeFalse(int userId);

}
