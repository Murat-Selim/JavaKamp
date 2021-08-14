package kodlamaio.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.adapters.MernisValidation;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
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
	public DataResult<Page<Candidate>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);		
		return new SuccessDataResult<Page<Candidate>>(this.candidateDao.findAll(pageable), "Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		
		Result result = BusinessRules.run(firstNameChecker(candidate), lastNameChecker(candidate), 
				        birthDateChecker(candidate), emailChecker(candidate),
				        identityChecker(candidate), passwordChecker(candidate),
				        isRealEmail(candidate), isEmailExist(candidate),
				        isIdentityNumberExist(candidate), isRealPerson(candidate)
				        );
		
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		
		User user = this.userService.add(candidate);
		this.emailActivationService.generateCode(new EmailActivation(),user.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"İş Arayan Hesabı Eklendi , Doğrulama Kodu Gönderildi:" + candidate.getId());
				

  }
	
	private Result firstNameChecker(Candidate candidate) {
		if(candidate.getFirstName().isBlank() || candidate.getFirstName() == null) {
			return new ErrorResult(Messages.requiredFirstName);
		}
		return new SuccessResult();
	}
	
	private Result lastNameChecker(Candidate candidate) {
		if(candidate.getLastName().isBlank() || candidate.getLastName() == null) {
			return new ErrorResult(Messages.requiredLastName);
		}
		return new SuccessResult();
    }
	

	private Result birthDateChecker(Candidate candidate) {
		if(candidate.getDateOfBirth() == null) {
			return new ErrorResult(Messages.requiredBirthDate);
		}
		return new SuccessResult();
    }
	
	private Result emailChecker(Candidate candidate) {
		if(candidate.getEmail().isBlank() || candidate.getEmail() == null) {
			return new ErrorResult(Messages.requiredEmail);
		}
		return new SuccessResult();
    }
	
	private Result identityChecker(Candidate candidate) {
		if(candidate.getIdentityNumber().isBlank() || candidate.getIdentityNumber() == null) {
			return new ErrorResult(Messages.requiredIdentity);
		}
		return new SuccessResult();
    }
	
	private Result passwordChecker(Candidate candidate) {
		if(candidate.getPassword().isBlank() || candidate.getIdentityNumber() == null) {
			return new ErrorResult(Messages.requiredPassword);
		}
		return new SuccessResult();
    }
	
	private Result isRealEmail(Candidate candidate) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(candidate.getEmail());
	     if(!matcher.matches()) {
	    	 return new ErrorResult(Messages.notRealEmail);
	     }
	     return new SuccessResult();
	     
	}
	
	private Result isEmailExist(Candidate candidate) {

		if (candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0) {
			return new ErrorResult(Messages.alreadyRegisteredEmail);
		}
		return new SuccessResult();
	}

	private Result isIdentityNumberExist(Candidate candidate) {
		if (candidateDao.findAllByIdentityNumber(candidate.getIdentityNumber()).stream().count() != 0) {
			return new ErrorResult(Messages.alreadyRegisteredIdentity);
		}
		return new SuccessResult();
	}

	private Result isRealPerson(Candidate candidate) {
		if (!MernisValidation.isRealPerson(candidate.getIdentityNumber())) {

			return new ErrorResult(Messages.notRealPerson);
		}
		return new SuccessResult();

	}
	
}
	

