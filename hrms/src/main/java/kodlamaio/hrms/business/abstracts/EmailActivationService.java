package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailActivation;

public interface EmailActivationService {

	void generateCode(EmailActivation code, Integer id);
	Result verify(String Code, Integer id);
}
