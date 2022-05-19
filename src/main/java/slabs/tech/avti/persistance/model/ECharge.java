package slabs.tech.avti.persistance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "e_charge")
@EntityListeners(AuditingEntityListener.class)
public class ECharge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//TODO - renove temp variable

	@Column(name = "usage_time", nullable = false)
	private long usageTime;
	
	@ManyToOne
	private Location location;
	
	@ManyToOne
	private PowerProvider powerProvider;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public PowerProvider getPowerProvider() {
		return powerProvider;
	}

	public void setPowerProvider(PowerProvider powerProvider) {
		this.powerProvider = powerProvider;
	}

}
