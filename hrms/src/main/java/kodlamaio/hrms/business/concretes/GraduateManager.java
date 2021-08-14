package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrms.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService{
	
	private GraduateDao graduateDao;
	
	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(), "Mezunlar listelendi.");
	}

	@Override
	public Result add(Graduate graduate) {
		if(graduateDao.existsByDescription(graduate.getDescription())) {
			return new ErrorResult("Bu eğitim derecesi zaten kayıtlı.");
		}
		this.graduateDao.save(graduate);
		return new SuccessResult("Eğitim derecesi başarıyla eklendi.");
	}

	@Override
	public Result update(Graduate graduate) {
		this.graduateDao.save(graduate);
		return new SuccessResult("Eğitim derecesi başarıyla güncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.graduateDao.deleteById(id);
		return new SuccessResult("Eğitim derecesi başarıyla silindi.");
	}
	
	

}
