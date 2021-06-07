package ma.gbp.objectif.gestion.model.products;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ma.gbp.objectif.gestion.utils.Constants;


@Entity
@Table(name = "MARCHE")
public class Marche implements Serializable {

	
	private static final long serialVersionUID = 39296616233692132L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name="INTITULE_MARCHE")
	private String intitule;
	
	@Column(name="DESCRIPTION_MARCHE")
	private String description;
	/**
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATION", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;**/
	
	@OneToMany(targetEntity = Produit.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "marche", orphanRemoval = true)
	@JsonIgnore
	private List<Produit> produits ;
	
	public Marche() {
		
	}

	public Marche(Long id, String intitule, String description) {
		this.id=id;
		this.intitule = intitule;
		this.description = description;
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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Marche [id=" + id + ", intitule=" + intitule + ", description=" + description + ", produits=" + produits
				+ "]";
	}


	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(Constants.INITIAL_ODD_NUMBER, Constants.MULTIPLIER_ODD_NUMBER).append(id)
				.append(intitule).append(description).append(produits).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Marche))
			return false;
		if (obj == this)
			return true;
		
		Marche marche = (Marche) obj;

		return new EqualsBuilder().append(id, marche.id).append(intitule, marche.intitule)
				.append(description, marche.description)
				.append(produits, marche.produits).isEquals();

	}

	
	
}
