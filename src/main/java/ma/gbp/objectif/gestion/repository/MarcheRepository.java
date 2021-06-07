package ma.gbp.objectif.gestion.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.gestion.model.products.Marche;
import ma.gbp.objectif.gestion.model.products.Produit;

@Repository
public interface MarcheRepository extends CrudRepository<Marche, Long> {
	public final static String FIND_ALL_MARCHE = " SELECT New Marche(marche.id, marche.intitule, marche.description) From Marche marche ";
//	public final static String FIND_PRODUITS_FROM_MARCHE_ID = "SELECT New Produit(produit.id, produit.intitule, produit.description) From Produit produit ";
	public final static String FIND_MARCHE_BY_ID = "SELECT New Marche(marche.id, marche.intitule, marche.description) From Marche marche WHERE marche.id = ?1";
	
	
	@Query(FIND_ALL_MARCHE)
	List<Marche> findAllMarche();
	
//	@Query(FIND_PRODUITS_FROM_MARCHE_ID)
	//	List<Produit> findAllProduitFromMarche(Long id);
	
	//@Query("SELECT New Marche(marche.id, marche.intitule, marche.description, marche.produits) From Marche marche WHERE marche.id = ?1")
	//Marche findMarcheById(Long id);
	
	@Query(FIND_MARCHE_BY_ID)
	Marche findbyId(Long id);
	
	
	
	
	//void delete(Long id);
	
	List<Marche> findAll(); 
	
}
