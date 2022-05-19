package slabs.tech.avti.persistance.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "vehicle")
@EntityListeners(AuditingEntityListener.class)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Driver driver;
	
	@ManyToOne
	private Battery battery;
	
	@ManyToOne
	private Autonomy autonomy;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public Vehicle(Driver driver, Battery battery, Autonomy autonomy) {
		super();
		this.driver = driver;
		this.battery = battery;
		this.autonomy = autonomy;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Autonomy getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(Autonomy autonomy) {
		this.autonomy = autonomy;
	}

}
