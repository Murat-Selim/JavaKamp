package kodlamaio.hrms.api.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

@RestController
@RequestMapping("/api/favoriteJobAdverts")
@CrossOrigin
public class FavoriteJobAdvertsController{
	
	private FavoriteJobAdvertService favoriteJobAdvertService;
	
	@Autowired
	public FavoriteJobAdvertsController(FavoriteJobAdvertService favoriteJobAdvertService) {
		super();
		this.favoriteJobAdvertService = favoriteJobAdvertService;
	}
	
	@GetMapping("/getAll")
	DataResult<Page<FavoriteJobAdvert>> getAll(@RequestParam int pageNo, @RequestParam int pageSize){
		return this.favoriteJobAdvertService.getAll(pageNo, pageSize);
	}
	
	
	@GetMapping("/getAllByCandidateId")
	DataResult<Page<FavoriteJobAdvert>> getAllByCandidateId(@RequestParam int candidateId, @RequestParam int pageNo, @RequestParam int pageSize){
		return favoriteJobAdvertService.getAllByCandidateId(candidateId, pageNo, pageSize);
	}
	
	@GetMapping("getById")
	public DataResult<FavoriteJobAdvert> getById(@RequestParam int id){
		return favoriteJobAdvertService.getById(id);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody FavoriteJobAdvert favoriteJobAdvert){
		return ResponseEntity.ok(this.favoriteJobAdvertService.add(favoriteJobAdvert));
	}
	
	@Transactional
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(@RequestParam int candidateId, @RequestParam int jobAdvertId){
		return ResponseEntity.ok(this.favoriteJobAdvertService.delete(candidateId, jobAdvertId));
	}
	
}
