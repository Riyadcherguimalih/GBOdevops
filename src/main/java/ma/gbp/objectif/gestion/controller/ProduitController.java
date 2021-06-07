package ma.gbp.objectif.gestion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ma.gbp.objectif.gestion.service.ProduitService;


@Controller
//@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/produits/")
	public String viewPageProduit() {
		System.out.println(produitService.FindMarcheFromProduit((long) 10));
		return "hello";
	}

	
	/*@GetMapping("")
	public 
	@GetMapping("all")
	public Set<Produit> getAllProduits() {
		System.out.println("the message : " + produitRepository.findAll().toString());
		return produitRepository.findAll();
	}*/

	/*@GetMapping("{idProduit}")
	public Optional<Produit> getProduitById(@PathVariable(value = "idProduit") Long idProduit) {
		return produitRepository.findById(idProduit);
	}*/

	/*@PostMapping("/")
	public Produit createMarche(@RequestBody Produit nouveauProduit) {
	    return produitRepository.save(nouveauProduit);
	}*/

}
