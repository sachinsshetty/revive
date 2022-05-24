package slabs.tech.avti.persistance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "driver")
@EntityListeners(AuditingEntityListener.class)
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_generator")
	@SequenceGenerator(name = "driver_generator", sequenceName = "driver_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "user_name", nullable = false, unique = true)
	private String user_name;

	@Column(name = "first_name", nullable = false)
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "status", nullable = false)
	private Boolean status;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Boolean getStatus() {
		return status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
