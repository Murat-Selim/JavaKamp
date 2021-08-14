package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;

	@Autowired 
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<Page<Employer>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.employerService.getAll(pageNo, pageSize);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Employer employer) {
		return this.employerService.update(employer);
	}
	
	@Transactional
	@PutMapping("/updateChangeActive")
	public Result updateChangeActive(int userId) {
		return this.employerService.updateChangeActive(userId);
	}
	
	@Transactional
	@PutMapping("/updateChangeFalse")
	public Result updateChangeFalse(int userId) {
		return this.employerService.updateChangeFalse(userId);
	}
	
	@GetMapping("/getAllByIsActive")
	public DataResult<List<Employer>> getAllByIsActive(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.employerService.getAllByIsActive(pageNo, pageSize);
	}
	
	@GetMapping("/getAllByNotActive")
	public DataResult<List<Employer>> getAllByNotActive(@RequestParam int pageNo, @RequestParam int pageSize){
		return this.employerService.getAllByNotActive(pageNo, pageSize);
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(@RequestParam int id) {
		return this.employerService.getById(id);
	}
	
}