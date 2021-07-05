package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.transaction.Transactional;
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

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobAdverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService =jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertDto>> getAll() {
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertAddDto jobAdvertAddDto) {
		return ResponseEntity.ok(this.jobAdvertService.add(jobAdvertAddDto));
	}
	
	@GetMapping("/getAllByIsActive")
	public DataResult<List<JobAdvertDto>> getByIsActive() {
		return this.jobAdvertService.getAllByIsActive();
	}
	
	@GetMapping("/getAllByNotActive")
	public DataResult<List<JobAdvertDto>> getAllByNotActive() {
		return this.jobAdvertService.getAllByNotActive();
	}
	
	@GetMapping("/getByIsActiveAndCreatedDate")
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate() {
		return this.jobAdvertService.getByIsActiveAndCreatedDate();
	}
	
	@GetMapping("/getByIsActiveAndCompanyName")
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName) {
		return this.jobAdvertService.getByIsActiveAndCompanyName(companyName);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id) {
		return this.jobAdvertService.getById(id);
	}
	
	@Transactional
	@PutMapping("/updateChangeActive")
	public Result updateChangeActive(int userId) {
		return this.jobAdvertService.updateChangeActive(userId);
	}
	
	@Transactional
	@PutMapping("/updateChangeFalse")
	public Result updateChangeFalse(int userId) {
		return this.jobAdvertService.updateChangeFalse(userId);
	}
}
