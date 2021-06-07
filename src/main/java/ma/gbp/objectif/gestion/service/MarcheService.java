package ma.gbp.objectif.gestion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.gbp.objectif.gestion.model.products.Marche;
import ma.gbp.objectif.gestion.model.products.Produit;
import ma.gbp.objectif.gestion.repository.MarcheRepository;

@Service
public class MarcheService {
	@Autowired
	private final MarcheRepository marcheRepository;

	
	public MarcheService(MarcheRepository marcheRepository) {
		this.marcheRepository = marcheRepository;
	}


	public List<Marche> findAllMarcheService(){
		//System.out.println("this is :" + marcheRepository.findAllMarche());
		return marcheRepository.findAllMarche();
	}
	
	public Marche findMarcheParId(Long id) {
		return marcheRepository.findbyId(id);
	}
	
	public void deleteMarcheById(Long id) {
		marcheRepository.deleteById(id);
	}
	


	/*public List<Marche> listerMarcher(){
		return marcheRepository.findAll();

	}*/

	/*public Optional<Marche> findById(Long idMarche) {
		return marcheRepository.findById(idMarche);
	}*/
}
