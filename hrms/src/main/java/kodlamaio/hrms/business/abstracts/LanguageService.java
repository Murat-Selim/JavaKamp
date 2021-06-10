package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.LanguageDto;

public interface LanguageService {

	Result add(LanguageDto languageDto);
	DataResult<List<LanguageDto>> getAll();
}
