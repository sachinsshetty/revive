package slabs.tech.avti.persistance.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "location")
@EntityListeners(AuditingEntityListener.class)
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany
	private List<Stall> stalls;
	@ManyToOne
	private CoOrdinate coordinate;
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
