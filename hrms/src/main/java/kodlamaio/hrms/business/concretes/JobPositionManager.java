package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Data listelendi");
	
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(jobPositionDao.findByTitles(jobPosition.getJob_title()).stream().count() !=0 ) {
			return new ErrorDataResult<JobPosition>(null,"Böyle Bir İş Pozisyonu Zaten Kayıtlı");	
		}
		
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.save(jobPosition),"Başarıyla İş Pozisyonu Eklendi");
		
	}

	@Override
	public List<JobPosition> findByTitles(String job_title) {
		return this.jobPositionDao.findByTitles(job_title);
	}

	@Override
	public Optional<JobPosition> findById(Integer id) {
		return this.jobPositionDao.findById(id);
	}

}
