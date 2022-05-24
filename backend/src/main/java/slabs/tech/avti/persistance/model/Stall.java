package slabs.tech.avti.persistance.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "stall")
@EntityListeners(AuditingEntityListener.class)
public class Stall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_name", nullable = false, unique = true)
	private String user_name;

	@Column(name = "latitude", nullable = false, unique = true)
	private double latitude;

	@Column(name = "longitude", nullable = false, unique = true)
	private String longitude;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Stall [id=" + id + ", user_name=" + user_name + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, latitude, longitude, user_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stall other = (Stall) obj;
		return id == other.id && Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
				&& Objects.equals(longitude, other.longitude) && Objects.equals(user_name, other.user_name);
	}

	
}
