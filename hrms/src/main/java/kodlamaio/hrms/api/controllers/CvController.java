package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.CvSetDto;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin
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
	public ResponseEntity<?> add(@Valid @RequestBody CvSetDto cvSetDto) {
		return ResponseEntity.ok(this.cvService.add(cvSetDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody CvSetDto cvSetDto) {
		return ResponseEntity.ok(this.cvService.update(cvSetDto));
	}
	
	@GetMapping("/findByCandidateId")
	public DataResult<List<CvDto>> findAllByCandidateId(@RequestParam int id) {
		return this.cvService.findAllByCandidateId(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Cv> getById(int id) {
		return this.cvService.getById(id);
	}
	
	@PostMapping("/addImage")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int cvId) {
		return this.cvService.saveImage(file, cvId);
	}
	
	@PutMapping("/updateImage")
	public Result updateImage(@RequestBody MultipartFile file, @RequestParam int cvId) {
		return this.cvService.updateImage(file, cvId);
	}
	
}