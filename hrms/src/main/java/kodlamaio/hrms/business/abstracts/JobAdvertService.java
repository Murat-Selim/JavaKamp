package kodlamaio.hrms.business.abstracts;


import java.util.List;

import org.springframework.data.domain.Page;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import kodlamaio.hrms.entities.dtos.JobAdvertFilterDto;

public interface JobAdvertService {
	
	DataResult<List<JobAdvertDto>> getAll();
	Result add(JobAdvertAddDto jobAdvertAddDto);
	DataResult<JobAdvert> getById(int id);
	DataResult<List<JobAdvertDto>> getAllByIsActive(int pageNo, int pageSize);
	DataResult<Page<JobAdvertDto>> getAllByNotActive(int pageNo, int pageSize);
	DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate();
	DataResult<Page<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName, int pageNo, int pageSize);
	DataResult<Page<JobAdvertDto>> getByIsActiveAndEmployerId(int employerId, int pageNo, int pageSize);
	DataResult<Page<JobAdvert>> getByFilter(int pageNo, int pageSize, JobAdvertFilterDto jobAdvertFilterDto);
	Result updateChangeActive(int userId);
	Result updateChangeFalse(int userId);

}
