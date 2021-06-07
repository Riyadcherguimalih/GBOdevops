package ma.gbp.objectif.gestion.model.products;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ma.gbp.objectif.gestion.model.objectif.Objectif;
import ma.gbp.objectif.gestion.model.objectif.Realisation;

@Entity
@Table(name = "PRODUIT")
public class Produit implements Serializable {
	

	private static final long serialVersionUID = 2190680422132690495L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
/**	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATION", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;**/
	
	@Column(name = "INTITUTE_PRODUIT")
	private String intitule;
	
	@Column(name = "DESCRIPTION_PRODUIT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "MARCHE_ID", referencedColumnName = "ID", nullable = false)
	private Marche marche;
	
	/*@OneToOne
	@JoinColumn(name = "REALISATION_ID", nullable = true, unique = true)
	private Realisation realisation;*/
	
	@OneToMany(mappedBy = "produitObjectif",
			   cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY)
	private Set<Objectif> objectifs;
	
	public Produit() {
		
	}
	
	public Produit(Long id, String intitule, String description) {
		this.id = id;
		this.intitule = intitule;
		this.description = description;
	}
	
	public Produit(Long id, Long marcheid) {
		this.id = id;
		this.marche.setId(marcheid);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Marche getMarche() {
		return marche;
	}

	public void setMarche(Marche marche) {
		this.marche = marche;
	}

	public Set<Objectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(Set<Objectif> objectifs) {
		this.objectifs = objectifs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", intitule=" + intitule + ", description=" + description + ", marche=" + marche
				+ ", objectifs=" + objectifs + "]";
	}
	
	
	
	
	
	

}
