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
	public DataResult<List<JobAdvertDto>> getAllByIsActive() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getAllByIsActive());
	}
	
	@Override
	public DataResult<List<JobAdvertDto>> getAllByNotActive() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getAllByNotActive());
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
	public Result updateChangeActive(int userId) {
        jobAdvertDao.updateChangeActive(userId);
		return new SuccessResult("Kullanıcı onay durumu onaylandi");
	}
	
	@Override
	public Result updateChangeFalse(int userId) {
        jobAdvertDao.updateChangeFalse(userId);
		return new SuccessResult("Kullanıcı onaylanmadi");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
			return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id),"Data listelendi");
	}

}
