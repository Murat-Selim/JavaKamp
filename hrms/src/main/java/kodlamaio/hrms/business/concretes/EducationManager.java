package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;
		
	@Autowired
	public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}


	@Override
	public DataResult<List<EducationDto>> getAll() {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(), EducationDto.class), "Okullar Listelendi");
		
	}

	@Override
	public DataResult<List<EducationDto>> findAllByOrderByEndDateDesc() {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAllByOrderByEndDateDesc(), EducationDto.class));
	}
	
	@Override
	public Result add(EducationDto educationDto) {
		
		this.educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Eğitim Başarıyla eklendi.");
	}


	@Override
	public Result update(EducationDto educationDto) {
		
		this.educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Eğitim Başarıyla Güncellendi");
	}

	@Override
	public Result delete(int id) {

		this.educationDao.deleteById(id);
		return new SuccessResult("Eğitim Başarıyla Silindi");
	}
}

