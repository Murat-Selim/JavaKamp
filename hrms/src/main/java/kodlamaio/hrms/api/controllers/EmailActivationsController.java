package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.core.utilities.results.Result;


@RestController
@RequestMapping("/api/verify")
@CrossOrigin
public class EmailActivationsController {

	private EmailActivationService emailActivationService;

	@Autowired
	public EmailActivationsController(EmailActivationService emailActivationService) {
		super();
		this.emailActivationService = emailActivationService;
	}

	@PostMapping("/update/{ActivationCode}/{id}")
	public Result setVerify(@RequestParam String ActivationCode, @RequestParam Integer id) {
		return emailActivationService.verify(ActivationCode, id);
	}

}
