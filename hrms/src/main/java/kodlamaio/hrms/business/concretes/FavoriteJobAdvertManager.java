package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobAdvertDao;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

@Service
public class FavoriteJobAdvertManager implements FavoriteJobAdvertService{
	
	private FavoriteJobAdvertDao favoriteJobAdvertDao;

	@Autowired
	public FavoriteJobAdvertManager(FavoriteJobAdvertDao favoriteJobAdvertDao) {
		super();
		this.favoriteJobAdvertDao = favoriteJobAdvertDao;
	}

	
	@Override
	public DataResult<List<FavoriteJobAdvert>> getAll() {
		return new SuccessDataResult<List<FavoriteJobAdvert>>(favoriteJobAdvertDao.findAll(),"Favoriler listesi");
	}
	
	@Override
	public DataResult<FavoriteJobAdvert> getById(int id) {
		
		return new SuccessDataResult<FavoriteJobAdvert>(favoriteJobAdvertDao.findById(id).get());
	}

	
	@Override
	public DataResult<List<FavoriteJobAdvert>> getByCandidateId(int candidateId) {
	
		return new SuccessDataResult<List<FavoriteJobAdvert>>(favoriteJobAdvertDao.findAllByCandidate_Id(candidateId), "İş arayana göre favori iş ilanları getirme işlemi başarılı!");
	}

	@Override
	public DataResult<Integer> add(FavoriteJobAdvert FavoriteJobAdvert) {
		
		FavoriteJobAdvert favoriteJobAdvert = favoriteJobAdvertDao.saveAndFlush(FavoriteJobAdvert);
		return new SuccessDataResult<Integer>(favoriteJobAdvert.getId(),"Favorilere Ekleme işlemi başarılı!");
	}

	@Override
	public Result delete(int favoriteJobAdvertId) {
		if (!favoriteJobAdvertDao.existsById(favoriteJobAdvertId)) {
			return new ErrorResult("Favori iş ilanı bulunamadı.");
		}
		
		favoriteJobAdvertDao.deleteById(favoriteJobAdvertId);
		return new SuccessResult("Favorilerden kaldırma işlemi başarılı!");
	}

}
