package ma.gbp.objectif.gestion.model.authentification;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ma.gbp.objectif.gestion.utils.Constants;

@Entity
@Table(name = "PROFILE")
public class Profile implements Serializable {

	private static final long serialVersionUID = 3364901876784015499L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERSION")
	private Date version;

	@Column(name = "NOM_PROFILE", unique = true, nullable = false)
	private String nomProfile;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "profile", orphanRemoval = true)
	private Set<Privilege> privileges;

	public Profile() {
		super();
	}

	public Profile(Long id, Date version, String nomProfile, Set<Privilege> privileges) {
		super();
		this.id = id;
		this.version = version;
		this.nomProfile = nomProfile;
		this.privileges = privileges;
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

	public String getNomProfile() {
		return nomProfile;
	}

	public void setNomProfile(String nomProfile) {
		this.nomProfile = nomProfile;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "Profil [id=" + id + ", version=" + version + ", nomProfile=" + nomProfile + ", privileges=" + privileges
				+ "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(Constants.INITIAL_ODD_NUMBER, Constants.MULTIPLIER_ODD_NUMBER).append(id)
				.append(version).append(nomProfile).append(privileges).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Profile))
			return false;
		if (obj == this)
			return true;

		Profile profil = (Profile) obj;

		return new EqualsBuilder().append(id, profil.id).append(version, profil.version)
				.append(nomProfile, profil.nomProfile).append(privileges, profil.privileges).isEquals();

	}

}
