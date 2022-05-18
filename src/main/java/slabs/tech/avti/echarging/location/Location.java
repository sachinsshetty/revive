package slabs.tech.avti.echarging.location;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import slabs.tech.avti.echarging.coordinate.CoOrdinate;
import slabs.tech.avti.echarging.stall.Stall;

@Entity
@Table(name = "location")
@EntityListeners(AuditingEntityListener.class)
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
//	private List<Stall> stalls;
//	private CoOrdinate coordinate;
//
//	public CoOrdinate getCoordinate() {
//		return coordinate;
//	}
//
//	public void setCoordinate(CoOrdinate coordinate) {
//		this.coordinate = coordinate;
//	}
//
//	public List<Stall> getStalls() {
//		return stalls;
//	}
//
//	public void setStalls(List<Stall> stalls) {
//		this.stalls = stalls;
//	}

}
