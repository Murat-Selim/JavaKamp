package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}
	

	@Override
	public DataResult<List<JobExperienceDto>> getAll() {
		return new SuccessDataResult<List<JobExperienceDto>>(dtoConverterService.dtoConverter(jobExperienceDao.findAll(),JobExperienceDto.class),"Is tecrubeleri basariyla listelendi");
	}

	@Override
	public DataResult<List<JobExperienceDto>> findAllByOrderByExitDateDesc() {
		return new SuccessDataResult<List<JobExperienceDto>>(dtoConverterService.dtoConverter(jobExperienceDao.findAllByOrderByExitDateDesc(), JobExperienceDto.class));
	}

    @Override
    public Result add(JobExperienceDto jobExperienceDto) {
		this.jobExperienceDao.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("Is tecrubesi Başarıyla eklendi.");
	}

    @Override
    public Result update(JobExperienceDto jobExperienceDto) {
		this.jobExperienceDao.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("İş tecrubesi başarıyla güncellendi.");
	}


	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("İş tecrubesi başarıyla silindi");
	}

}
