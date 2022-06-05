package com.slabstech.revive.server.springboot.persistence.model;

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
@Table(name = "configuration")
@EntityListeners(AuditingEntityListener.class)
public class Configuration {


  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuration_generator")
  @SequenceGenerator(name="configuration_generator", sequenceName = "configuration_id_seq", allocationSize = 1)
  @Column(name = "id")
	private long id;

	@Column(name = "key")
	private String key;

	@Column(name = "value")
	private String value;

	@Column(name = "status")
	private int status= 1;

	@Column(name = "version")
	private int version= 1;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


}
