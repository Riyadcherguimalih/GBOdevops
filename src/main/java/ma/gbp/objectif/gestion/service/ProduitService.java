package ma.gbp.objectif.gestion.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.gbp.objectif.gestion.model.products.Marche;
import ma.gbp.objectif.gestion.model.products.Produit;
import ma.gbp.objectif.gestion.repository.ProduitRepository;

@Service
public class ProduitService {
	
	
	@Autowired
	private ProduitRepository produitRepository;
	
	public ProduitService(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
	}
	
	public List<Produit> TrouverLesProduitsFromMarcheID(Long id) {
		
		return produitRepository.findAllProduitFromMarche(id);	
	}
	
	public void supprimerProduit(Long id) {
		produitRepository.deleteProduitById(id);
	}
	
	public Produit FindMarcheFromProduit(Long id) {
		return produitRepository.TrouverMarcheDepuisProduitId(id);
	}
	
	
	
}
