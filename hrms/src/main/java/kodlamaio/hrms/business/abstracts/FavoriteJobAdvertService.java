package kodlamaio.hrms.business.abstracts;

import org.springframework.data.domain.Page;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

public interface FavoriteJobAdvertService {

	DataResult<Page<FavoriteJobAdvert>> getAll(int pageNo, int pageSize);
	DataResult<Page<FavoriteJobAdvert>> getAllByCandidateId(int candidateId, int pageNo, int pageSize);
	DataResult<FavoriteJobAdvert> getById(int id);
	Result add(FavoriteJobAdvert favoriteJobAdvert);
	Result delete(int candidateId, int jobAdvertId);
}
