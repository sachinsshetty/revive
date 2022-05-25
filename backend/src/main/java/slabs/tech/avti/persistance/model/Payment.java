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
@Table(name = "payment")
@EntityListeners(AuditingEntityListener.class)
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator")
	@SequenceGenerator(name = "payment_generator", sequenceName = "payment_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "user_name", nullable = false, unique = true)
	private String user_name;

	@Column(name = "gateway", nullable = false)
	private String gateway;

	@Column(name = "balance", nullable = false)
	private double balance;


}
