package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	DataResult<List<FavoriteJobAdvert>> getAll(){
		return this.favoriteJobAdvertService.getAll();
	}
	
	
	@GetMapping("/getByCandidateId")
	DataResult<List<FavoriteJobAdvert>> getByCandidateId(int candidateId){
		return favoriteJobAdvertService.getByCandidateId(candidateId);
	}
	
	@GetMapping("getById")
	public DataResult<FavoriteJobAdvert> getById(@RequestParam int id){
		return favoriteJobAdvertService.getById(id);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody FavoriteJobAdvert favoriteJobAdvert){
		return ResponseEntity.ok(this.favoriteJobAdvertService.add(favoriteJobAdvert));
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(@RequestParam int jobAdvertId){
		return ResponseEntity.ok(this.favoriteJobAdvertService.delete(jobAdvertId));
	}
	
	
}
