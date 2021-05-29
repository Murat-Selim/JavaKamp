package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.MernisValidation;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService{

	@Autowired
	private CandidateDao candidateDao;
	private UserService userService;
	private EmailActivationService emailActivationService;
	
	public CandidateManager(CandidateDao candidateDao, UserService userService, EmailActivationService emailActivationService) {
		this.candidateDao = candidateDao;
		this.emailActivationService = emailActivationService;
		this.userService = userService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi");
	
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		
		if(!firstNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Ad Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(!lastNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Soyad Bilgisi Doldurulmak Zorundadir");
		}
		
		else if(!birthDateChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Dogum Bilgisi Doldurulmak Zorundadir");
		}
		
		else if(!emailChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email Bilgisi Doldurulmak Zorundadir");
		}
		
		else if(!identityChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Kimlik Bilgisi Doldurulmak Zorundadir");
		}
		
		
		else if(!MernisValidation.isRealPerson(candidate.getIdentity_number())) {
			return new ErrorDataResult<Candidate>(null,"Kimlik Doğrulanamadı");
		}
		
		else if(!passwordChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Sifre Bilgisi Doldurulmak Zorundadir");
		}
		
		else if(!isRealEmail(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email dogrulanamadi");
		}
		
		else if(candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0) {
			return new ErrorDataResult<Candidate>(null,"Email Zaten Kayitli");
		}
		
		else if(candidateDao.findAllByIdentityNumber(candidate.getIdentity_number()).stream().count() != 0) {
			return new ErrorDataResult<Candidate>(null,"Kimlik No zaten kayitli");
		}
		
		User savedUser = this.userService.add(candidate);
		this.emailActivationService.generateCode(new EmailActivation(),savedUser.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"İş Arayan Hesabı Eklendi , Doğrulama Kodu Gönderildi:" + candidate.getId());
				

  }
	
	private boolean firstNameChecker(Candidate candidate) {
		if(candidate.getFirst_name().isBlank() || candidate.getFirst_name() == null) {
			return false;
		}
		return true;
	}
	
	private boolean lastNameChecker(Candidate candidate) {
		if(candidate.getLast_name().isBlank() || candidate.getLast_name() == null) {
		  return false;
		}
		  return true;
    }
	

	private boolean birthDateChecker(Candidate candidate) {
		if(candidate.getDate_of_birth() == null) {
		  return false;
		}
		  return true;
    }
	
	private boolean emailChecker(Candidate candidate) {
		if(candidate.getEmail().isBlank() || candidate.getEmail() == null) {
		  return false;
		}
		  return true;
    }
	
	private boolean identityChecker(Candidate candidate) {
		if(candidate.getIdentity_number().isBlank() || candidate.getIdentity_number() == null) {
		  return false;
		}
		  return true;
    }
	
	private boolean passwordChecker(Candidate candidate) {
		if(candidate.getPassword().isBlank() || candidate.getIdentity_number() == null) {
		  return false;
		}
		  return true;
    }
	
	private boolean isRealEmail(Candidate candidate) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(candidate.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     return true;
	     
	}
	
	
}
	

