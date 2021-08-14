package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import kodlamaio.hrms.entities.dtos.JobAdvertFilterDto;

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
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertDto>> getAll() {
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertAddDto jobAdvertAddDto) {
		return ResponseEntity.ok(this.jobAdvertService.add(jobAdvertAddDto));
	}
	
	@GetMapping("/getAllByIsActive")
	public DataResult<List<JobAdvertDto>> getAllByIsActive(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.jobAdvertService.getAllByIsActive(pageNo, pageSize);
	}
	
	@GetMapping("/getAllByNotActive")
	public DataResult<Page<JobAdvertDto>> getAllByNotActive(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.jobAdvertService.getAllByNotActive(pageNo, pageSize);
	}
	
	@GetMapping("/getByIsActiveAndCreatedDate")
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate() {
		return this.jobAdvertService.getByIsActiveAndCreatedDate();
	}
	
	@GetMapping("/getByIsActiveAndCompanyName")
	public DataResult<Page<JobAdvertDto>> getByIsActiveAndCompanyName(@RequestParam String companyName, @RequestParam int pageNo, @RequestParam int pageSize) {
		return this.jobAdvertService.getByIsActiveAndCompanyName(companyName, pageNo, pageSize);
	}
	
	@GetMapping("/getByIsActiveAndEmployerId")
	public DataResult<Page<JobAdvertDto>> getByIsActiveAndEmployerId(@RequestParam int employerId, @RequestParam int pageNo, @RequestParam int pageSize) {
		return this.jobAdvertService.getByIsActiveAndEmployerId(employerId, pageNo, pageSize);
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(@RequestParam int id) {
		return this.jobAdvertService.getById(id);
	}
	
	@PostMapping("/getByJobAdvertFilter")
	public DataResult<Page<JobAdvert>> getByFilter(@RequestParam int pageNo, @RequestParam int pageSize, @RequestBody JobAdvertFilterDto jobAdvertFilterDto) {
		return this.jobAdvertService.getByFilter(pageNo, pageSize, jobAdvertFilterDto);
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
