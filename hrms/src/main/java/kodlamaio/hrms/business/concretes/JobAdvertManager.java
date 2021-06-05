package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Is ilanlari basariyla eklendi");
	}
	
	@Override
	public DataResult<List<JobAdvertDto>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getIsActive());
	}

	@Override
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getByIsActiveAndCreatedDate());
	}

	@Override
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getByIsActiveAndCompanyName(companyName));
	}

	

	
}
