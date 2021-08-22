package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<Page<Employer>> getAll(int pageNo, int pageSize);
	Result add(Employer employer);
	Result update(Employer employer);
    Result updateConfirm(int userId);
	Result updateChangeActive(int userId);
	Result updateChangeFalse(int userId);
	DataResult<List<Employer>> getAllByIsActive(int pageNo, int pageSize);
	DataResult<List<Employer>> getAllByNotActive(int pageNo, int pageSize);
	DataResult<Employer> getById(int id);
	DataResult<List<Employer>> getByUpdatedDataNotNull();

	
}
