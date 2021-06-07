package ma.gbp.objectif.gestion.model.objectif;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ma.gbp.objectif.gestion.utils.Constants;

@Entity
@Table(name ="REALISATION")
public class Realisation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_REALISATION")
	private Date dateRealisation;
	
	@Column(name="REALISATION_NOMBRE")
	private int realisation_nombre;
	
	@Column(name="REALISATION_MONTANT")
	private int realisation_montant;
		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OBJECTIF",
				referencedColumnName = "ID",
				nullable = false,
				unique = true)
	private Objectif objectif;

	public Realisation() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateRealisation() {
		return dateRealisation;
	}


	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}


	public int getRealisation_nombre() {
		return realisation_nombre;
	}


	public void setRealisation_nombre(int realisation_nombre) {
		this.realisation_nombre = realisation_nombre;
	}


	public int getRealisation_montant() {
		return realisation_montant;
	}


	public void setRealisation_montant(int realisation_montant) {
		this.realisation_montant = realisation_montant;
	}


	public Objectif getObjectif() {
		return objectif;
	}


	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	@Override
	public String toString() {
		return "Realisation [id=" + id + ", dateRealisation=" + dateRealisation + ", realisation_nombre="
				+ realisation_nombre + ", realisation_montant=" + realisation_montant + ", objectif=" + objectif + "]";
	}
	
	@Override
	public int hashCode() {

		return new HashCodeBuilder(Constants.INITIAL_ODD_NUMBER, Constants.MULTIPLIER_ODD_NUMBER).append(id)
				.append(dateRealisation).append(realisation_nombre).append(realisation_montant).append(objectif).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Realisation))
			return false;
		if (obj == this)
			return true;

		Realisation realisation = (Realisation) obj;
		return new EqualsBuilder().append(id, realisation.id)
				.append(dateRealisation, realisation.dateRealisation).append(realisation_nombre, realisation.realisation_nombre)
				.append(realisation_montant, realisation.realisation_montant).append(objectif, realisation.objectif).isEquals();

	}
	

	
	
	
	
}
