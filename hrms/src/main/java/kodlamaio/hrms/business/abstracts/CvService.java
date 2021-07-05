package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CvAddDto;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvService {

    Result add(CvAddDto cvAddDto);
    Result update(CvDto cvDto);
	DataResult<List<CvDto>> getAll();
	DataResult<List<CvDto>> findAllByCandidateId(int id);
	Result saveImage(MultipartFile file, int cvId);
}
