package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@RestController
@RequestMapping("/api/jobExperiences")
@CrossOrigin
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
	public ResponseEntity<?> add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return ResponseEntity.ok(this.jobExperienceService.add(jobExperienceDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return ResponseEntity.ok(this.jobExperienceService.update(jobExperienceDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.jobExperienceService.delete(id));
	}
	
	@GetMapping("findAllByOrderByEndDateDesc")
	public DataResult<List<JobExperienceDto>> findAllByOrderByExitDateDesc(){
		return this.jobExperienceService.findAllByOrderByExitDateDesc();
	}
	
	

}
