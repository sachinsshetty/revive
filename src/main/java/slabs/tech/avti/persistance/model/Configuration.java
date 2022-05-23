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
@Table(name = "configuration")
@EntityListeners(AuditingEntityListener.class)
public class Configuration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "key", nullable = false, unique = true)
	private String key;

	@Column(name = "value", nullable = false)
	private String value;

	@Column(name = "status", nullable = false)
	private Boolean status;

	@Column(name = "version", nullable = false)
	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuration other = (Configuration) obj;
		return id == other.id && Objects.equals(key, other.key) && Objects.equals(status, other.status)
				&& Objects.equals(value, other.value) && version == other.version;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, key, status, value, version);
	}

	@Override
	public String toString() {
		return "Configuration [id=" + id + ", key=" + key + ", value=" + value + ", status=" + status + ", version="
				+ version + "]";
	}


}
