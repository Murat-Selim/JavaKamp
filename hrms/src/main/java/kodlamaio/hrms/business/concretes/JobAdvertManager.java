package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	@Override
	public DataResult<List<JobAdvertDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertDto>>(dtoConverterService.dtoConverter(jobAdvertDao.findAll(), JobAdvertDto.class));
	}

	@Override
	public Result add(JobAdvertAddDto jobAdvertAddDto) {
		this.jobAdvertDao.save((JobAdvert) dtoConverterService.dtoClassConverter(jobAdvertAddDto, JobAdvert.class));
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

	@Override
	public Result setActive(int id, boolean active) {
		JobAdvert value = this.jobAdvertDao.getOne(id);
		value.setActive(active);
		this.jobAdvertDao.save(value);
		return new SuccessResult("Is ilani pasif edildi");
	}

}
