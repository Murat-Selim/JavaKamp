package kodlamaio.hrms.business.abstracts;

import org.springframework.data.domain.Page;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<Page<Candidate>> getAll(int pageNo, int pageSize);
	Result add(Candidate candidate);
}
