package ma.gbp.objectif.gestion.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import org.springframework.web.servlet.mvc.Controller;

import ma.gbp.objectif.gestion.model.products.Marche;
import ma.gbp.objectif.gestion.model.products.Produit;
import ma.gbp.objectif.gestion.repository.MarcheRepository;
import ma.gbp.objectif.gestion.repository.ProduitRepository;
import ma.gbp.objectif.gestion.service.MarcheService;
import ma.gbp.objectif.gestion.service.ProduitService;
@Controller
//@RequestMapping("/marche")
public class MarcheController {
	
	
	@Autowired
	private MarcheService marcheService;
	
	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		//List<Marche> listMarches = (List<Marche>)marcheService.listerMarcher();
		//model.addAttribute("listMarches", listMarches);
		return "index";
	}
	
	@GetMapping("/marche")
	// Retourne la page marché : affiche la liste des marchés presents dans des card
	// et permet d'ajouter ou modifier un marché déja present
	public String viewPageAllMarche(Model model) {
		List<Marche> listDesMarches = (List<Marche>)marcheService.findAllMarcheService();
		model.addAttribute("listDesMarches", listDesMarches);
		//System.out.println(marcheService.FindMarcheFromProduit((long) 144));
		return "marche";
	}
	
	// Affiche la page d'un marché précis, donne la main pour modifier ou supprimrer un marché et liste
	// les produits attachés à un marché
	
	
	@GetMapping("/marche/{idMarche}")
	public String viewPageSingleMarche(Model model, @PathVariable(value = "idMarche") Long id) {
		Marche marche = marcheService.findMarcheParId(id);
		model.addAttribute("SingleMarche", marche);
		
		List<Produit> listDesProduitsParMarche = produitService.TrouverLesProduitsFromMarcheID(id) ;
		//System.out.println(listDesProduitsParMarche);
		model.addAttribute("listDesProduits", listDesProduitsParMarche);
		return "unmarche";
	}
	
	
	@GetMapping("/marche/edit/{idMarche}")
	public String viewEditPageMarche(Model model, @PathVariable(value = "idMarche") Long id){
		return "edit_marche";
	}
	
	
	
	@GetMapping("/marche/delete/{idMarche}")
	public String supprimerMarche(@PathVariable(name = "idMarche") Long id) {
		
		marcheService.deleteMarcheById(id);
		return "redirect:/marche/{idMarche}";
	}
	
	
	@GetMapping("/marche/new_marche")
	public Marche ajouterNouveauMarche() {
		Marche marche = new Marche();
		return marche;
	}
	
	@GetMapping("/produit/delete/{idProduit}")
	public String deleteProduct(@PathVariable(name = "idProduit") Long id,Model model ) {
		System.out.println("l'id du produit : " + id);
		//find marche id from produit id !! 
		
		//delete produit from id
		
		//show list of all products of marche
		produitService.supprimerProduit(id);
		
		List<Marche> listDesMarches = (List<Marche>)marcheService.findAllMarcheService();
		model.addAttribute("listDesMarches", listDesMarches);
		return "marche";
	}
	


/**	@GetMapping("/marche/all")
	public List<Marche> trouverToutMarche(){
		System.out.println("the message : " + marcheService.findAllMarcheService());
		return marcheService.findAllMarcheService();
	}
	**/
	
	/**@GetMapping("all")
	public Set<Marche> getAllMarche() {
		//System.out.println("the message : " + marcheRepository.findAll().toString());
		return marcheService.findAll();
	}**/
	
	/***@GetMapping("{idMarche}")
	public Optional<Marche> getMarcheById(@PathVariable(value = "idMarche") Long idMarche) {
		return marcheService.findById(idMarche);
	}***/
	
	/**@PostMapping("/")
	public Marche createMarche(@RequestBody Marche nouveauMarche) {
	    return marcheService.ajouterMarcher(nouveauMarche);
	}**/
	
	/**
	@GetMapping("produit")
	public Iterable<Produit> getProduits(){
		return produitRepository.findAll();
	}
	**/
		
}

