package ma.gbp.objectif.gestion.model.authentification;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "PRIVILEGES_PROFIL")
public class Privilege implements Serializable {

	private static final long serialVersionUID = 8762943373265690499L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERSION")
	private Date version;

	@Column(name = "DROIT")
	private Droit droit;

	@ManyToOne(targetEntity = Profile.class)
	@JoinColumn(name = "PROFILE_ID", nullable = false)
	private Profile profile;

	public Privilege() {
		super();
	}

	public Privilege(Droit droit) {
		super();
		this.droit = droit;
	}

	public Privilege(Long id, Droit droit) {
		super();
		this.id = id;
		this.droit = droit;
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

	public Droit getDroit() {
		return droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", version=" + version + ", droit=" + droit + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(Constants.INITIAL_ODD_NUMBER, Constants.MULTIPLIER_ODD_NUMBER).append(id)
				.append(version).append(droit).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Privilege))
			return false;
		if (obj == this)
			return true;

		Privilege privilege = (Privilege) obj;

		return new EqualsBuilder().append(id, privilege.id).append(version, privilege.version)
				.append(droit, privilege.droit).isEquals();

	}
}
