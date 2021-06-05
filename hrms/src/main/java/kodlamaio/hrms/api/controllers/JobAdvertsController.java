package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService =jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertDto>> getByIsActive() {
		return this.jobAdvertService.getByIsActive();
	}
	
	@GetMapping("/getByIsActiveAndCreatedDate")
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCreatedDate() {
		return this.jobAdvertService.getByIsActiveAndCreatedDate();
	}
	
	@GetMapping("/getByIsActiveAndCompanyName")
	public DataResult<List<JobAdvertDto>> getByIsActiveAndCompanyName(String companyName) {
		return this.jobAdvertService.getByIsActiveAndCompanyName(companyName);
	}
}
