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
@Table(name = "vehicle")
@EntityListeners(AuditingEntityListener.class)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_generator")
	@SequenceGenerator(name = "vehicle_generator", sequenceName = "vehicle_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "user_name", nullable = false, unique = true)
	private String user_name;

	@Column(name = "reg_no", nullable = false)
	private String reg_no;

	@Column(name = "status", nullable = false)
	private Boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
