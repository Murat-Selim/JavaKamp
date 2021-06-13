package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.core.utilities.helpers.GeneratedRandomCode;
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
		code_.setCode(null);
		code_.setConfirm(false);
		if(code_.isConfirm() == false) {
			GeneratedRandomCode generator = new GeneratedRandomCode();
			String code_create = generator.toString();
			code_.setCode(code_create);
			code_.setUserId(id);
	
			emailActivationDao.save(code_);
			
		}
		
		return;
	}

	@Override
	public Result verify(String Code, Integer id) {
		
		EmailActivation active = emailActivationDao.findByUserId(id).get();
		if(active.getCode().equals(Code)) {
			active.setConfirm(true);
			return new SuccessDataResult<EmailActivation>(this.emailActivationDao.save(active),"Başarılı");
		}
		
		else if(active.isConfirm() == true) {
			return  new ErrorDataResult<EmailActivation>(null,"Zaten Doğrulanmış Hesap");
		}
		
		return  new ErrorDataResult<EmailActivation>(null,"Doğrulama Kodu Geçersiz");
	}

}
