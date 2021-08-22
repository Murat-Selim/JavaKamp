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

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Graduate;

@RestController
@RequestMapping("/api/graduates")
@CrossOrigin
public class GraduatesController {
	
	
	private GraduateService graduateService;
	
	@Autowired
	public GraduatesController(GraduateService graduateService) {
		super();
		this.graduateService = graduateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Graduate>> getAll(){
		return this.graduateService.getAll();
		}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Graduate graduate){
		return ResponseEntity.ok(this.graduateService.add(graduate));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Graduate graduate){
		return ResponseEntity.ok(this.graduateService.update(graduate));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id){
		return ResponseEntity.ok(this.graduateService.delete(id));
	}

}
