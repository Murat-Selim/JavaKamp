package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

public interface FavoriteJobAdvertService {

	DataResult<List<FavoriteJobAdvert>> getAll();
	DataResult<List<FavoriteJobAdvert>> getByCandidateId(int candidateId);
	DataResult<FavoriteJobAdvert> getById(int id);
	
	DataResult<Integer> add(FavoriteJobAdvert favoriteJobAdvert);
	Result delete(int favoriteJobAdvertId);
}
