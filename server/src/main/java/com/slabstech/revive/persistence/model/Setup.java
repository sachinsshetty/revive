package com.slabstech.revive.persistence.model;

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
@Table(name = "setup")
@EntityListeners(AuditingEntityListener.class)
public class Setup {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setup_generator")
	@SequenceGenerator(name = "setup_generator", sequenceName = "setup_id_seq", allocationSize = 1)
	@Column(name = "id")
	private long id;

	@Column(name = "type_name")
	private String type_name;

	@Column(name = "option_value")
	private String option_value;

	@Column(name = "use_case")
	private String use_case;

	@Column(name = "status")
	private Boolean status = true;

	@Column(name = "version")
	private long version=1;

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}


	

}
