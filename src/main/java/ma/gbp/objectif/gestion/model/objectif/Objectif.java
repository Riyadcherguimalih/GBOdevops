package ma.gbp.objectif.gestion.model.objectif;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ma.gbp.objectif.gestion.model.authentification.Entite;
import ma.gbp.objectif.gestion.model.authentification.Utilisateur;
import ma.gbp.objectif.gestion.model.products.Produit;
import ma.gbp.objectif.gestion.utils.Constants;

@Entity
public class Objectif implements Serializable {
	

	private static final long serialVersionUID = -3866544643345205580L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATION")
	private Date dateCreation;
	
	@Column(name ="VALEUR_NOMBRE")
	private Long valeur_nombre;
	
	@Column(name = "VALEUR_MONTANT")
	private Long valeur_montant;
		
	@Column(name = "ANNEE", unique = true, nullable = false)
	private Long annee;
	
	@Column(name = "CREATEUR")
	private String createur;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "ID")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "objectif", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Realisation> realisations;
	
	@Column(name = "MODIFICATEUR")
	private String modificateur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUIT_ID",
				referencedColumnName = "ID",
				nullable = false,
				unique = true)
	private Produit produitObjectif;

	@Override
	public String toString() {
		return "Objectif [id=" + id + ", dateCreation=" + dateCreation + ", valeurNb=" + valeur_nombre + ", ValeurMnt="
				+ valeur_montant + ", annee=" + annee + ", createur=" + createur + ", realisations="
				+ realisations + ", modificateur=" + modificateur + ", produitObjectif=" + produitObjectif + "]";
	}
	
	
	@Override
	public int hashCode() {

		return new HashCodeBuilder(Constants.INITIAL_ODD_NUMBER, Constants.MULTIPLIER_ODD_NUMBER).append(id)
				.append(dateCreation).append(valeur_nombre).append(valeur_montant).append(annee).append(createur)
				.append(realisations).append(modificateur).append(produitObjectif).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Objectif))
			return false;
		if (obj == this)
			return true;

		Objectif objectif = (Objectif) obj;
		return new EqualsBuilder().append(id, objectif.id)
				.append(dateCreation, objectif.dateCreation).append(valeur_nombre, objectif.valeur_nombre).append(valeur_montant, objectif.valeur_montant).append(annee, objectif.annee)
				.append(createur,objectif.createur).append(realisations, objectif.realisations).append(modificateur, objectif.modificateur)
				.append(produitObjectif, objectif.produitObjectif).isEquals();

	}
	

}