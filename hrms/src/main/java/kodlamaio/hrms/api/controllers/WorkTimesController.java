package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkTime;

@RestController
@RequestMapping("/api/worktimes")
@CrossOrigin
public class WorkTimesController {

	private WorkTimeService workTimeService;

	public WorkTimesController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkTime>> getAll(){
		return this.workTimeService.getAll();
	}
}
