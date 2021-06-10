package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperienceDto>> getAll(){
		return jobExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.add(jobExperienceDto);
		
	}
	
	@GetMapping("findAllByOrderByEndDateDesc")
	public DataResult<List<JobExperienceDto>> findAllByOrderByExitDateDesc(){
		return this.jobExperienceService.findAllByOrderByExitDateDesc();
	}
	
	

}
