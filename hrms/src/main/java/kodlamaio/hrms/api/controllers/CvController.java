package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CvAddDto;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cv")
public class CvController {
	
	private CvService cvService;
	
	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvDto>> getAll() {
		return this.cvService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvAddDto cvAddDto) {
		return this.cvService.add(cvAddDto);
	}
	
	@GetMapping("/findAllByCandidateId")
	public DataResult<List<CvDto>> findAllByCandidateId(int id) {
		return this.cvService.findAllByCandidateId(id);
	}
	
	@PutMapping("/addImage")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int cvId) {
		return this.cvService.saveImage(file, cvId);
		
	}
	
}