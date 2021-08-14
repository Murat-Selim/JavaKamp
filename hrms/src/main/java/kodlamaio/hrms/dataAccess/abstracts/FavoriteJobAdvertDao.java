package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

public interface FavoriteJobAdvertDao extends JpaRepository<FavoriteJobAdvert, Integer>{

	List<FavoriteJobAdvert> getAllByCandidate_Id(int candidateId);
	boolean existsByCandidate_IdAndJobAdvert_Id(int candidateId, int jobAdvertId);
	
	@Modifying
	@Query("Delete From FavoriteJobAdvert where candidate.id=:userId And jobAdvert.id=:jobAdvertId")
	void deleteByCandidate_IdAndJobAdvert_Id(@Param("userId") int userId, @Param("jobAdvertId") int jobAdvertId);
}
