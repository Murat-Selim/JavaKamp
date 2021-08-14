package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

public interface FavoriteJobAdvertService {

	DataResult<Page<FavoriteJobAdvert>> getAll(int pageNo, int pageSize);
	DataResult<List<FavoriteJobAdvert>> getByCandidateId(int candidateId);
	DataResult<FavoriteJobAdvert> getById(int id);
	Result add(FavoriteJobAdvert favoriteJobAdvert);
	Result delete(int candidateId, int jobAdvertId);
}
