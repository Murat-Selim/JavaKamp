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

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.EducationDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<EducationDto>> getAll(){
		return educationService.getAll();
	}
	
	@GetMapping("findAllByOrderByEndDateDesc")
	public DataResult<List<EducationDto>> findAllByOrderByEndDateDesc(){
		return this.educationService.findAllByOrderByEndDateDesc();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EducationDto educationDto) {
		return ResponseEntity.ok(this.educationService.add(educationDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody EducationDto educationDto) {
		return ResponseEntity.ok(this.educationService.update(educationDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.educationService.delete(id));
	}
	
	
	
	
}
