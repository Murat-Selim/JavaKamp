package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import kodlamaio.hrms.entities.dtos.JobAdvertFilterDto;

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
		return new SuccessResult("İş ilanları başarıyla eklendi");
	}
	
	@Override
	public DataResult<List<JobAdvertDto>> getAllByIsActive(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getAllByIsActive(pageable));
	}
	
	@Override
	public DataResult<Page<JobAdvertDto>> getAllByNotActive(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<JobAdvertDto>>(this.jobAdvertDao.getAllByNotActive(pageable));
	}

	@Override
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getByIsActiveAndCreatedDate());
	}

	@Override
	public DataResult<Page<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<JobAdvertDto>>(this.jobAdvertDao.getByIsActiveAndCompanyName(companyName, pageable));
	}

	@Override
	public DataResult<Page<JobAdvertDto>> getByIsActiveAndEmployerId(int employerId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<JobAdvertDto>>(this.jobAdvertDao.getByIsActiveAndEmployerId(employerId, pageable));
	}
	
	@Override
	public Result updateChangeActive(int userId) {
		
        jobAdvertDao.updateChangeActive(userId);
		return new SuccessResult("Is ilani onay durumu onaylandi");
	}
	
	@Override
	public Result updateChangeFalse(int userId) {
		
        jobAdvertDao.updateChangeFalse(userId);
		return new SuccessResult("Is ilani onay durumu onaylanmadi");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
			return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id),"Data listelendi");
	}
	
	@Override
	public DataResult<Page<JobAdvert>> getByFilter(int pageNo, int pageSize, JobAdvertFilterDto jobAdvertFilterDto) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<JobAdvert>>(this.jobAdvertDao.getByFilter(jobAdvertFilterDto, pageable),"Data getirildi");
		
	}

}
