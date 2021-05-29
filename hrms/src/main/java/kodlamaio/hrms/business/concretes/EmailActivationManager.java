package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.core.GeneratedRandomCode;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailActivationDao;
import kodlamaio.hrms.entities.concretes.EmailActivation;

@Service
public class EmailActivationManager implements EmailActivationService{

    private EmailActivationDao emailActivationDao;
	
    @Autowired
	public EmailActivationManager(EmailActivationDao emailActivationDao) {
		super();
		this.emailActivationDao = emailActivationDao;
	}
    
	@Override
	public void generateCode(EmailActivation code, Integer id) {
		
		EmailActivation code_ = code;
		code.setCode(null);
		code.setConfirm(false);
		if(code.isConfirm() == false) {
			GeneratedRandomCode generator = new GeneratedRandomCode();
			String code_create = generator.create();
			code.setCode(code_create);
			code.setUserId(id);
	
			emailActivationDao.save(code);
			
		}
		
		return;
	}

	@Override
	public Result verify(String Code, Integer id) {
		
		EmailActivation ref = emailActivationDao.findByUserId(id).get();
		if(ref.getCode().equals(Code)) {
			ref.setConfirm(true);
			return  new SuccessDataResult<EmailActivation>(this.emailActivationDao.save(ref),"Başarılı");
		}
		return  new ErrorDataResult<EmailActivation>(null,"Doğrulama Kodu Geçersiz");
	}

}
