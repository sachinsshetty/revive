package com.slabstech.revive.server.springboot.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

	@NotBlank(message = "Name must not be blank")
	@Size(min = 2, max = 50)
	@Column(name = "name")
	private String name;

	@NotBlank(message = "Otion_value must not be blank")
	@Size(min = 2, max = 50)
	@Column(name = "option_value")
	private String option_value;


	@NotBlank(message = "Use Case must not be blank")
	@Size(min = 4, max = 50)
	@Column(name = "use_case")
	private String use_case;

	@Min(value = 0, message = "Set to 0, if disabled")
	@Max(value = 1, message = "Set to 1, if enabled")
	@Column(name = "status")
	private long status = 1;

	@Min(value = 1, message = "Set to 1, For initiation")
	@Max(value = 100)
	@Column(name = "version")
	private long version=1;

	public Setup(){
	}
    public Setup(String name) {
		this.name = name;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOption_value() {
		return option_value;
	}

	public void setOption_value(String option_value) {
		this.option_value = option_value;
	}

	public String getUse_case() {
		return use_case;
	}

	public void setUse_case(String use_case) {
		this.use_case = use_case;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}


}
