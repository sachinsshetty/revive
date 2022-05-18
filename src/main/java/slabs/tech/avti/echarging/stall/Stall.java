package slabs.tech.avti.echarging.stall;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "stall")
@EntityListeners(AuditingEntityListener.class)
public class Stall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "usage_time", nullable = false)
	private long usageTime;

	// private Map<Long,Double> rate;

	public long getUsageTime() {
		return usageTime;
	}

	public void setUsageTime(long usageTime) {
		this.usageTime = usageTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public Map<Long, Double> getRate() {
//		return rate;
//	}
//	public void setRate(Map<Long, Double> rate) {
//		this.rate = rate;
//	}
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

}
