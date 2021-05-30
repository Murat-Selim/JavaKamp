package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserService userService;
	private EmailActivationService emailActivationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService, EmailActivationService emailActivationService) {
		this.employerDao = employerDao;
		this.emailActivationService = emailActivationService;
		this.userService = userService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
	
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		
		if(!companyNameChecker(employer)) {
			new ErrorDataResult<Employer>(null, "Sirket bilgisi doldurulmak zorundadir");
		}
		
		else if(!webAddressChecker(employer)) {
			new ErrorDataResult<Employer>(null, "Web site bilgisi doldurulmak zorundadir");
		}
		
		else if(!emailChecker(employer)) {
			new ErrorDataResult<Employer>(null, "E-mail bilgisi doldurulmak zorundadir");
		}
		

		else if(!passwordChecker(employer)) {
			new ErrorDataResult<Employer>(null, "Sifre bilgisi doldurulmak zorundadir");
		}
		
		else if(!isRealEmail(employer)) {
			new ErrorDataResult<Employer>(null, "E-mail dogrulanamadi");
		}
		
		else if(!isRealPhoneNumber(employer)) {
			new ErrorDataResult<Employer>(null, "Geçersiz Telefon Numarası Lütfen Tekrar Deneyin");
		}
		
		else if(employerDao.findAllByEmail(employer.getEmail()).stream().count() !=0) {
			new ErrorDataResult<Employer>(null, "E-mail adresi zaten kayitli");
		}
		
		User savedUser = this.userService.add(employer);
		this.emailActivationService.generateCode(new EmailActivation(),savedUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş Veren Hesabı Eklendi , Doğrulama Kodu Gönderildi:" + employer.getId());
		
		
		
	}
	
	private boolean companyNameChecker(Employer employer) {
		
		if(employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return false;
		}
		return true;
	}
	
   private boolean webAddressChecker(Employer employer) {
		
		if(employer.getWebAddress().isBlank() || employer.getWebAddress() == null) {
			return false;
		}
		return true;
	}
   
   private boolean emailChecker(Employer employer) {
		
		if(employer.getEmail().isBlank() || employer.getEmail() == null) {
			return false;
		}
		return true;
	}
   
   private boolean passwordChecker(Employer employer) {
		
		if(employer.getPassword().isBlank() || employer.getPassword() == null) {
			return false;
		}
		return true;
	}
   
   private boolean isRealEmail(Employer employer) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employer.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     else if (!employer.getEmail().contains(employer.getWebAddress())) {
				return false;
			}
	     return true;
	     
	}
   
   private boolean isRealPhoneNumber(Employer employer) {
		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
   
}
