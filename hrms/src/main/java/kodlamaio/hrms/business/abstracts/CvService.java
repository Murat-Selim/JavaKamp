package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.CvSetDto;

public interface CvService {

    Result add(CvSetDto cvSetDto);
    Result update(CvSetDto cvSetDto);	
    Result saveImage(MultipartFile file, int cvId);
    Result updateImage(MultipartFile file, int cvId);
	DataResult<List<CvDto>> getAll();
	DataResult<Cv> getById(int id);
	DataResult<List<CvDto>> findAllByCandidateId(int id);
}
