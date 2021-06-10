package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvAddDto;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	private DtoConverterService dtoConverterService;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CvManager(CvDao cvDao, DtoConverterService dtoConverterService, CloudinaryService cloudinaryService) {
		super();
		this.cvDao = cvDao;
		this.dtoConverterService = dtoConverterService;
		this.cloudinaryService = cloudinaryService;
		
	}
	
	
	@Override
	public Result add(CvAddDto cvAddDto) {
		
		this.cvDao.save((Cv) dtoConverterService.dtoClassConverter(cvAddDto, Cv.class));
		return new SuccessResult("Cv Başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<CvDto>> getAll(){
		return new SuccessDataResult<List<CvDto>>(dtoConverterService.dtoConverter(cvDao.findAll(), CvDto.class), "'Cv'ler başarıyla listelendi.");
	}


	@Override
	public Result saveImage(MultipartFile file, int cvId) {
		@SuppressWarnings("unchecked")
		Map<String, String> upload = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = upload.get("url");
		Cv cv = cvDao.getOne(cvId);
		cv.setImage(imageUrl);
		cvDao.save(cv);
		return new SuccessResult("Kayıt Başarılı");

	}


	@Override
	public DataResult<List<CvDto>> findAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvDto>>(dtoConverterService.dtoConverter(cvDao.findAllByCandidateId(id), CvDto.class), "Is arayana gore listelendi.");
	}

}
