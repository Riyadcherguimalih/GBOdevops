package ma.gbp.objectif.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ma.gbp.objectif.gestion.model.products.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {
	public final static String FIND_PRODUITS_FROM_MARCHE_ID = "SELECT New Produit(produit.id, produit.intitule, produit.description) From Produit produit WHERE produit.marche.id = ?1 ";
	public final static String DELETE_PRODUIT_BY_ID = "DELETE FROM Produit produit WHERE produit.id = :idproduit";
	//public final static String FIND_ID_MARCHE_FROM_PRODUIT_ID = "SELECT p.marche FROM produit WHERE u.id = ?1";
	public final static String FIND_ID_MARCHE_FROM_PRODUIT_ID = "SELECT m FROM Produit m WHERE m.marche.id = ?1";


	@Query(FIND_ID_MARCHE_FROM_PRODUIT_ID)
	Produit TrouverMarcheDepuisProduitId(Long id);
	
	@Override
	void deleteById(Long id);
	
	@Query(FIND_PRODUITS_FROM_MARCHE_ID)
	List<Produit> findAllProduitFromMarche(Long id);
	
	//@Override
	@Transactional
	@Modifying
	@Query(DELETE_PRODUIT_BY_ID)
	void deleteProduitById(@Param("idproduit") Long id);
	
	
	
	
	
	
}
