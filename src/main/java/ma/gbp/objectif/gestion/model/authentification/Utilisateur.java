package ma.gbp.objectif.gestion.model.authentification;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ma.gbp.objectif.gestion.model.objectif.Objectif;
import ma.gbp.objectif.gestion.utils.Constants;


@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = -5910992714197618960L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERSION")
	private Date version;

	@Column(name = "MATRICULE")
	private String matricule;

	@Embedded
	private Entite entite;

	@ManyToOne(fetch = FetchType.EAGER)
	private Profile profil;
	
	@OneToOne(mappedBy = "utilisateur")
	private Objectif objectif;

	public Utilisateur() {
		super();
	}

	public Utilisateur(Date version, String matricule, Profile profil) {
		super();
		this.version = version;
		this.matricule = matricule;
		this.profil = profil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Profile getProfil() {
		return profil;
	}

	public void setProfil(Profile profil) {
		this.profil = profil;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", version=" + version + ", matricule=" + matricule + ", profil=" + profil + "]";
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(Constants.INITIAL_ODD_NUMBER, Constants.MULTIPLIER_ODD_NUMBER).append(id)
				.append(version).append(profil).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Utilisateur))
			return false;
		if (obj == this)
			return true;

		Utilisateur user = (Utilisateur) obj;
		return new EqualsBuilder().append(id, user.id).append(version, user.version).append(profil, user.profil)
				.append(matricule, user.matricule).isEquals();

	}

}
