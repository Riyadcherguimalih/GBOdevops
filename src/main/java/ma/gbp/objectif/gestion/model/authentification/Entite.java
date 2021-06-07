package ma.gbp.objectif.gestion.model.authentification;

import java.io.Serializable;
import javax.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ma.gbp.objectif.gestion.utils.Constants;

@Embeddable
public class Entite implements Serializable {

	private static final long serialVersionUID = 3577482962200251185L;

	@Column(name = "AGENCE")
	private String agence;
	
	@Column(name = "LIBELLE_AGENCE")
	private String libelle_agence;

	@Column(name = "SUCCURSALE")
	private String succursale;
	
	@Column(name = "LIBELLE_SUCCURSALE")
	private String libelle_succursale;
	
	@Column(name = "BANQUE_CODE")
	private String banque_code;

	@Column(name = "BPR")
	private String bpr;
	
	@Column(name = "LIBELLE_BPR")
	private String libelle_bpr;
	


	public Entite() {
		super();
	}

	public Entite(String agence, String succursale, String bpr) {
		super();
		this.agence = agence;
		this.succursale = succursale;
		this.bpr = bpr;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getBpr() {
		return bpr;
	}

	public void setBpr(String bpr) {
		this.bpr = bpr;
	}

	public String getSuccursale() {
		return succursale;
	}

	public void setSuccursale(String succursale) {
		this.succursale = succursale;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Entite))
			return false;
		if (obj == this)
			return true;

		Entite entite = (Entite) obj;
		return new EqualsBuilder().append(agence, entite.agence).append(bpr, entite.bpr)
				.append(succursale, entite.succursale).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(Constants.INITIAL_ODD_NUMBER, Constants.MULTIPLIER_ODD_NUMBER).append(agence)
				.append(bpr).append(succursale).toHashCode();
	}

	@Override
	public String toString() {
		return "Entite [agence=" + agence + ", libelle_agence=" + libelle_agence + ", succursale=" + succursale
				+ ", libelle_succursale=" + libelle_succursale + ", bpr=" + bpr + ", libelle_bpr=" + libelle_bpr + "]";
	}

	

}