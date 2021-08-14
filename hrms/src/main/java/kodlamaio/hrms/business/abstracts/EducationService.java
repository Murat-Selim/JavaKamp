package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EducationDto;

public interface EducationService {

	Result add(EducationDto educationDto);
	Result update(EducationDto educationDto);
	Result delete(int id);
	DataResult<List<EducationDto>> getAll();
	DataResult<List<EducationDto>> findAllByOrderByEndDateDesc();
}
