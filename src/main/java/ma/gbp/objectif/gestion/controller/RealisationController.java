package ma.gbp.objectif.gestion.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.gbp.objectif.gestion.model.objectif.Realisation;
import ma.gbp.objectif.gestion.repository.RealisationRepository;

@RestController
@RequestMapping("/realisation")
public class RealisationController {

	@Autowired
	RealisationRepository realisationRepository;
	
	@GetMapping("all")
	public Set<Realisation> getAllRealisation() {
		//System.out.println("the message : " + marcheRepository.findAll().toString());
		return realisationRepository.findAll();
	}
	
	@GetMapping("{idMarche}")
	public Optional<Realisation> getRealisationById(@PathVariable(value = "idMarche") Long idMarche) {
		return realisationRepository.findById(idMarche);
	}
	
	@PostMapping("/")
	public Realisation createMarche(@RequestBody Realisation nouvelleRealisation) {
	    return realisationRepository.save(nouvelleRealisation);
	}
}
